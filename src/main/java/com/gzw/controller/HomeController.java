package com.gzw.controller;

import com.alibaba.fastjson.JSON;
import com.gzw.domain.ResultInfo;
import com.gzw.service.serviceImpl.ScheduledServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gujian on 2017/6/28.
 */
@RestController
public class HomeController {

    @Autowired
    private ScheduledServiceImpl service;

    @RequestMapping("/")
    public String home(){

        return "/login";
    }


    @PostMapping(value = "/scheduled")
    public String scheduled(@RequestParam("time") String time,@RequestParam("type") String type){

        service.exeJob(time,type);

        ResultInfo resultInfo = ResultInfo.getSuccessInfo("定时器已启动，参数为："+time+"："+type);
        return JSON.toJSONString(resultInfo);
    }

}
