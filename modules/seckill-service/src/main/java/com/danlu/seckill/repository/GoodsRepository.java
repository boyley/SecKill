package com.danlu.seckill.repository;

import com.danlu.seckill.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/6/12.
 */
@Repository
public interface GoodsRepository extends CrudRepository<Goods, Integer> {

    Page<Goods> findAll(Pageable pageable);
}
