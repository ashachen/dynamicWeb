package com.cxx.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import com.cxx.pojo.DynamicBean;

public class DynamicPropertyRowMapper implements RowMapper<Object>, Serializable
{
    /**
     * serialVersionUID:DynamicPropertyRowMapper
     * 
     * @since 1.0.0
     */
    private static final long serialVersionUID = 195549193827879102L;
    
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum)
        throws SQLException
    {
        return this.toDynamicObject(resultSet, rowNum);
    }
    
    private Object toDynamicObject(ResultSet resultSet, int rowNum)
        throws SQLException
    {
        DynamicBean dynamicBean = null;
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        if (resultSetMetaData != null)
        {
            int columnCount = resultSetMetaData.getColumnCount();
            HashMap<String, Class<Object>> propertyMap = new HashMap<String, Class<Object>>();
            for (int index = 1; index <= columnCount; index++)
            {
                String column = JdbcUtils.lookupColumnName(resultSetMetaData, index);
                String propertyName = JdbcUtils.convertUnderscoreNameToPropertyName(column);
                propertyMap.put(propertyName, Object.class);// 添加动态属性 此xxx_xxx ==>xxxXXX
            }
            dynamicBean = new DynamicBean(propertyMap);
            for (int index = 1; index <= columnCount; index++)
            {
                String column = JdbcUtils.lookupColumnName(resultSetMetaData, index);
                String propertyName = JdbcUtils.convertUnderscoreNameToPropertyName(column);
                Object value = JdbcUtils.getResultSetValue(resultSet, index);
                dynamicBean.setValue(propertyName, value);// 设置值
            }
            return dynamicBean.getObject();
        }
        return dynamicBean;
    }
    
    public static DynamicPropertyRowMapper newInstance()
    {
        DynamicPropertyRowMapper newInstance = new DynamicPropertyRowMapper();
        return newInstance;
    }
}
