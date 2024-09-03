package com.toyproject.toyproject.web;

import com.toyproject.toyproject.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//생성자 자동 생성해서 싱글톤 패턴 으로 해줌
public class LogDemoService {
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    private final MyLogger myLogger;

    /*@Autowired @RequiredArgsConstructor얘가 대신 만들어 줌
    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }*/

    public void logic(String id) {
      //  MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id =" + id);
    }
}
