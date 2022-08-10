package com.main.food.modules.common.controller;

import com.main.food.base.BaseController;
import com.main.food.common.dto.ResultDto;
import com.main.food.common.utils.FileUtil;
import com.main.food.common.utils.ResultUtil;
import com.main.food.modules.common.dto.request.MenuReqDto;
import com.main.food.modules.common.entity.Menu;
import com.main.food.modules.common.service.MenuService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/menus")
public class MenuController extends BaseController<Menu, MenuReqDto, Menu, Long> {
    @Autowired
    private MenuService menuService;

    @Override
    public MenuService getService() {
        return menuService;
    }

    @Override
    public ResultDto<Menu> get(Long id) {
        return super.get(id);
    }

    @Override
    public ResultDto<List<Menu>> getAll() {
        return super.getAll();
    }

    @Override
    public ResultDto<Page<Menu>> getByPage(Pageable page) {
        return super.getByPage(page);
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Menu> save(MenuReqDto entityDto) {
        return new ResultUtil<Menu>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = true)
    @Override
    public ResultDto<Menu> update(Long id, MenuReqDto entityDto) {
        return new ResultUtil<Menu>().setErrorMsg(400, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Operation(hidden = false)
    @Override
    @Transactional
    public ResultDto<Menu> saveFile(
            @Parameter(schema = @Schema(type = "object", implementation = MenuReqDto.class))
            @RequestPart("menu")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        MenuReqDto menuReqDto = menuResolve(entityDto, file, error);

        Menu result = getService().save(menuReqDto);
        return new ResultUtil<Menu>().setData(result);
    }

    @Operation(hidden = false)
    @Override
    public ResultDto<Menu> updateFile(
            @PathVariable Long id,
            @Parameter(schema = @Schema(type = "object", implementation = MenuReqDto.class))
            @RequestPart("menu")
            String entityDto,
            @Parameter(schema = @Schema(type = "string", format = "binary"))
            @RequestPart(required = false)
            MultipartFile file,
            BindingResult error
    ) throws BindException, IOException {

        MenuReqDto menuReqDto = menuResolve(entityDto, file, error);

        Menu result = getService().update(id, menuReqDto);
        return new ResultUtil<Menu>().setData(result);
    }

    private MenuReqDto menuResolve(@RequestPart("restaurant") @Parameter(schema = @Schema(type = "object", implementation = MenuReqDto.class)) String entityDto, @RequestPart(required = false) @Parameter(schema = @Schema(type = "string", format = "binary")) MultipartFile file, BindingResult error) throws IOException, BindException {
        MenuReqDto menuReqDto = this.convertStringToDto(entityDto, MenuReqDto.class);

        if (file instanceof MultipartFile) {
            this.executeValidate(menuReqDto, file, error, null);
            String fileName = FileUtil.storeFile(file, "menus");
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/menus/downloadFile/")
                    .path(fileName)
                    .toUriString();
            menuReqDto.setThumbnailPic(fileDownloadUri);
        }else {
            menuReqDto.setThumbnailPic("");
        }
        return menuReqDto;
    }

    @Override
    public ResultDto<Object> delByIds(Long[] ids) {
        return super.delByIds(ids);
    }

}
