package com.main.food.modules.common.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.utils.FileUtil;
import com.main.food.common.utils.ResultUtil;
import com.main.food.modules.common.dto.request.IngredientReqDto;
import com.main.food.modules.common.entity.Ingredient;
import com.main.food.modules.common.service.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/ingredients")
public class IngredientController extends BaseController<Ingredient, IngredientReqDto, Ingredient, Long> {
    @Autowired
    private IngredientService ingredientService;

    @Override
    public IngredientService getService() {
        return ingredientService;
    }

    @Override
    public ResultDto<Ingredient> get(Long id) {
        return super.get(id);
    }

    @Override
    public ResultDto<List<Ingredient>> getAll() {
        return super.getAll();
    }

    @Override
    public ResultDto<Page<Ingredient>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Ingredient> save(IngredientReqDto entityDto) {
        return new ResultUtil<Ingredient>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Ingredient> update(Long id, IngredientReqDto entityDto) {
        return new ResultUtil<Ingredient>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = false)
    @Override
    @Transactional
    public ResultDto<Ingredient> saveFile(
            @Parameter(schema = @Schema(type = "object", implementation = IngredientReqDto.class))
            @RequestPart("ingredient")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        IngredientReqDto ingredientReqDto = ingredientResolve(entityDto, file, error);

        Ingredient result = getService().save(ingredientReqDto);
        return new ResultUtil<Ingredient>().setData(result);
    }

    @Operation(hidden = false)
    @Override
    public ResultDto<Ingredient> updateFile(
            @RequestParam Long id,
            @Parameter(schema = @Schema(type = "object", implementation = IngredientReqDto.class))
            @RequestPart("ingredient")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        IngredientReqDto ingredientReqDto = ingredientResolve(entityDto, file, error);

        Ingredient result = getService().update(id, ingredientReqDto);
        return new ResultUtil<Ingredient>().setData(result);
    }

    private IngredientReqDto ingredientResolve(@RequestPart("ingredient") @Parameter(schema = @Schema(type = "object", implementation = IngredientReqDto.class)) String entityDto, @RequestPart(required = false) @Parameter(schema = @Schema(type = "string", format = "binary")) MultipartFile file, BindingResult error) throws IOException, BindException {
        IngredientReqDto ingredientReqDto = this.convertStringToDto(entityDto, IngredientReqDto.class);

        if (file instanceof MultipartFile) {
            this.executeValidate(ingredientReqDto, file, error, null);
            String fileName = FileUtil.storeFile(file, "ingredients");
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/ingredients/downloadFile/")
                    .path(fileName)
                    .toUriString();
            ingredientReqDto.setThumbnailPic(fileDownloadUri);
        }else {
            ingredientReqDto.setThumbnailPic("");
        }
        return ingredientReqDto;
    }

    @Override
    public ResultDto<Object> delByIds(Long[] longs) {
        return super.delByIds(longs);
    }

}
