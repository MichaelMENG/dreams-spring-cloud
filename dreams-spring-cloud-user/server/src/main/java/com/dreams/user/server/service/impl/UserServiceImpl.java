package com.dreams.user.server.service.impl;

import com.dreams.user.server.dataobject.UserInfo;
import com.dreams.user.server.repository.UserInfoRepository;
import com.dreams.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
