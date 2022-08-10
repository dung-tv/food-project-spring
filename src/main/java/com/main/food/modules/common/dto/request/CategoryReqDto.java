package com.main.food.modules.common.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CategoryReqDto {

    @NotNull
    @Size(min = 5, message = "size min is 5 charactor")
    private String name;

    private String thumbnailPic;
}
