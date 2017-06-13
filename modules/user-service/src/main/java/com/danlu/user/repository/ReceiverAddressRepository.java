package com.danlu.user.repository;

import com.danlu.user.entity.ReceiverAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/6/13.
 */
@Repository
public interface ReceiverAddressRepository extends JpaRepository<ReceiverAddress, Integer> {
}
