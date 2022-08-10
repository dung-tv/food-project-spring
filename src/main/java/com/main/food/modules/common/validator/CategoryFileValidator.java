package com.main.food.modules.common.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Component
public class CategoryFileValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MultipartFile.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MultipartFile value = (MultipartFile) target;
        if (value instanceof MultipartFile){
            String[] alowType = {"jpg", "jpeg", "png", "gif"};
            String extension = StringUtils.getFilenameExtension(value.getOriginalFilename());
            if (!Arrays.asList(alowType).contains(extension)){
                errors.reject("", "Only JPG, JPEG, PNG & GIF files type are allowed");
            }
        }
    }
}
