package com.main.food.modules.common.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.enums.Permissions;
import com.main.food.common.utils.FileUtil;
import com.main.food.common.utils.ResultUtil;
import com.main.food.modules.common.dto.request.CategoryReqDto;
import com.main.food.modules.common.entity.Category;
import com.main.food.modules.common.service.CategoryService;
import com.main.food.modules.common.validator.CategoryFileValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category, CategoryReqDto, Category, Long> {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryFileValidator categoryFileValidator;

    @Override
    public CategoryService getService() {
        return categoryService;
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.CATEGORY_GET_ALL + "\")")
    public ResultDto<Category> get(Long id) {
        return super.get(id);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.CATEGORY_GET_ALL + "\")")
    public ResultDto<List<Category>> getAll() {
        return super.getAll();
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.CATEGORY_GET_ALL + "\")")
    public ResultDto<Page<Category>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.CATEGORY_GET_ALL + "\")")
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Category> save(CategoryReqDto entityDto) {
        return new ResultUtil<Category>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Category> update(Long id, CategoryReqDto entityDto) {
        return new ResultUtil<Category>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = false)
    @Override
    @Transactional
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.CATEGORY_GET_ALL + "\")")
    public ResultDto<Category> saveFile(
            @Parameter(schema = @Schema(type = "object", implementation = CategoryReqDto.class))
            @RequestPart("category")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        CategoryReqDto categoryReqDto = categoryResolve(entityDto, file, error);

        Category result = getService().save(categoryReqDto);
        return new ResultUtil<Category>().setData(result);
    }

    @Operation(hidden = false)
    @Override
    @PreAuthorize("hasAuthority(\"" + Permissions.Names.CATEGORY_GET_ALL + "\")")
    public ResultDto<Category> updateFile(
            @PathVariable Long id,
            @Parameter(schema = @Schema(type = "object", implementation = CategoryReqDto.class))
            @RequestPart("category")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        CategoryReqDto categoryReqDto = categoryResolve(entityDto, file, error);

        Category result = getService().update(id, categoryReqDto);
        return new ResultUtil<Category>().setData(result);
    }

    private CategoryReqDto categoryResolve(@RequestPart("category") @Parameter(schema = @Schema(type = "object", implementation = CategoryReqDto.class)) String entityDto, @RequestPart(required = false) @Parameter(schema = @Schema(type = "string", format = "binary")) MultipartFile file, BindingResult error) throws IOException, BindException {
        CategoryReqDto categoryReqDto = this.convertStringToDto(entityDto, CategoryReqDto.class);

        if (file instanceof MultipartFile) {
            this.executeValidate(categoryReqDto, file, error, categoryFileValidator);
            String fileName = FileUtil.storeFile(file, "categories");
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/categories/downloadFile/")
                    .path(fileName)
                    .toUriString();
            categoryReqDto.setThumbnailPic(fileDownloadUri);
        }else {
            categoryReqDto.setThumbnailPic("");
        }
        return categoryReqDto;
    }

    @GetMapping("{id}/getByPage")
    private ResultDto<Page<Category>> getByIdAndPage(@PathVariable Long id, Pageable pageable) {

        return new ResultUtil<Page<Category>>().setData(null);
    }
}
