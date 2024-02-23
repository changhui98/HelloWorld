package com.helloworld.HW.front.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Skill {
    @Id @GeneratedValue
    private Long skillSeq;

    private boolean java;

    private boolean python;

    private boolean htmlCss;

    private boolean c;

    private boolean csharpcplus;


}
