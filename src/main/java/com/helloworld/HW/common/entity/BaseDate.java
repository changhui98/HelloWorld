package com.helloworld.HW.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDate {

    @CreatedDate // JPA에서 엔티티의 생성 시간을 처리
    @Column(updatable = false) // 생성된 컬럼 값이 변경되지 않는다. 디폴드 값은 true
    private LocalDateTime createdAt;

    @LastModifiedDate // 최종 수정 시간을 자동으로 처리
    @Column(insertable = false)
    private LocalDateTime modifiedAt;
}
