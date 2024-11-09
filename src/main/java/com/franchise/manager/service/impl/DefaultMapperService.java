package com.franchise.manager.service.impl;

import com.franchise.manager.service.MapperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMapperService<T, R> implements MapperService<T, R> {
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public R map(T objectToMap, Class<R> returnType) {
        return modelMapper.map(objectToMap, returnType);
    }

    @Override
    public List<R> mapList(List<T> list, Class<R> targetClass) {
        return list.stream().map(item -> modelMapper.map(item, targetClass)).toList();
    }

}