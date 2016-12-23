package com.cxx.service;

import java.util.List;
import com.cxx.mapper.DynamicExample;

public interface DynamicInfoService
{
    public Object find(DynamicExample dynamicExample);
    
    public List<Object> query(DynamicExample dynamicExample);
    
    public int update(DynamicExample dynamicExample);
    
    public int batchUpdate(DynamicExample dynamicExample);
    
    public long count(DynamicExample dynamicExample);
    
    public int batchDelete(DynamicExample dynamicExample);
    
    public int delete(DynamicExample dynamicExample);
    
    int buildInsert(DynamicExample dynamicExample);
    
    int insert(DynamicExample dynamicExample);
}
