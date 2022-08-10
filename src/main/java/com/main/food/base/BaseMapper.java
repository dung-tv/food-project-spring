package com.main.food.base;

public interface BaseMapper<E, DtoReq, DtoRes> {
    E toEntity(DtoReq entityDto);

    DtoReq toEntityDtoReq(E entity);

    DtoRes toEntityDtoRes(E entity);
}
