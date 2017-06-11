package com.danlu.seckill.repository;

import com.danlu.seckill.entity.Seckill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Created by lenovo on 2017/6/11.
 */
public interface SeckillRepository extends PagingAndSortingRepository<Seckill, Integer> {

    Optional<Seckill> findOne(int id);

}
