package com.helloworld.HW.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "file.upload")
public class FileProperties {

    private String path;
    private String url;
}
