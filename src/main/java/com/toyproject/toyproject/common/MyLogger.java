package com.toyproject.toyproject.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request" , proxyMode = ScopedProxyMode.TARGET_CLASS)
/*[bd86dd56-3121-4769-94db-a9022f4bef92] request scope bean create: com.toyproject.toyproject.common.MyLogger@5dfba55d
[bd86dd56-3121-4769-94db-a9022f4bef92 http://localhost:8080/log-demo] controller test
[bd86dd56-3121-4769-94db-a9022f4bef92 http://localhost:8080/log-demo] service id =testId
[bd86dd56-3121-4769-94db-a9022f4bef92] request scope bean close: com.toyproject.toyproject.common.MyLogger@5dfba55d*/
//싱글톤 처럼 동작하는거처럼 보이기에 다른 사람이 오해 할 수도 있으니 협의 하에 사용 해야 함
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        // UUID와 URL을 올바르게 출력
        System.out.println("[" + uuid + " " + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        this.uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
