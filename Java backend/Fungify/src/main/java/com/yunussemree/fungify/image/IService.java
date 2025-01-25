package com.yunussemree.fungify.image;

import org.springframework.web.multipart.MultipartFile;

public interface IService {

    Object upload(MultipartFile file);
}
