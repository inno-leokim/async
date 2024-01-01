package com.brand13.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AsyncService {
   
    private final Emailservice emailservice;
 
    // bean 주입
    public void asyncCall_1() {
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailservice.sendMail();
        emailservice.sendMailWithCustomThreadPool();
    }

    // 인스턴스 선언
    public void asyncCall_2() {
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
        Emailservice emailservice = new Emailservice();
        emailservice.sendMail();
        emailservice.sendMailWithCustomThreadPool();
    }
    
    // 클래스 내부 메소드에 Async 어노테이션을 사용
    public void asyncCall_3() {
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
        sendMail();
    }

    @Async
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }
}
