package com.mahadev.image.multipartfileuploaddownload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ImageFileInfo")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fName")
    private String fileName;
    @Column(name = "fType")
    private String fileType;
    @Lob
    @Column(name = "ImageFileData")
    private byte[] imageFile;

}
