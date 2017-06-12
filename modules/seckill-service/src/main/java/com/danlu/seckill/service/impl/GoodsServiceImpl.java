package com.danlu.seckill.service.impl;

import com.danlu.seckill.entity.Goods;
import com.danlu.seckill.repository.GoodsRepository;
import com.danlu.seckill.service.GoodsService;
import com.danlu.seckill.service.SeckillService;
import com.danlu.seckill.service.dto.GoodsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Page<GoodsDto> list(Pageable pageable) {
        Page<Goods> page = goodsRepository.findAll(pageable);
        List<GoodsDto> list = page.getContent().stream().map(goods -> {
            GoodsDto goodsDto = new GoodsDto();
            BeanUtils.copyProperties(goods, goodsDto);
            return goodsDto;
        }).collect(Collectors.toList());
        list.stream().filter(goodsDto ->
                goodsDto.isSeckill()).map(goodsDto -> {
            goodsDto.setSeckillDto(
                    seckillService.findOneByGoodsId(goodsDto.getId()).orElseThrow(() -> new RuntimeException(""))
            );
            return goodsDto;
        });
        Page<GoodsDto> result = new PageImpl<>(list);
        BeanUtils.copyProperties(page, result, new String[]{"content"});
        return result;
    }
}
