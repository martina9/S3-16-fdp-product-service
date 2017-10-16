package com.productService.utility;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Martina on 01/10/2017.
 */
public class Mapper {

    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }
}
