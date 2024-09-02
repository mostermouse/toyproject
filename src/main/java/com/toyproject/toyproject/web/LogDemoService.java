package com.toyproject.toyproject.web;

import com.toyproject.toyproject.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    //private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;
    public void logic(String id) {
      //  MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id =" + id);
    }
}
