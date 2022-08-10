package com.main.food.base;

import com.main.food.common.utils.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface BaseService <E, DtoReq, DtoRes, ID extends Serializable> {
    public abstract BaseDao<E, ID> getRepository();

    public abstract BaseMapper<E, DtoReq, DtoRes> getMapper();

    public default EntityManager getEntityManager() {
        return null;
    }

    public default DtoRes get(ID id) {
        return getMapper().toEntityDtoRes(getRepository().findById(id).orElse(null));
    }

    public default List<DtoRes> getAll() {
        List<DtoRes> list = new ArrayList<>();
        getRepository().findAll().forEach(e -> list.add(getMapper().toEntityDtoRes(e)));
        return list;
    }

    public default Long getTotalCount() {
        return getRepository().count();
    }

    public default DtoRes save(DtoReq entityDto) {
        E entity = getRepository().saveAndFlush(getMapper().toEntity(entityDto));
        if (getEntityManager() != null) {
            getEntityManager().refresh(entity);
        }
        return getMapper().toEntityDtoRes(entity);
    }

    public default DtoRes update(ID id, DtoReq entityDto){
        E entity = getRepository().findById(id).orElse(null);
        BeanUtils.copyProperties(entityDto, entity, Util.getNullPropertyNames(entityDto));

        if (entity != null) {
            entity = getRepository().saveAndFlush(entity);
        }
        if (getEntityManager() != null) {
            getEntityManager().refresh(entity);
        }

        return getMapper().toEntityDtoRes(entity);
    }

    public default Iterable<DtoRes> saveOrUpdateAll(Iterable<E> entities) {
        List<DtoRes> list = new ArrayList<>();
        getRepository().saveAll(entities).forEach(e -> list.add(getMapper().toEntityDtoRes(e)));
        return list;
    }

    public default void delete(E entity) {
        getRepository().delete(entity);
    }

    public default void delete(ID id) {
        getRepository().deleteById(id);
    }

    public default void delete(Iterable<E> entities) {
        getRepository().deleteInBatch(entities);
    }

    public default void flush() {
        getRepository().flush();
    }

    public default List<DtoRes> findAll(Specification<E> spec) {
        List<DtoRes> list = new ArrayList<>();
        getRepository().findAll(spec).forEach(e -> list.add(getMapper().toEntityDtoRes(e)));
        return list;
    }

    public default Page<DtoRes> findAll(Pageable pageable) {
        List<DtoRes> list = new ArrayList<>();
        Page<E> page = getRepository().findAll(pageable);
        page.getContent().forEach(e -> list.add(getMapper().toEntityDtoRes(e)));
        return new PageImpl<>(list, pageable, page.getTotalElements());
    }

    public default Page<DtoRes> findAll(Specification<E> spec, Pageable pageable) {
        List<DtoRes> list = new ArrayList<>();
        Page<E> page = getRepository().findAll(spec, pageable);
        page.getContent().forEach(e -> list.add(getMapper().toEntityDtoRes(e)));
        return new PageImpl<>(list, pageable, page.getTotalElements());
    }

    public default long count(Specification<E> spec) {
        return getRepository().count(spec);
    }
}
