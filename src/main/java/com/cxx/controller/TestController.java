package com.cxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cxx.logical.DynamicInfoLogical;
import com.cxx.mapper.DynamicExample;
import com.cxx.pojo.DynamicBean;
import com.cxx.service.DynamicInfoService;

@Controller
@RequestMapping(value = "/test")
public class TestController
{
    @Autowired
    DynamicInfoService dynamicInfoService;
    
    @RequestMapping(value = "/info")
    public ModelAndView info(ModelMap model)
    {
        Object ret = null;
        long cont = dynamicInfoService.count(new DynamicExample("test_info"));
        System.out.println(cont);
        ret = dynamicInfoService.find(DynamicInfoLogical.findInfo());
        List<Object> list = dynamicInfoService.query(DynamicInfoLogical.findInfoList());
        for (Object object : list)
        {
            DynamicBean dynamicBean = new DynamicBean(object);
            dynamicBean.setValue("imageSrc", "88888888");
            object = dynamicBean.getObject();
        }
        // dynamicInfoService.update(DynamicInfoLogical.updateInfo());
        DynamicExample dynamicExample = new DynamicExample("test_info");
        dynamicExample.setEntitys(list);
        dynamicExample.setPrimaryKey("id");
        String jsonStr = JSONObject.toJSONString(list);
        System.out.println(jsonStr);
        // dynamicInfoService.batchUpdate(dynamicExample);
        dynamicExample = new DynamicExample("test_info");
        dynamicExample.setEntitys(list);
        // String[] columnList = {"id", "code", "name", "type"};
        // dynamicExample.setColumnList(columnList);
        // dynamicExample.setPrimaryKey("id");
        dynamicInfoService.batchDelete(dynamicExample);
        cont = dynamicInfoService.count(new DynamicExample("test_info"));
        System.out.println(cont);
        dynamicInfoService.buildInsert(dynamicExample);
        cont = dynamicInfoService.count(new DynamicExample("test_info"));
        System.out.println(cont);
        model.addAttribute("materialInfo", ret == null ? new Object() : ret);
        return new ModelAndView("info", model);
    }
}