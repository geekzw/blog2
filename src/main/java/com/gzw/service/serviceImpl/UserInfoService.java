package com.gzw.service.serviceImpl;

import com.gzw.domain.UserInfo;
import com.gzw.mappers.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gujian on 2017/6/29.
 */
@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo getUserInfo(String username){

        return userInfoMapper.getUserInfoByName(username);
    }

}
