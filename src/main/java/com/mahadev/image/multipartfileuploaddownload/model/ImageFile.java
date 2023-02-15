package com.mahadev.image.multipartfileuploaddownload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author MAHADEV CHAURASIYA
 * <a href="https://www.linkedin.com/in/mahadev-chaurasiya/">MAHADEV CHAURASIYA</a>
 */
@Entity
@Table(name = "image")
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
    @Column(name = "imgData", length = 100000)
    private byte[] imageFile;

}
