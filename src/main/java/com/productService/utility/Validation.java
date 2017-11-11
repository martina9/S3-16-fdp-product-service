package com.productService.utility;

/**
 * @author  mGabellini
 */

public abstract class Validation {
    public static void notNull(Object obj) {
        if(obj == null) {
            throw new IllegalArgumentException("[Validation failed] - the object argument must not be null");
        }
    }
}