package com.danlu.seckill.controller;

import com.danlu.seckill.entity.Goods;
import com.danlu.seckill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lenovo on 2017/6/11.
 */
@RequestMapping("/seckill")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "/list")
    Page<Goods> list(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return goodsService.list(pageable);
    }
}
