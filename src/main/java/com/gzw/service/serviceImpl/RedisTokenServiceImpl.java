package com.gzw.service.serviceImpl;

import com.gzw.domain.Token;
import com.gzw.service.RedisTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by gujian on 2017/7/7.
 */
@Component
public class RedisTokenServiceImpl implements RedisTokenService{

    @Autowired
    RedisTemplate redisTemplate;

    public Token create(String username){

        String strToken = UUID.randomUUID().toString().replace("-","");
        Token token =  new Token(username,strToken);
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(username,token);
        return token;

    }

    @Override
    public Token getToken(String authentication) {
        if (authentication == null || authentication.length () == 0) {
            return null;
        }
        String [] param = authentication.split ("_");
        if (param.length != 2) {
            return null;
        }
        // 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
        String token = param [1];
        return new Token (param[0], param[1]);
    }

    @Override
    public boolean checkToken(Token token) {
        if(token == null) return false;
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        Token tokenTemp = (Token) valueOperations.get(token.getUsername());

        if (tokenTemp == null || !tokenTemp.getToken().equals(token.getToken())) {
            return false;
        }

        redisTemplate.boundValueOps(token.getUsername()).expire(60*60, TimeUnit.HOURS);

        return true;

    }

}
