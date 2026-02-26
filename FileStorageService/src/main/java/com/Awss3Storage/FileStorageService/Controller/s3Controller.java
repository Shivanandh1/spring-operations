package com.Awss3Storage.FileStorageService.Controller;

import com.Awss3Storage.FileStorageService.service.S3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/s3")
public class s3Controller {

    public final S3Service service;


    public s3Controller(S3Service service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public String uploadfile(
            @RequestParam("file") MultipartFile multipartFile) throws IOException {

         return  service.uploadFile(multipartFile);

    }

    @GetMapping("/download/{key}")
    public byte[] getFile(@PathVariable String key){
            return service.downloadFile(key);
    }
}
