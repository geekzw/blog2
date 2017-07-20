package com.gzw.config;

import com.gzw.interceptor.AccessTokenVerifyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by gujian on 2017/7/10.
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    AccessTokenVerifyInterceptor interceptor;

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/**")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/","/do_login","/do_register","/login");
    }
}
