package com.helloworld.HW.file.service;

import com.helloworld.HW.file.dto.RequestFileUpload;
import com.helloworld.HW.file.entities.FileInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileInfoSaveService {
    public List<FileInfo> save(RequestFileUpload form) {
        List<FileInfo> items = new ArrayList<>();
        MultipartFile[] files = form.getFile();
        String gid = form.getGid();
        String location = form.getLocation();
        //null일 때 기본값 - false
        boolean imageOnly = Objects.requireNonNullElse(form.getImageOnly(),false);

        for(MultipartFile file : files) {
            // "."을 기준으로 파일이름 가져오기
            String fileName = file.getOriginalFilename();
            FileInfo item = FileInfo.builder()
                    .gid(gid)
                    .location(location)
                    .fileName(fileName)
                    .contentType(file.getContentType())
                    .build();
        }
        return null;
    }
}
