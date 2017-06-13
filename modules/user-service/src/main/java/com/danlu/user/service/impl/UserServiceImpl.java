package com.danlu.user.service.impl;

import com.danlu.user.entity.ReceiverAddress;
import com.danlu.user.service.ReceiverAddressService;
import com.danlu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/6/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ReceiverAddressService receiverAddressService;

    @Override
    public List<ReceiverAddress> findAllReceiverAddress(int id) {
        return receiverAddressService.findAll(id);
    }
}
