package com.helloworld.HW.admin.config.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Configs {

    @Id
    @Column(length = 60)
    private String code;

    @Lob
    private String data; // JSON 형태 데이터 ?

}
