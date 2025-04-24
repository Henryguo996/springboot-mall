package com.guohenry.springbootmall.controller;

import com.guohenry.springbootmall.dto.CreateOrderRequest;
import com.guohenry.springbootmall.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class OrderController {

    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){
       Integer orderId = orderService.createOrder(userId, createOrderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);

    }

}
