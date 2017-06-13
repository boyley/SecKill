package com.danlu.seckill.service;

import com.danlu.seckill.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by lenovo on 2017/6/12.
 */
public interface GoodsService {

    Page<Goods> list(Pageable pageable);
}
