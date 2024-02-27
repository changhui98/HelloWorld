package com.helloworld.HW.file.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
//파일 쪽 요청정보를 받을 커맨드객체
@Data
public class RequestFileUpload {
    private MultipartFile[] file;
    private String gid = UUID.randomUUID().toString(); //기본값 자동 생성
    private String location; //파일위치
    private Boolean imageOnly; //이미지만 가져오도록
    private Boolean single; //하나의 파일만 받을 때 (새로운 파일이 이전파일 대체)
}
