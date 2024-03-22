package com.helloworld.HW.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(FileProperties.class)
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private FileProperties fileProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileProperties.getUrl() + "**")
                .addResourceLocations("file:///" + fileProperties.getPath());

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setUseCodeAsDefaultMessage(true); // 메세지 코드 X -> 코드 그대로 출력
        ms.setBasenames("messages.commons", "messages.errors", "messages.validations");

        return ms;
    }

    /**
     * 양식(form)을 통해 만들게 되면 get/post밖에 사용할 수 없음
     * 양식 내에서 delete, put, patch도 사용할 수 있게 해주자. → 의존성 추가
     * 설정을 해주면 form 안에 hidden : _method=PATCH 이런 식으로 넣어주면
     * 메서드가 변경됨
     */
    @Bean
    public HiddenHttpMethodFilter httpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
