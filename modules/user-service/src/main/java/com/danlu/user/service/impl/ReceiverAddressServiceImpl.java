package com.danlu.user.service.impl;

import com.danlu.user.entity.ReceiverAddress;
import com.danlu.user.repository.ReceiverAddressRepository;
import com.danlu.user.service.ReceiverAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/6/13.
 */
@Service
public class ReceiverAddressServiceImpl implements ReceiverAddressService {

    private ReceiverAddressRepository receiverAddressRepository;

    @Override
    public List<ReceiverAddress> findAll() {
        return receiverAddressRepository.findAll();
    }
}
