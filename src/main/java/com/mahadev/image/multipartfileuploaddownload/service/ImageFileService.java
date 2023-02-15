package com.mahadev.image.multipartfileuploaddownload.service;

import com.mahadev.image.multipartfileuploaddownload.model.ImageFile;
import com.mahadev.image.multipartfileuploaddownload.repository.FileRepository;
import com.mahadev.image.multipartfileuploaddownload.util.ImageUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @author MAHADEV CHAURASIYA
 * <a href="https://www.linkedin.com/in/mahadev-chaurasiya/">MAHADEV CHAURASIYA</a>
 */
@Service
public class ImageFileService {
    @Autowired
    private FileRepository mFileRepository;

    public String uploadImage(MultipartFile multipartFile) throws IOException {
        mFileRepository.save(ImageFile.builder()
                .fileName(multipartFile.getOriginalFilename())
                .fileType(multipartFile.getContentType())
                .imageFile(ImageUtils.compressImage(multipartFile.getBytes()))
                .build());
        return "File uploaded successfully : " + multipartFile.getOriginalFilename();
    }

    public byte[] downloadImage(String fName) {
        Optional<ImageFile> imageFile = mFileRepository.findByFileName(fName);
        return imageFile.map(file -> ImageUtils.decompressImage(file.getImageFile())).orElse(null);
    }

    @Transactional
    public ImageFile getInfoByImageByName(String name) {
        Optional<ImageFile> dbImage = mFileRepository.findByFileName(name);
        return ImageFile.builder()
                .id(dbImage.get().getId())
                .fileName(dbImage.get().getFileName())
                .fileType(dbImage.get().getFileType())
                .imageFile(ImageUtils.decompressImage(dbImage.get().getImageFile())).build();
    }

}
