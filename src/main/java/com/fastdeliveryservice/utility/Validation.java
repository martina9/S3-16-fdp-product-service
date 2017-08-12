package com.fastdeliveryservice.utility;

/**
 * Created by Martina on 11/08/2017.
 */
public abstract class Validation {

    /**
     *  Validation Null
     *
     * @param obj
     */
    public static void notNull(Object obj) {
        if(obj == null) {
            throw new IllegalArgumentException("[Validation failed] - the object argument must not be null");
        }
    }
}