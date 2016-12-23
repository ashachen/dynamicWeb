package com.cxx.logical;

import java.util.HashMap;

import com.cxx.mapper.DynamicExample;
import com.cxx.mapper.DynamicExample.Criteria;
import com.cxx.pojo.DynamicBean;

public class DynamicInfoLogical
{
    public static DynamicExample findInfo()
    {
        DynamicExample dynamicExample = new DynamicExample("test_info a,base_material_category c");
        String[] columnList = {"a.id", "a.code", "a.name", "a.image_src", "a.create_time", "a.type", "c.name type_name", "a.mark"};
        dynamicExample.setColumnList(columnList);
        Criteria criteria = dynamicExample.createCriteria();
        criteria.andEqualTo("a.id", "1");
        criteria.andEqualTo("c.status", "1");
        criteria.andEqualToRelated("a.type", "c.code");
        return dynamicExample;
    };
    
    public static DynamicExample findInfoList()
    {
        DynamicExample dynamicExample = new DynamicExample("test_info");
        // String[] columnList = {"id", "code", "name", "image_src", "type", "mark"};
        // dynamicExample.setColumnList(columnList);
        dynamicExample.setLimitStart(0);
        dynamicExample.setLimitEnd(10);
        return dynamicExample;
    };
    
    public static DynamicExample updateInfo()
    {
        HashMap<String, Class<Object>> propertyMap = new HashMap<String, Class<Object>>();
        propertyMap.put("id", Object.class);
        propertyMap.put("code", Object.class);
        propertyMap.put("name", Object.class);
        propertyMap.put("imageSrc", Object.class);
        DynamicBean dynamicBean = new DynamicBean(propertyMap);
        dynamicBean.setValue("id", "1");
        dynamicBean.setValue("code", "code0001");
        dynamicBean.setValue("name", "name0001");
        dynamicBean.setValue("imageSrc", "image_src0001");
        DynamicExample dynamicExample = new DynamicExample("test_info");
        dynamicExample.setEntity(dynamicBean.getObject());
        String[] columnList = {"id", "code", "name", "image_src", "type", "mark"};
        dynamicExample.setColumnList(columnList);
        // dynamicExample.setPrimaryKey("id");
        return dynamicExample;
    };
}
