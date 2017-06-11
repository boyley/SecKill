package com.danlu.seckill.service;

import com.danlu.seckill.entity.Seckill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 秒杀服务
 * Created by lenovo on 2017/6/10.
 */
public interface SeckillService {

    /**
     * 分页获取秒杀商品列表
     *
     * @param pageable
     * @return
     */
    Page<Seckill> list(Pageable pageable);

    /**
     * 获取商品的库存
     *
     * @param id
     * @return
     */
    int getStock(int id);

}
