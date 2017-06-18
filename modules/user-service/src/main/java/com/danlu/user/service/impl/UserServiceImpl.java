package com.danlu.user.service.impl;

import com.danlu.user.entity.ReceiverAddress;
import com.danlu.user.entity.User;
import com.danlu.user.repository.UserRepository;
import com.danlu.user.service.ReceiverAddressService;
import com.danlu.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by lenovo on 2017/6/13.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ReceiverAddressService receiverAddressService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ReceiverAddress> findAllReceiverAddress(int id) {
        return receiverAddressService.findAll(id);
    }
}
