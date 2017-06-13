package com.danlu.user.service.impl;

import com.danlu.user.entity.ReceiverAddress;
import com.danlu.user.repository.ReceiverAddressRepository;
import com.danlu.user.service.ReceiverAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/6/13.
 */
@Service
public class ReceiverAddressServiceImpl implements ReceiverAddressService {

    @Autowired
    private ReceiverAddressRepository receiverAddressRepository;

    @Override
    public List<ReceiverAddress> findAll(int id) {
        return receiverAddressRepository.findAll((root, query, cb) -> cb.and(
                cb.equal(root.get("userId").as(Integer.class), id)
        ));
    }
}
