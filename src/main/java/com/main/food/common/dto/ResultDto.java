package com.main.food.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResultDto <T>{

    @Schema(defaultValue = "true")
    private boolean success;

    @Schema(defaultValue = "success")
    private String message;

    @Schema(defaultValue = "200")
    private Integer code;

    private long timestamp = System.currentTimeMillis();

    private T result;
}
