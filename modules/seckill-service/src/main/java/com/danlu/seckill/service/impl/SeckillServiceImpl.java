package com.danlu.seckill.service.impl;

import com.danlu.seckill.entity.Seckill;
import com.danlu.seckill.repository.SeckillRepository;
import com.danlu.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by lenovo on 2017/6/11.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillRepository seckillRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Page<Seckill> list(Pageable pageable) {
        Page<Seckill> page = seckillRepository.findAll(pageable);

        page.getContent().forEach(seckill -> seckill.setStock(applicationContext.getBean(SeckillService.class).getStock(seckill.getId())));
        return page;
    }

    @Override
    @Cacheable(value = "usercache",keyGenerator = "keyGenerator")
    public int getStock(int id) {
        Optional<Seckill> optional = this.seckillRepository.findOne(id);
        return optional.map(seckill -> seckill.getStock()).orElse(0);
    }

    private int incr(int id) {
        String key = "seckill:" + id;
        redisTemplate.in
    }
}
