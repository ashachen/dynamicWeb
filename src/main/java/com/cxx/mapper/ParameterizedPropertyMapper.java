package com.cxx.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cxx.mapper.SqlUtils.SqlContext;

@Repository
public class ParameterizedPropertyMapper implements DynamicMapper
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Object find(DynamicExample dynamicExample)
    {
        Object object = null;
        try
        {
            object = jdbcTemplate.queryForObject(SqlUtils.buildQuerySql(dynamicExample).getSql(), DynamicPropertyRowMapper.newInstance());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return object;
    }
    
    @Override
    public List<Object> query(DynamicExample dynamicExample)
    {
        List<Object> ret = new ArrayList<>();
        try
        {
            ret = jdbcTemplate.query(SqlUtils.buildQuerySql(dynamicExample).getSql(), DynamicPropertyRowMapper.newInstance());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
    
    @Override
    public int update(DynamicExample dynamicExample)
    {
        SqlContext sqlContext = SqlUtils.buildUpdateSql(dynamicExample);
        int ret = jdbcTemplate.update(sqlContext.getSql(), sqlContext.getArgs());
        return ret;
    };
    
    public int delete(Object obj)
        throws Exception
    {
        return 0;
    }
    
    @Override
    public int batchDelete(DynamicExample dynamicExample)
    {
        int[] ret;
        SqlContext sqlContext = SqlUtils.buildDeleteSql(dynamicExample);
        if (null == sqlContext.getBatchArgs())
        {
            ret = jdbcTemplate.batchUpdate(sqlContext.getSql());
        }
        else
        {
            ret = jdbcTemplate.batchUpdate(sqlContext.getSql(), sqlContext.getBatchArgs());
        }
        int cout = 0;
        if (null != ret)
        {
            for (int i : ret)
            {
                cout = cout + i;
            }
        }
        return cout;
    }
    
    @Override
    public long count(DynamicExample dynamicExample)
    {
        Long ret = 0l;
        String sql = SqlUtils.buildCountSql(dynamicExample).getSql().toString();
        try
        {
            ret = jdbcTemplate.queryForObject(sql, Long.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
    
    @Override
    public int batchUpdate(DynamicExample dynamicExample)
    {
        SqlContext sqlContext = SqlUtils.buildBatchUpdateSql(dynamicExample);
        int[] ret = jdbcTemplate.batchUpdate(sqlContext.getSql(), sqlContext.getBatchArgs());
        int cout = 0;
        for (int i : ret)
        {
            cout = cout + i;
        }
        return cout;
    }
    
    @Override
    public int buildInsert(DynamicExample dynamicExample)
    {
        int[] ret;
        SqlContext sqlContext = SqlUtils.buildInsertSql(dynamicExample);
        if (null == sqlContext.getBatchArgs())
        {
            ret = jdbcTemplate.batchUpdate(sqlContext.getSql());
        }
        else
        {
            ret = jdbcTemplate.batchUpdate(sqlContext.getSql(), sqlContext.getBatchArgs());
        }
        int cout = 0;
        if (null != ret)
        {
            for (int i : ret)
            {
                cout = cout + i;
            }
        }
        return cout;
    }
    
}
