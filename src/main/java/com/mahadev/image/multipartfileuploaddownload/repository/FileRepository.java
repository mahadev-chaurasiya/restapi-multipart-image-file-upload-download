package com.mahadev.image.multipartfileuploaddownload.repository;

import com.mahadev.image.multipartfileuploaddownload.model.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author MAHADEV CHAURASIYA
 * <a href="https://www.linkedin.com/in/mahadev-chaurasiya/">MAHADEV CHAURASIYA</a>
 */
public interface FileRepository extends JpaRepository<ImageFile, Long> {
    Optional<ImageFile> findByFileName(String fileName);
}
