package com.danlu.user.repository;

import com.danlu.user.entity.ReceiverAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/6/13.
 */
@Repository
public interface ReceiverAddressRepository extends CrudRepository<ReceiverAddress, Integer>, JpaSpecificationExecutor<ReceiverAddress> {
}
