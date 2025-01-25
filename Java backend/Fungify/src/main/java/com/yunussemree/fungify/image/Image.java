package com.yunussemree.fungify.image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.sql.Blob;

@Data
public class Image {
    private String fileName;
    private String fileType;

    @JsonIgnore
    private Blob blob;

}
