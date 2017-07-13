package com.gzw.mappers;

import com.gzw.domain.UserInfo;

/**
 * Created by gujian on 2017/6/29.
 */
public interface UserInfoMapper {

    UserInfo getUserInfoByName(String username);

    boolean updateUserInfo(UserInfo userInfo);

    boolean insertUserInfo(UserInfo userInfo);
}
