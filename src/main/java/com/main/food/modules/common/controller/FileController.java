package com.main.food.modules.common.controller;

import com.main.food.common.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController
public class FileController {

    @GetMapping("/{fileEntity}/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request, @PathVariable String fileEntity) {
        // Load file as Resource
        Resource resource;
        switch (fileEntity) {
            case "categories":
                resource = FileUtil.loadFileAsResource(fileName, "categories");
                break;
            case "ingredients":
                resource = FileUtil.loadFileAsResource(fileName, "ingredients");
                break;
            case "menus":
                resource = FileUtil.loadFileAsResource(fileName, "menus");
                break;
            case "restaurants":
                resource = FileUtil.loadFileAsResource(fileName, "restaurants");
                break;
            default:
                resource = FileUtil.loadFileAsResource(fileName, "");
        }

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
