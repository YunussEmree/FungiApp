package com.yunussemree.fungify.image;

import com.yunussemree.fungify.utils.api.ApiResponse;
import com.yunussemree.fungify.utils.exceptions.ImageException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;


@Service
@RequiredArgsConstructor
public class ImageService implements IService {

    @Override
    public ApiResponse upload(MultipartFile file) {
            try {
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setBlob(new SerialBlob(file.getBytes()));
            } catch (IOException | SQLException e) {
                throw new ImageException(e.getMessage());
            }
            return new ApiResponse("Image uploaded successfully", true); //TODO: return model response
    }

}
