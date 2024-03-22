package com.helloworld.HW.admin.config.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.helloworld.HW.admin.config.entity.Configs;
import com.helloworld.HW.admin.config.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ConfigInfoService {

    private final ConfigRepository configRepository;

    public <T> T get(String code, Class<T> clazz){

        Configs configs= configRepository.findById(code).orElse(null);
        if(configs ==null || !StringUtils.hasText(configs.getData())){

            return null;
        }
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        String jsonString =configs.getData();
        try {
            T data= om.readValue(jsonString, clazz);
            return data;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
