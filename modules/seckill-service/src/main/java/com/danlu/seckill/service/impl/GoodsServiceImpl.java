package com.danlu.seckill.service.impl;

import com.danlu.seckill.entity.Goods;
import com.danlu.seckill.entity.Seckill;
import com.danlu.seckill.repository.GoodsRepository;
import com.danlu.seckill.service.GoodsService;
import com.danlu.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/6/12.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private SeckillService seckillService;

    @Override
    public Page<Goods> list(Pageable pageable) {
        Page<Goods> page = goodsRepository.findAll(pageable);
        page.getContent().stream().filter(goods -> goods.isSeckill()).forEach(goods -> {
            Seckill seckill = this.seckillService.findOneByGoodsId(goods.getId());
            if (seckill == null) {
                goods.setSeckill(false);
                this.goodsRepository.save(goods);
            }
            goods.setSeckilled(seckill);
        });
        return page;
    }
}
