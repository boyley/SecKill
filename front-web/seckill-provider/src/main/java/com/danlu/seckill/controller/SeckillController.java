package com.danlu.seckill.controller;

import com.danlu.seckill.entity.Seckill;
import com.danlu.seckill.service.SeckillService;
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
    private SeckillService seckillService;

    @GetMapping(value = "/list")
    Page<Seckill> list(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return seckillService.list(pageable);
    }
}