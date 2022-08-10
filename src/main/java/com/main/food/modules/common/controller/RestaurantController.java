package com.main.food.modules.common.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.utils.FileUtil;
import com.main.food.common.utils.ResultUtil;
import com.main.food.modules.common.dto.request.RestaurantReqDto;
import com.main.food.modules.common.entity.Restaurant;
import com.main.food.modules.common.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/restaurants")
public class RestaurantController extends BaseController<Restaurant, RestaurantReqDto, Restaurant, Long> {
    @Autowired
    private RestaurantService restaurantService;

    @Override
    public RestaurantService getService() {
        return restaurantService;
    }

    @Override
    public ResultDto<Restaurant> get(Long id) {
        return super.get(id);
    }

    @Override
    public ResultDto<List<Restaurant>> getAll() {
        return super.getAll();
    }

    @Override
    public ResultDto<Page<Restaurant>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Restaurant> save(RestaurantReqDto entityDto) {
        return new ResultUtil<Restaurant>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Restaurant> update(Long id, RestaurantReqDto entityDto) {
        return new ResultUtil<Restaurant>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = false)
    @Override
    @Transactional
    public ResultDto<Restaurant> saveFile(
            @Parameter(schema = @Schema(type = "object", implementation = RestaurantReqDto.class))
            @RequestPart("restaurant")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        RestaurantReqDto restaurantReqDto = restaurantResolve(entityDto, file, error);

        Restaurant result = getService().save(restaurantReqDto);
        return new ResultUtil<Restaurant>().setData(result);
    }

    @Operation(hidden = false)
    @Override
    public ResultDto<Restaurant> updateFile(
            @PathVariable Long id,
            @Parameter(schema = @Schema(type = "object", implementation = RestaurantReqDto.class))
            @RequestPart("restaurant")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        RestaurantReqDto restaurantReqDto = restaurantResolve(entityDto, file, error);

        Restaurant result = getService().update(id, restaurantReqDto);
        return new ResultUtil<Restaurant>().setData(result);
    }

    private RestaurantReqDto restaurantResolve(@RequestPart("restaurant") @Parameter(schema = @Schema(type = "object", implementation = RestaurantReqDto.class)) String entityDto, @RequestPart(required = false) @Parameter(schema = @Schema(type = "string", format = "binary")) MultipartFile file, BindingResult error) throws IOException, BindException {
        RestaurantReqDto restaurantReqDto = this.convertStringToDto(entityDto, RestaurantReqDto.class);

        if (file instanceof MultipartFile) {
            this.executeValidate(restaurantReqDto, file, error, null);
            String fileName = FileUtil.storeFile(file, "restaurants");
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/restaurants/downloadFile/")
                    .path(fileName)
                    .toUriString();
            restaurantReqDto.setThumbnailPic(fileDownloadUri);
        }else {
            restaurantReqDto.setThumbnailPic("");
        }
        return restaurantReqDto;
    }

    @Override
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }
}
