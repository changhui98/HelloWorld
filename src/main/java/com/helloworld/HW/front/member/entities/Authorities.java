package com.helloworld.HW.front.member.entities;

import com.helloworld.HW.front.member.constants.Authority;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(indexes = @Index(name="uq_member_authority",
        columnList = "member_userNo, authority", unique = true))
public class Authorities {

    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_userNo")
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable = false)
    private Authority authority;
}
