package com.danlu.seckill.service.impl;

import com.danlu.seckill.entity.Seckill;
import com.danlu.seckill.repository.SeckillRepository;
import com.danlu.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/6/11.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String prefix = "seckilled:";

    @Autowired
    private SeckillRepository seckillRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @Cacheable(value = "seckill",keyGenerator = "keyGenerator")
    public Page<Seckill> list(Pageable pageable) {
        Page<Seckill> page = seckillRepository.findAll(pageable);
        page.getContent().forEach(seckill -> {
            if (!this.hasKey(seckill.getId())) {
                redisTemplate.opsForValue().set(this.getSeckillKey(seckill.getId()), seckill.getStock());
            }

        });
        return page;
    }

    private boolean hasKey(int id) {
        return this.redisTemplate.opsForValue().getOperations().hasKey(this.getSeckillKey(id));
    }

    @Override
    public int getStock(int id) {
        return (int) redisTemplate.opsForValue().get(getSeckillKey(id));
    }

    /**
     * 秒杀商品计数器
     *
     * @param id
     * @return
     */
    @Override
    public int seckill(int id) {
        long seckill = redisTemplate.opsForValue().increment(getSeckillKey(id), -1);
        return (int) seckill;
    }

    private String getSeckillKey(int id) {
        String key = prefix.concat(String.valueOf(id));
        return key;
    }
}
