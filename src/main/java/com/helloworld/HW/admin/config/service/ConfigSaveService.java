package com.helloworld.HW.admin.config.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.helloworld.HW.admin.config.entity.Configs;
import com.helloworld.HW.admin.config.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigSaveService {

    private final ConfigRepository configRepository;

    public void save(String code, Object data){
        Configs configs = configRepository.findById(code).orElseGet(Configs::new);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        try {
            String jsonString = om.writeValueAsString(data);
            configs.setData(jsonString);
            configs.setCode(code);
            configRepository.saveAndFlush(configs);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}