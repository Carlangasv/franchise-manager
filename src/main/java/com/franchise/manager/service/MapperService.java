package com.franchise.manager.service;

import java.util.List;

public interface MapperService<T, R> {
    R map(T objectToMap, Class<R> returnType);

    List<R> mapList(List<T> list, Class<R> targetClass);
}
