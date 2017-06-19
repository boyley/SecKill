package com.danlu.seckill.controller;

import com.danlu.seckill.controller.vm.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lenovo on 2017/6/19.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 创建订单
     *
     * @param token
     * @param orderRequests
     * @return
     */
    @PostMapping("/create")
    ResponseEntity<?> create(@RequestHeader(name = "X-Authorization") String token, List<OrderRequest> orderRequests) {
        return null;
    }
}
