package com.fastdeliveryservice.service;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastdeliveryservice.domain.LocationView;
//import com.locationapi.location.repository.LocationRepository;
import com.fastdeliveryservice.domain.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

/**
 * Created by Martina on 31/07/2017.
 */

@Service
public class LocationService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    private RabbitTemplate rabbitTemplate;

    private DirectExchange directExchange;

   // private LocationRepository locationRepository;

    @Autowired
    public LocationService(Environment environment,
                                RabbitTemplate rabbitTemplate,
                                DirectExchange directExchange)
    //                          LocationRepository locationRepository)
    {

        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
     //   this.locationRepository = locationRepository;
    }

    /**
     * Produces HTTP GET request containing election
     * Location service returns a list of candidates
     * * @param election
     *
     * @return List of candidates
     */
    public List<LocationView> getLocationsSyncHttp(double coordinateX, double coordinateY) {
        String candidateServiceHostname = environment.getProperty("services.location.host");
        String candidateServicePort = environment.getProperty("services.location.port");
        String candidateContextPath = environment.getProperty("services.location.context-path");
        String candidateServiceResourceUrl = String.format("http://%s:%s/%s/candidates/search/findByCoordinates?x=%s&y=%s",
                candidateServiceHostname, candidateServicePort, candidateContextPath, coordinateX, coordinateY);

        RestTemplate restTemplate = restTemplate();

        ResponseEntity<PagedResources<LocationView>> responseEntity = restTemplate.exchange(
                candidateServiceResourceUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<PagedResources<LocationView>>() {
                });
        PagedResources<LocationView> resources = responseEntity.getBody();

        return new ArrayList(resources.getContent());
    }

    private RestTemplate restTemplate() {
        // reference: http://izeye.blogspot.com/2015/01/consume-spring-data-rest-hateoas-hal.html
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new Jackson2HalModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);
        return new RestTemplate(Arrays.asList(converter));
    }

    /**
     * Produces query message containing election
     * Consumes location list based on election query
     *
     * @param coordinateX
     * @param coordinateY
     * @return List of locations
     */
    @SuppressWarnings("unchecked")
    public List<LocationView> getCandidatesMessageRpc(double coordinateX, double coordinateY) {
        logger.debug("Sending RPC request message for list of candidates...");

        CoordinateMessage coordinateMessage = new CoordinateMessage();
        coordinateMessage.setCoordinateY(coordinateY);
        coordinateMessage.setCoordinateX(coordinateX);
        String candidates = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "rpc", coordinateMessage);

        TypeReference<Map<String, List<LocationView>>> mapType =
                new TypeReference<Map<String, List<LocationView>>>() {
                };

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, List<LocationView>> candidatesMap = new HashMap<>();

        try {
            candidatesMap = objectMapper.readValue(candidates, mapType);
        } catch (IOException e) {
            logger.info(String.valueOf(e));
        }

        List<LocationView> candidatesList = candidatesMap.get("candidates");

        if (logger.isDebugEnabled()) {
            logger.debug("List of {} candidates received...", candidatesList.size());
        }

        return candidatesList;
    }

    /**
     * Consumes a new location message, deserializes, and save to MongoDB
     *
     * @param coordinateMessage
     */
    @RabbitListener(queues = "#{locationQueue.name}")
    public void getLocationMessage(String coordinateMessage) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        TypeReference<Location> mapType = new TypeReference<Location>() {};

        Location location = null;

        try {
            location = objectMapper.readValue(coordinateMessage, mapType);
        } catch (IOException e) {
            logger.info(String.valueOf(e));
        }

      //TODO  locationRepository.save(location);
        if (logger.isDebugEnabled()) {
            logger.debug("Location {} saved to MongoDB", location.toString());
        }
    }

    public class CoordinateMessage
    {
        private double coordinateX;

        private double coordinateY;

        public double getCoordinateX() {
            return coordinateX;
        }

        public void setCoordinateX(double coordinateX) {
            this.coordinateX = coordinateX;
        }

        public double getCoordinateY() {
            return coordinateY;
        }

        public void setCoordinateY(double coordinateY) {
            this.coordinateY = coordinateY;
        }
    }
}