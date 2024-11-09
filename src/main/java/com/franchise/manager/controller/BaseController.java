package com.franchise.manager.controller;

import com.franchise.manager.service.MapperService;
import jakarta.annotation.Resource;

import java.util.List;

public class BaseController<T, R> {

    @Resource
    private MapperService<T, R> mapperService;

    public List<R> mapList(List<T> list, Class<R> targetClass) {
        return mapperService.mapList(list, targetClass);
    }

    public R map(T objectToMap, Class<R> returnType) {
        return mapperService.map(objectToMap, returnType);
    }
}

