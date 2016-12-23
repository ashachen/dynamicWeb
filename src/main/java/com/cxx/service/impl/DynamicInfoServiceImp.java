package com.cxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxx.mapper.DynamicExample;
import com.cxx.mapper.DynamicMapper;
import com.cxx.service.DynamicInfoService;

@Service
public class DynamicInfoServiceImp implements DynamicInfoService
{
    @Autowired
    private DynamicMapper dynamicMapper;
    
    @Override
    public Object find(DynamicExample dynamicExample)
    {
        return dynamicMapper.find(dynamicExample);
    }
    
    @Override
    public List<Object> query(DynamicExample dynamicExample)
    {
        return dynamicMapper.query(dynamicExample);
    }
    
    @Override
    public int update(DynamicExample dynamicExample)
    {
        return dynamicMapper.update(dynamicExample);
    }
    
    @Override
    public int batchUpdate(DynamicExample dynamicExample)
    {
        return dynamicMapper.batchUpdate(dynamicExample);
    }
    
    @Override
    public long count(DynamicExample dynamicExample)
    {
        return dynamicMapper.count(dynamicExample);
    }
    
    @Override
    public int batchDelete(DynamicExample dynamicExample)
    {
        return dynamicMapper.batchDelete(dynamicExample);
    }
    
    @Override
    public int delete(DynamicExample dynamicExample)
    {
        return dynamicMapper.batchDelete(dynamicExample);
    }
    
    @Override
    public int buildInsert(DynamicExample dynamicExample)
    {
        return dynamicMapper.buildInsert(dynamicExample);
    }
    
    @Override
    public int insert(DynamicExample dynamicExample)
    {
        return dynamicMapper.buildInsert(dynamicExample);
    }
}
