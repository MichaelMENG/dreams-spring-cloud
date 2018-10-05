package com.dreams.user.server.service;

import com.dreams.user.server.dataobject.UserInfo;

public interface UserService {

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);

}
