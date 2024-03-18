package com.helloworld.HW.file.entities;

import com.helloworld.HW.common.entity.BaseMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(indexes = {  //자주 검색하는 조건 인덱스 걸어놓자(성능향상 위해), 기본키는 index 필요없음!
    @Index(name="idx_fi_gid", columnList = "gid, createdAt"),
    @Index(name="idx_fi_gid_location", columnList = "gid, location, createdAt")
            })
public class FileInfo extends BaseMember {
    @Id @GeneratedValue
    private Long seq; // 파일 등록 번호, 서버에 업로드 하는 파일명 기준

    @Column(length=65, nullable = false)
    private String gid = UUID.randomUUID().toString(); //기본값 (자바에서 unique한 키 생성해줌 - UUID)

    @Column(length=65)
    private String location;

    @Column(length=80, nullable = false)
    private String fileName; //원본파일 이름

    @Column(length=45)
    private String extension; //확장자 기록

    @Column(length=65)
    private String contentType; //파일형식 기록

    private boolean done; //작업 완료 여부

    @Transient
    private String filePath; //서버 쪽 실제 경로

    @Transient
    private String fileUrl;

    @Transient
    private MultipartFile file; //임시저장?
}
