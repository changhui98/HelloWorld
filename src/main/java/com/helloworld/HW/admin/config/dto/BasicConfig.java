package com.helloworld.HW.admin.config.dto;

import lombok.Data;

@Data
public class BasicConfig {

    private String siteTitle;
    private String siteDescription;
    private String siteKeywords;
    private int cssJsVersion;
    private String joinTerms;

}
