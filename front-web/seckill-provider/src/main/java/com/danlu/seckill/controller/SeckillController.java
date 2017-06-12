package com.danlu.seckill.controller;

import com.danlu.seckill.service.GoodsService;
import com.danlu.seckill.service.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lenovo on 2017/6/11.
 */
@RestController("/seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "/list")
    Page<GoodsDto> list(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return goodsService.list(pageable);
    }
}
