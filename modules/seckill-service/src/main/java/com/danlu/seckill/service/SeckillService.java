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

    /**
     * 秒杀商品计数器,
     * 秒杀参数id的商品，
     * @param id
     * @return  <= 0 ：表示没有商品，秒杀失败
     */
    int seckill(int id);

}
