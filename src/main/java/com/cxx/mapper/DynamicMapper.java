package com.cxx.mapper;

import java.util.List;

public interface DynamicMapper
{
    public Object find(DynamicExample dynamicExample);
    
    public List<Object> query(DynamicExample dynamicExample);
    
    public int update(DynamicExample dynamicExample);
    
    public long count(DynamicExample dynamicExample);
    
    public int batchUpdate(DynamicExample dynamicExample);
    
    public int batchDelete(DynamicExample dynamicExample);
    
    public int buildInsert(DynamicExample dynamicExample);
}
