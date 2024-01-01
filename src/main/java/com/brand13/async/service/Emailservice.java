package com.brand13.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Emailservice {
    
    //Async 어노테이션을 사용할 때는 public을 사용한다.
    @Async("defaultTaskExecutor")
    public void sendMail(){
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }

    @Async("messagingTaskExecutor")
    public void sendMailWithCustomThreadPool(){
        System.out.println("[messagingTaskExecutor] :: " + Thread.currentThread().getName());     
    }
}
