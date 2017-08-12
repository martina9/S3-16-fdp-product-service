package com.fastdeliveryservice.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;
/**
 * Created by Martina on 31/07/2017.
 */
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class Location {

        @Id
        private String id;

        private String city;
        private String name;
        private double coordinateX;
        private double coordinateY;

    public Location() {
    }

        public Location(double coordinateX, double coordinateY , String city, String name) {
            this.city = city;
            this.name = name;
            this.coordinateX = coordinateX;
            this.coordinateY = coordinateY;
        }

        public String getId() {
            return id;
        }

        public String city() {
            return city;
        }

        public String name() {
            return name;
        }


        public double coordinateY() {
            return coordinateY;
        }

        public double coordinateX() {
            return coordinateX;
        }

        @Override
        public String toString() {
            return String.format("%s (%s)", name(), city);
        }
    }
