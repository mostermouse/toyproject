package com.toyproject.toyproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //이거 하위 클래스들만 읽어서 무조건 상위 폴더에 있어야함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoConfig{
}
