package com.gzw.service;

import com.gzw.domain.Token;

import java.util.UUID;

/**
 * Created by gujian on 2017/7/7.
 */
public interface RedisTokenService {

    Token create(String username);

    Token getToken(String authentication);

    boolean checkToken(Token token);
}
