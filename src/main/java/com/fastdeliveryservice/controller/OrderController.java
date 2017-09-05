package com.fastdeliveryservice.controller;

import com.fastdeliveryservice.domain.OrderDto;
import com.fastdeliveryservice.domain.OrderView;
import com.fastdeliveryservice.domain.ProductRestaurantDto;
import com.fastdeliveryservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martina Gabellini
 */

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService)
    {
            this.orderService = orderService;
    }

    @RequestMapping(value = "/order/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<OrderDto>>> getOrdersByUserIdRpc(@PathVariable("userId") int userId){

        List<OrderDto> results = orderService.getOrderByUserId(userId);
        return new ResponseEntity<>(Collections.singletonMap("orders", results), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{Id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, OrderDto>> getOrderByIdRpc(@PathVariable("Id") int id){

        OrderDto orderDto = orderService.getOrderById(id);

        Map<String, OrderDto> result = new HashMap<>();
        result.put("order", orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(value = "/order/drop", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateOrder() {

        // TODO:   OrderRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    //public ResponseEntity<Void> addOrder(@PathVariable("IdsProductRestaurant") List<Integer> idsProductRestaurant, @PathVariable("deliveryType") String deliveryType, UriComponentsBuilder builder) {
    public ResponseEntity<Void> addOrder(@RequestBody OrderView order, UriComponentsBuilder builder) {

        OrderDto orderdto = new OrderDto();
        for (Integer id : order.getProducts()) {
            ProductRestaurantDto productRestaurantDto = new ProductRestaurantDto();
            productRestaurantDto.setId(id);
            orderdto.getProductRestaurants().add(productRestaurantDto);
        }
        orderdto.setDeliveryType(order.getDeliveryType());

        boolean flag = orderService.add(orderdto);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/order/{id}").buildAndExpand(orderdto.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

   /* @PutMapping("article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }*/
    @RequestMapping(value = "/order/drop", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteAllOrders() {

     // TODO:   OrderRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}