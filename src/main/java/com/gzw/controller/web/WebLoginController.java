package com.gzw.controller.web;

import com.gzw.domain.User;
import com.gzw.domain.UserInfo;
import com.gzw.mappers.ArticleMapper;
import com.gzw.mappers.UserMapper;
import com.gzw.service.serviceImpl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by gujian on 2017/6/29.
 */
@Controller
public class WebLoginController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ArticleMapper articleMapper;


    @PostMapping(value = "/action_login")
    public String login(User user, HttpSession session, Model model){
        session.setAttribute("user",user);
        UserInfo userInfo = userInfoService.getUserInfo(user.getUsername());
        if(userInfo == null){
            userInfo = getDefaultUserInf();
            model.addAttribute("userInfo",userInfo);
            model.addAttribute("articleCount",0);
            model.addAttribute("tagCount",0);
        }else{
            model.addAttribute("userInfo",userInfo);
            model.addAttribute("articleCount",articleMapper.getArticleCount(user.getUsername()));
            model.addAttribute("tagCount",articleMapper.getTagCount(user.getUsername()));
            model.addAttribute("categoryList",articleMapper.getArticleClassList(user.getUsername()));
            model.addAttribute("archiveList",articleMapper.getArticlePigeonhle(user.getUsername()));
        }

        return "/blog/index";
    }


    private UserInfo getDefaultUserInf(){
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("default");
        userInfo.setAvatar("/image/avatar.jpg");
        return userInfo;
    }
}
