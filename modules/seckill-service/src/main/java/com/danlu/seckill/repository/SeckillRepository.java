package com.danlu.seckill.repository;

import com.danlu.seckill.entity.Seckill;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/6/11.
 */
@Repository
public interface SeckillRepository extends PagingAndSortingRepository<Seckill, Integer>, JpaSpecificationExecutor<Seckill> {

}
