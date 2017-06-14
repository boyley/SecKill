package com.danlu.seckill.service.impl;

import com.danlu.seckill.entity.Seckill;
import com.danlu.seckill.repository.SeckillRepository;
import com.danlu.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    @Cacheable(value = "goods", keyGenerator = "keyGenerator")
    public Seckill findOneByGoodsId(int goodsId) {
        Seckill seckill = this.seckillRepository.findOne((root, query, cb) ->
                cb.and(cb.greaterThan(root.get("endTime").as(LocalDateTime.class), LocalDateTime.now()),
                        cb.lessThan(root.get("startTime").as(LocalDateTime.class), LocalDateTime.now()),
                        cb.equal(root.get("goodsId").as(Integer.class), goodsId)
                )
        );

        return seckill;
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
