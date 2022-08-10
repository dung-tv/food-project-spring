package com.main.food.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.Validation;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public abstract class BaseController<E, DtoReq, DtoRes, ID extends Serializable> {
    @Autowired
    public abstract BaseService<E, DtoReq, DtoRes, ID> getService();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultDto<DtoRes> get(@PathVariable ID id) {

        DtoRes entity = getService().get(id);
        return new ResultUtil<DtoRes>().setData(entity);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDto<List<DtoRes>> getAll() {

        List<DtoRes> list = getService().getAll();
        return new ResultUtil<List<DtoRes>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public ResultDto<Page<DtoRes>> getByPage(Pageable page) {

        Page<DtoRes> data = getService().findAll(page);
        return new ResultUtil<Page<DtoRes>>().setData(data);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResultDto<DtoRes> save(@RequestBody @Valid DtoReq entityDto) {

        DtoRes e = getService().save(entityDto);
        return new ResultUtil<DtoRes>().setData(e);
    }

    @Operation(hidden = true)
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResultDto<DtoRes> saveFile(@RequestPart String entityDto, @RequestPart(required = false) MultipartFile file, BindingResult error)
            throws BindException, IOException {
        return new ResultUtil<DtoRes>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultDto<DtoRes> update(@PathVariable ID id , @RequestBody @Valid DtoReq entityDto) {

        DtoRes e = getService().update(id, entityDto);
        return new ResultUtil<DtoRes>().setData(e);
    }

    @Operation(hidden = true)
    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResultDto<DtoRes> updateFile(@PathVariable ID id, @RequestPart String entityDto, @RequestPart(required = false) MultipartFile file, BindingResult error)
            throws BindException, IOException {
        return new ResultUtil<DtoRes>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<Object> delByIds(ID[] ids) {

        for (ID id : ids) {
            getService().delete(id);
        }
        return ResultUtil.success("Deleted");
    }

    public DtoReq convertStringToDto(String source, Class<DtoReq> target) throws IOException {
        return new ObjectMapper().readValue(source, target);
    }

    public void executeValidate(DtoReq entityDto, MultipartFile file, BindingResult error, Validator fileValidatorCustom) throws BindException {
        javax.validation.Validator beanValidator = Validation.buildDefaultValidatorFactory().getValidator();
        SpringValidatorAdapter validatorAdapter = new SpringValidatorAdapter(beanValidator);
        BindException ex = new BindException(error);
        validatorAdapter.validate(entityDto, ex);

        Validator validator = fileValidatorCustom != null ? fileValidatorCustom : new FileValidator();
        validator.validate(file, ex);
        if (error.hasErrors()){
            throw ex;
        }
    }

    private final class FileValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return MultipartFile.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            MultipartFile value = (MultipartFile) target;
            String[] alowType = {"jpg", "jpeg", "png", "gif"};
            String extension = StringUtils.getFilenameExtension(value.getOriginalFilename());
            if (!Arrays.asList(alowType).contains(extension)){
                errors.reject("", "Only JPG, JPEG, PNG & GIF files type are allowed");
            }
        }
    }
}

