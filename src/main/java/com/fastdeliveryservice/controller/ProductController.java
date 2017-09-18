package com.fastdeliveryservice.controller;

import com.fastdeliveryservice.domain.OrderDto;
import com.fastdeliveryservice.domain.ProductDto;
import com.fastdeliveryservice.domain.ProductRestaurantDto;

import com.fastdeliveryservice.service.ProductService;
import com.fastdeliveryservice.viewModel.OrderViewModel;
import com.fastdeliveryservice.viewModel.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

/**
 * Created by Martina Gabellini
 */

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
            this.productService = productService;
    }

    @RequestMapping(value = "/product/{Id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ProductViewModel>> getProductByIdRpc(@PathVariable("Id") int id){
        ProductDto productDto = productService.getProductById(id);

        Map<String, ProductViewModel> result = new HashMap<>();

        ProductViewModel view = new ProductViewModel();
        view.setId(productDto.getId());
        view.setIngredients(productDto.getIngredients());
        view.setName(productDto.getName());

        result.put("product", view);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody ProductViewModel product, UriComponentsBuilder builder) {

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setIngredients(product.getIngredients());
        productDto.setPrice(product.getPrice());

        boolean flag = productService.add(productDto);

        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/product/{id}").buildAndExpand(productDto.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public ResponseEntity<Void> update() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


   /* @PutMapping("article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }*/
    @RequestMapping(value = "/order/drop", method = RequestMethod.POST)
    public ResponseEntity<Void> delete() {

     // TODO:   OrderRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}