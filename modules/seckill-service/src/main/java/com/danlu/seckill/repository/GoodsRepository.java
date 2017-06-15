package com.danlu.seckill.repository;

import com.danlu.seckill.entity.Goods;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/6/12.
 */
@Repository
public interface GoodsRepository extends PagingAndSortingRepository<Goods, Integer> {

}
