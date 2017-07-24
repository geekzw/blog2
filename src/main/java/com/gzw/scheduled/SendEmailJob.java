package com.gzw.scheduled;

import com.gzw.SpringContext;
import com.gzw.service.serviceImpl.EmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gujian on 2017/7/24.
 */
@Component
public class SendEmailJob implements Job {

    @Autowired
    private EmailService service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //autowoired无法获取到实例，不知道原因
        if (service == null) {//解决service为null无法注入问题
            System.out.println("operatorLogService is null!!!");
            service = SpringContext.getBean(EmailService.class);
        }

        service.sendSimpleEmail();
    }
}
