package com.main.food.common.utils;

import com.main.food.common.exception.file.FileStorageException;
import com.main.food.common.exception.file.MyFileNotFoundException;
import com.main.food.config.properties.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUtil {

    private static FileStorageProperties fileStorageProperties;

    @Autowired
    public FileUtil(FileStorageProperties fileStorageProperties) {
        FileUtil.fileStorageProperties = fileStorageProperties;
    }

    private static Path setFileStorageLocation(String uploadDir) {
        Path fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir() + "\\" + uploadDir)
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }

        return fileStorageLocation;
    }

    public static String storeFile(MultipartFile file, String uploadDir) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Path fileStorageLocation = FileUtil.setFileStorageLocation(uploadDir);

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public static Resource loadFileAsResource(String fileName, String uploadDir) {
        Path fileStorageLocation = FileUtil.setFileStorageLocation(uploadDir);

        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

}
