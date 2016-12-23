package com.cxx.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cxx.mapper.DynamicExample.Criteria;
import com.cxx.mapper.DynamicExample.Criterion;
import com.cxx.pojo.DynamicBean;

import net.sf.cglib.beans.BeanMap;

public class SqlUtils
{
    /**
     * 
     * @function: 构建查询sql
     * @param dynamicExample
     * @return SqlContext
     * @exception @author:chenxx
     * @since 1.0.0
     */
    public static SqlContext buildQuerySql(final DynamicExample dynamicExample)
    {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<Object>();
        if (null != dynamicExample.getQuerySqlClause())
        {
            sql = sql.append(dynamicExample.getQuerySqlClause());
        }
        else
        {
            sql.append("SELECT ");
            if (dynamicExample.distinct)
            {
                sql.append(" DISTINCT ");
            }
            String[] columns = dynamicExample.getColumnList();
            if (null != columns)
            {
                for (int i = 0; i < columns.length; i++)
                {
                    if (columns.length == (i + 1))
                    {
                        sql.append(columns[i]);
                    }
                    else
                    {
                        sql.append(columns[i]).append(",");
                    }
                }
            }
            else
            {
                sql.append(" * ");
            }
            sql.append(" FROM ").append(dynamicExample.getTableName());
            List<Criteria> oredCriteria = dynamicExample.getOredCriteria();
            if (null != oredCriteria)
            {
                
                for (int k = 0; k < oredCriteria.size(); k++)
                {
                    Criteria criteria = oredCriteria.get(k);
                    if (criteria.isValid())
                    {
                        if (k == 0)
                        {
                            sql.append(" WHERE (");
                        }
                        else
                        {
                            sql.append(" OR (");
                        }
                        List<Criterion> criterions = criteria.getAllCriteria();
                        if (null != criterions)
                        {
                            for (int i = 0; i < criterions.size(); i++)
                            {
                                Criterion criterion = criterions.get(i);
                                if (i > 0)
                                {
                                    sql.append(" AND ");
                                }
                                if (null != criteria.getAlias())
                                {
                                    sql.append(criteria.getAlias()).append(".");
                                }
                                if (criterion.isNoValue())
                                {
                                    sql.append(criterion.getCondition());
                                }
                                if (criterion.isSingleValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                }
                                if (criterion.isBetweenValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                    sql.append(" AND ").append(criterion.getSecondValue());
                                }
                                if (criterion.isListValue())
                                {
                                    sql.append(criterion.getCondition());
                                    List<?> listValue = (List<?>)criterion.getValue();
                                    if (null != listValue)
                                    {
                                        for (int j = 0; j < listValue.size(); j++)
                                        {
                                            if (j == 0)
                                            {
                                                sql.append(" ( ");
                                            }
                                            sql.append(" '").append(listValue.get(j)).append("' ");
                                            if ((j + 1) == listValue.size())
                                            {
                                                sql.append(" ) ");
                                            }
                                            else
                                            {
                                                sql.append(",");
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                        sql.append(" ) ");
                    }
                }
                
            }
            String orderBy = dynamicExample.getOrderByClause();
            if (null != orderBy)
            {
                sql.append(" order by ").append(orderBy);
            }
            
            int limitStart = dynamicExample.getLimitStart();
            if (limitStart > -1)
            {
                sql.append(" limit ").append(limitStart).append(",").append(dynamicExample.getLimitEnd());
            }
        }
        return new SqlContext(sql, dynamicExample.getPrimaryKey(), params);
    }
    
    public static SqlContext buildCountSql(final DynamicExample dynamicExample)
    {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<Object>();
        if (null != dynamicExample.getQuerySqlClause())
        {
            sql = sql.append(dynamicExample.getQuerySqlClause());
        }
        else
        {
            sql.append("SELECT COUNT(*) as cont  FROM ").append(dynamicExample.getTableName());
            List<Criteria> oredCriteria = dynamicExample.getOredCriteria();
            if (null != oredCriteria)
            {
                
                for (int k = 0; k < oredCriteria.size(); k++)
                {
                    Criteria criteria = oredCriteria.get(k);
                    if (criteria.isValid())
                    {
                        if (k == 0)
                        {
                            sql.append(" WHERE (");
                        }
                        else
                        {
                            sql.append(" OR (");
                        }
                        List<Criterion> criterions = criteria.getAllCriteria();
                        if (null != criterions)
                        {
                            for (int i = 0; i < criterions.size(); i++)
                            {
                                Criterion criterion = criterions.get(i);
                                if (i > 0)
                                {
                                    sql.append(" AND ");
                                }
                                if (null != criteria.getAlias())
                                {
                                    sql.append(criteria.getAlias()).append(".");
                                }
                                if (criterion.isNoValue())
                                {
                                    sql.append(criterion.getCondition());
                                }
                                if (criterion.isSingleValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                }
                                if (criterion.isBetweenValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                    sql.append(" AND ").append(criterion.getSecondValue());
                                }
                                if (criterion.isListValue())
                                {
                                    sql.append(criterion.getCondition());
                                    List<?> listValue = (List<?>)criterion.getValue();
                                    if (null != listValue)
                                    {
                                        for (int j = 0; j < listValue.size(); j++)
                                        {
                                            if (j == 0)
                                            {
                                                sql.append(" ( ");
                                            }
                                            sql.append(" '").append(listValue.get(j)).append("' ");
                                            if ((j + 1) == listValue.size())
                                            {
                                                sql.append(" ) ");
                                            }
                                            else
                                            {
                                                sql.append(",");
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                        sql.append(" ) ");
                    }
                }
                
            }
            String orderBy = dynamicExample.getOrderByClause();
            if (null != orderBy)
            {
                sql.append(" order by ").append(orderBy);
            }
            
            int limitStart = dynamicExample.getLimitStart();
            if (limitStart > -1)
            {
                sql.append(" limit ").append(limitStart).append(",").append(dynamicExample.getLimitEnd());
            }
        }
        return new SqlContext(sql, dynamicExample.getPrimaryKey(), params);
    }
    
    public static SqlContext buildInsertSql(final DynamicExample dynamicExample)
    {
        StringBuilder sql = new StringBuilder();
        String primaryName = dynamicExample.getPrimaryKey();
        List<Object[]> batchArgs = new ArrayList<>();
        List<Object> params = new ArrayList<Object>();
        DynamicBean dynamicBean = null;
        List<Object> list = new ArrayList<>();
        if (null != dynamicExample.getEntity())
        {
            list.add(dynamicExample.getEntity());
        }
        else
        {
            list = dynamicExample.getEntitys();
        }
        if (null != list && !list.isEmpty())
        {
            
            dynamicBean = new DynamicBean(list.get(0));
        }
        if (dynamicBean == null && null == dynamicExample.getEntitys())
        {
            return new SqlContext(sql, primaryName, params);
        }
        String tableName = dynamicExample.getTableName();
        String[] columns = dynamicExample.getColumnList();
        sql.append("INSERT INTO ");
        sql.append(tableName);
        sql.append("(");
        StringBuilder args = new StringBuilder();
        args.append("(");
        if (null != columns)
        {
            for (String columnName : columns)
            {
                String propertyName = convertUnderscoreNameToPropertyName(columnName);
                Object value = dynamicBean.getValue(propertyName);
                sql.append(columnName);
                args.append("?");
                params.add(value);
                sql.append(",");
                args.append(",");
            }
            sql.deleteCharAt(sql.length() - 1);
            args.deleteCharAt(args.length() - 1);
            args.append(")");
            sql.append(")");
            sql.append(" values ");
            sql.append(args);
            for (int i = 0; i < list.size(); i++)
            {
                if (i == 0)
                {
                    batchArgs.add(params.toArray());
                    continue;
                }
                params = new ArrayList<Object>();
                dynamicBean = new DynamicBean(list.get(i));
                for (String columnName : columns)
                {
                    String propertyName = convertUnderscoreNameToPropertyName(columnName);
                    Object value = dynamicBean.getValue(propertyName);
                    params.add(value);
                }
                batchArgs.add(params.toArray());
            }
            
        }
        else if (null != dynamicBean)
        {
            for (int i = 0; i < list.size(); i++)
            {
                params = new ArrayList<Object>();
                dynamicBean = new DynamicBean(list.get(i));
                BeanMap propertyMap = dynamicBean.getBeanMap();
                for (Object propertyName : propertyMap.keySet())
                {
                    String columnName = convertPropertyNameToUnderscoreName(propertyName.toString());
                    Object value = dynamicBean.getValue(propertyName.toString());
                    if (i == 0)
                    {
                        sql.append(columnName);
                        args.append("?");
                        sql.append(",");
                        args.append(",");
                    }
                    params.add(value);
                }
                batchArgs.add(params.toArray());
            }
            sql.deleteCharAt(sql.length() - 1);
            args.deleteCharAt(args.length() - 1);
            args.append(")");
            sql.append(")");
            sql.append(" values ");
            sql.append(args);
        }
        SqlContext sqlContext = new SqlContext(sql, primaryName, null);
        sqlContext.setBatchArgs(batchArgs);
        return sqlContext;
    }
    
    public static SqlContext buildUpdateSql(final DynamicExample dynamicExample)
    {
        StringBuilder sql = new StringBuilder();
        String primaryName = dynamicExample.getPrimaryKey();
        List<Object> params = new ArrayList<Object>();
        DynamicBean dynamicBean = null;
        if (null != dynamicExample.getEntity())
        {
            dynamicBean = new DynamicBean(dynamicExample.getEntity());
        }
        if (dynamicBean == null)
        {
            return new SqlContext(sql, primaryName, params);
        }
        String tableName = dynamicExample.getTableName();
        // 获取属性信息
        String[] columns = dynamicExample.getColumnList();
        sql.append("UPDATE ");
        sql.append(tableName);
        sql.append(" SET ");
        Object primaryValue = null;
        if (null != columns)
        {
            for (String columnName : columns)
            {
                String propertyName = convertUnderscoreNameToPropertyName(columnName);
                Object value = dynamicBean.getValue(propertyName);
                if (value == null)
                {
                    continue;
                }
                if (null != primaryName && columnName.equalsIgnoreCase(primaryName))
                {
                    primaryValue = value;
                }
                sql.append(columnName);
                sql.append(" = ?");
                params.add(value);
                sql.append(",");
            }
            sql.deleteCharAt(sql.length() - 1);
        }
        else
        {
            BeanMap propertyMap = dynamicBean.getBeanMap();
            if (null != propertyMap)
            {
                for (Object object : propertyMap.keySet())
                {
                    String columnName = convertPropertyNameToUnderscoreName(object.toString());
                    Object value = dynamicBean.getValue(object.toString());
                    if (value == null)
                    {
                        continue;
                    }
                    if (null != primaryName && columnName.equalsIgnoreCase(primaryName))
                    {
                        primaryValue = value;
                    }
                    sql.append(columnName);
                    sql.append(" = ?");
                    params.add(value);
                    sql.append(",");
                    
                }
                sql.deleteCharAt(sql.length() - 1);
            }
        }
        if (null != primaryName)
        {
            sql.append(" WHERE ");
            sql.append(primaryName);
            sql.append(" = ?");
            params.add(primaryValue);
        }
        else
        {
            List<Criteria> oredCriteria = dynamicExample.getOredCriteria();
            if (null != oredCriteria)
            {
                for (int k = 0; k < oredCriteria.size(); k++)
                {
                    Criteria criteria = oredCriteria.get(k);
                    if (criteria.isValid())
                    {
                        if (k == 0)
                        {
                            sql.append(" WHERE (");
                        }
                        else
                        {
                            sql.append(" OR (");
                        }
                        List<Criterion> criterions = criteria.getAllCriteria();
                        if (null != criterions)
                        {
                            for (int i = 0; i < criterions.size(); i++)
                            {
                                Criterion criterion = criterions.get(i);
                                if (i > 0)
                                {
                                    sql.append(" AND ");
                                }
                                if (null != criteria.getAlias())
                                {
                                    sql.append(criteria.getAlias()).append(".");
                                }
                                if (criterion.isNoValue())
                                {
                                    sql.append(criterion.getCondition());
                                }
                                if (criterion.isSingleValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                }
                                if (criterion.isBetweenValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                    sql.append(" AND ").append(criterion.getSecondValue());
                                }
                                if (criterion.isListValue())
                                {
                                    sql.append(criterion.getCondition());
                                    List<?> listValue = (List<?>)criterion.getValue();
                                    if (null != listValue)
                                    {
                                        for (int j = 0; j < listValue.size(); j++)
                                        {
                                            if (j == 0)
                                            {
                                                sql.append(" ( ");
                                            }
                                            sql.append(" '").append(listValue.get(j)).append("' ");
                                            if ((j + 1) == listValue.size())
                                            {
                                                sql.append(" ) ");
                                            }
                                            else
                                            {
                                                sql.append(",");
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                        sql.append(" ) ");
                    }
                }
                
            }
        }
        return new SqlContext(sql, primaryName, params);
    }
    
    public static SqlContext buildBatchUpdateSql(final DynamicExample dynamicExample)
    {
        HashMap<String, Boolean> columnMap = new HashMap<String, Boolean>();
        StringBuilder sql = new StringBuilder();
        String primaryName = dynamicExample.getPrimaryKey();
        List<Object[]> batchArgs = new ArrayList<>();
        List<Object> params = new ArrayList<Object>();
        DynamicBean dynamicBean = null;
        List<Object> list = dynamicExample.getEntitys();
        if (null != list && !list.isEmpty())
        {
            
            dynamicBean = new DynamicBean(list.get(0));
        }
        if (dynamicBean == null)
        {
            return new SqlContext(sql, primaryName, params);
        }
        String tableName = dynamicExample.getTableName();
        // 获取属性信息
        String[] columns = dynamicExample.getColumnList();
        sql.append("UPDATE ");
        sql.append(tableName);
        sql.append(" SET ");
        Object primaryValue = null;
        if (null != columns)
        {
            for (String columnName : columns)
            {
                String propertyName = convertUnderscoreNameToPropertyName(columnName);
                Object value = dynamicBean.getValue(propertyName);
                if (null != primaryName && columnName.equalsIgnoreCase(primaryName))
                {
                    primaryValue = value;
                }
                columnMap.put(columnName, true);
                sql.append(columnName);
                sql.append(" = ?");
                params.add(value);
                sql.append(",");
            }
            sql.deleteCharAt(sql.length() - 1);
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                params = new ArrayList<Object>();
                dynamicBean = new DynamicBean(list.get(i));
                BeanMap propertyMap = dynamicBean.getBeanMap();
                for (Object propertyName : propertyMap.keySet())
                {
                    String columnName = convertPropertyNameToUnderscoreName(propertyName.toString());
                    Object value = dynamicBean.getValue(propertyName.toString());
                    if (null != primaryName && primaryName.equalsIgnoreCase(propertyName.toString()))
                    {
                        primaryValue = value;
                    }
                    if (i == 0)
                    {
                        sql.append(columnName);
                        sql.append(" = ?");
                        params.add(value);
                        sql.append(",");
                    }
                }
                if (null != primaryName)
                {
                    params.add(primaryValue);
                }
                batchArgs.add(params.toArray());
            }
            sql.deleteCharAt(sql.length() - 1);
        }
        if (null != primaryName)
        {
            sql.append(" WHERE ");
            sql.append(primaryName);
            sql.append(" = ?");
        }
        else
        {
            List<Criteria> oredCriteria = dynamicExample.getOredCriteria();
            if (null != oredCriteria)
            {
                for (int k = 0; k < oredCriteria.size(); k++)
                {
                    Criteria criteria = oredCriteria.get(k);
                    if (criteria.isValid())
                    {
                        if (k == 0)
                        {
                            sql.append(" WHERE (");
                        }
                        else
                        {
                            sql.append(" OR (");
                        }
                        List<Criterion> criterions = criteria.getAllCriteria();
                        if (null != criterions)
                        {
                            for (int i = 0; i < criterions.size(); i++)
                            {
                                Criterion criterion = criterions.get(i);
                                if (i > 0)
                                {
                                    sql.append(" AND ");
                                }
                                if (null != criteria.getAlias())
                                {
                                    sql.append(criteria.getAlias()).append(".");
                                }
                                if (criterion.isNoValue())
                                {
                                    sql.append(criterion.getCondition());
                                }
                                if (criterion.isSingleValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                }
                                if (criterion.isBetweenValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                    sql.append(" AND ").append(criterion.getSecondValue());
                                }
                                if (criterion.isListValue())
                                {
                                    sql.append(criterion.getCondition());
                                    List<?> listValue = (List<?>)criterion.getValue();
                                    if (null != listValue)
                                    {
                                        for (int j = 0; j < listValue.size(); j++)
                                        {
                                            if (j == 0)
                                            {
                                                sql.append(" ( ");
                                            }
                                            sql.append(" '").append(listValue.get(j)).append("' ");
                                            if ((j + 1) == listValue.size())
                                            {
                                                sql.append(" ) ");
                                            }
                                            else
                                            {
                                                sql.append(",");
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                        sql.append(" ) ");
                    }
                }
                
            }
        }
        SqlContext sqlContext = new SqlContext(sql, primaryName, null);
        sqlContext.setBatchArgs(batchArgs);
        return sqlContext;
    }
    
    public static SqlContext buildDeleteSql(final DynamicExample dynamicExample)
    {
        StringBuilder sql = new StringBuilder();
        String primaryName = dynamicExample.getPrimaryKey();
        List<Object[]> batchArgs = new ArrayList<>();
        List<Object> params = new ArrayList<Object>();
        DynamicBean dynamicBean = null;
        Object primaryValue = null;
        List<Object> list = new ArrayList<>();
        if (null != dynamicExample.getEntity())
        {
            list.add(dynamicExample.getEntity());
        }
        else
        {
            list = dynamicExample.getEntitys();
        }
        if (null != list && !list.isEmpty())
        {
            
            dynamicBean = new DynamicBean(list.get(0));
        }
        if (dynamicBean == null && null == dynamicExample.getEntitys())
        {
            return new SqlContext(sql, primaryName, params);
        }
        String tableName = dynamicExample.getTableName();
        String[] columns = dynamicExample.getColumnList();
        sql.append("DELETE FROM ");
        sql.append(tableName);
        if (null != primaryName)
        {
            sql.append(" WHERE ");
            sql.append(primaryName);
            sql.append(" = ?");
            String propertyName = convertUnderscoreNameToPropertyName(primaryName);
            primaryValue = dynamicBean.getValue(propertyName);
            params.add(primaryValue);
            for (int i = 0; i < list.size(); i++)
            {
                if (i == 0)
                {
                    batchArgs.add(params.toArray());
                    continue;
                }
                params = new ArrayList<Object>();
                dynamicBean = new DynamicBean(list.get(i));
                primaryValue = dynamicBean.getValue(propertyName);
                params.add(primaryValue);
                batchArgs.add(params.toArray());
            }
        }
        else if (null != columns)
        {
            sql.append(" WHERE ");
            for (String columnName : columns)
            {
                String propertyName = convertUnderscoreNameToPropertyName(columnName);
                Object value = dynamicBean.getValue(propertyName);
                sql.append(columnName);
                sql.append(" = ?");
                params.add(value);
                sql.append(" AND ");
            }
            sql.delete((sql.length() - 4), sql.length());
            for (int i = 0; i < list.size(); i++)
            {
                if (i == 0)
                {
                    batchArgs.add(params.toArray());
                    continue;
                }
                params = new ArrayList<Object>();
                dynamicBean = new DynamicBean(list.get(i));
                for (String columnName : columns)
                {
                    String propertyName = convertUnderscoreNameToPropertyName(columnName);
                    Object value = dynamicBean.getValue(propertyName);
                    params.add(value);
                }
                batchArgs.add(params.toArray());
            }
        }
        else if (null != dynamicBean)
        {
            sql.append(" WHERE ");
            for (int i = 0; i < list.size(); i++)
            {
                params = new ArrayList<Object>();
                dynamicBean = new DynamicBean(list.get(i));
                BeanMap propertyMap = dynamicBean.getBeanMap();
                for (Object propertyName : propertyMap.keySet())
                {
                    String columnName = convertPropertyNameToUnderscoreName(propertyName.toString());
                    Object value = dynamicBean.getValue(propertyName.toString());
                    if (i == 0)
                    {
                        sql.append(columnName);
                        sql.append(" = ?");
                        sql.append(" AND ");
                    }
                    params.add(value);
                }
                batchArgs.add(params.toArray());
            }
            sql.delete((sql.length() - 4), sql.length());
        }
        else
        {
            List<Criteria> oredCriteria = dynamicExample.getOredCriteria();
            if (null != oredCriteria)
            {
                for (int k = 0; k < oredCriteria.size(); k++)
                {
                    Criteria criteria = oredCriteria.get(k);
                    if (criteria.isValid())
                    {
                        if (k == 0)
                        {
                            sql.append(" WHERE (");
                        }
                        else
                        {
                            sql.append(" OR (");
                        }
                        List<Criterion> criterions = criteria.getAllCriteria();
                        if (null != criterions)
                        {
                            for (int i = 0; i < criterions.size(); i++)
                            {
                                Criterion criterion = criterions.get(i);
                                if (i > 0)
                                {
                                    sql.append(" AND ");
                                }
                                if (null != criteria.getAlias())
                                {
                                    sql.append(criteria.getAlias()).append(".");
                                }
                                if (criterion.isNoValue())
                                {
                                    sql.append(criterion.getCondition());
                                }
                                if (criterion.isSingleValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                }
                                if (criterion.isBetweenValue())
                                {
                                    sql.append(criterion.getCondition()).append(criterion.getValue());
                                    sql.append(" AND ").append(criterion.getSecondValue());
                                }
                                if (criterion.isListValue())
                                {
                                    sql.append(criterion.getCondition());
                                    List<?> listValue = (List<?>)criterion.getValue();
                                    if (null != listValue)
                                    {
                                        for (int j = 0; j < listValue.size(); j++)
                                        {
                                            if (j == 0)
                                            {
                                                sql.append(" ( ");
                                            }
                                            sql.append(" '").append(listValue.get(j)).append("' ");
                                            if ((j + 1) == listValue.size())
                                            {
                                                sql.append(" ) ");
                                            }
                                            else
                                            {
                                                sql.append(",");
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                        sql.append(" ) ");
                    }
                }
                
            }
        }
        SqlContext sqlContext = new SqlContext(sql, primaryName, null);
        sqlContext.setBatchArgs(batchArgs);
        return sqlContext;
    }
    
    public static class SqlContext
    {
        /** 执行的sql */
        private StringBuilder sql;
        
        /** 主键名称 */
        private String primaryKey;
        
        /** 参数，对应sql中的?号 */
        private List<Object> params;
        
        List<Object[]> batchArgs;
        
        public SqlContext(StringBuilder sql, String primaryKey, List<Object> params)
        {
            this.sql = sql;
            this.primaryKey = primaryKey;
            this.params = params;
        }
        
        public String getSql()
        {
            if (null != sql)
            {
                return sql.toString();
            }
            return null;
        }
        
        public void setSql(StringBuilder sql)
        {
            this.sql = sql;
        }
        
        public void setSql(String sql)
        {
            this.sql = new StringBuilder(sql);
        }
        
        public String getPrimaryKey()
        {
            return primaryKey;
        }
        
        public void setPrimaryKey(String primaryKey)
        {
            this.primaryKey = primaryKey;
        }
        
        public Object[] getArgs()
        {
            if (null != params)
            {
                return params.toArray();
            }
            return null;
        }
        
        public List<Object> getParams()
        {
            return params;
        }
        
        public void setParams(List<Object> params)
        {
            this.params = params;
        }
        
        public List<Object[]> getBatchArgs()
        {
            return batchArgs;
        }
        
        public void setBatchArgs(List<Object[]> batchArgs)
        {
            this.batchArgs = batchArgs;
        }
        
    }
    
    /**
     * 
     * @function: 驼峰转下滑线
     * @param name
     * @return String
     * @exception @author:chenxx
     * @since 1.0.0
     */
    public static String convertPropertyNameToUnderscoreName(String propertyName)
    {
        StringBuilder result = new StringBuilder();
        if (propertyName != null && propertyName.length() > 0)
        {
            result.append(propertyName.substring(0, 1).toLowerCase());
            for (int i = 1; i < propertyName.length(); i++)
            {
                String s = propertyName.substring(i, i + 1);
                char tmp = s.charAt(0);
                if ((tmp <= 'Z') && (tmp >= 'A'))
                {
                    result.append("_").append(s.toLowerCase());
                }
                else
                {
                    result.append(s.toLowerCase());
                }
            }
        }
        return result.toString();
    }
    
    /**
     * 
     * @function: 下滑线转驼峰
     * @param name
     * @return String
     * @exception @author:chenxx
     * @since 1.0.0
     */
    public static String convertUnderscoreNameToPropertyName(String name)
    {
        StringBuilder result = new StringBuilder();
        boolean nextIsUpper = false;
        if (name != null && name.length() > 0)
        {
            if (name.length() > 1 && name.substring(1, 2).equals("_"))
            {
                result.append(name.substring(0, 1).toUpperCase());
            }
            else
            {
                result.append(name.substring(0, 1).toLowerCase());
            }
            for (int i = 1; i < name.length(); i++)
            {
                String s = name.substring(i, i + 1);
                if (s.equals("_"))
                {
                    nextIsUpper = true;
                }
                else
                {
                    if (nextIsUpper)
                    {
                        result.append(s.toUpperCase());
                        nextIsUpper = false;
                    }
                    else
                    {
                        result.append(s.toLowerCase());
                    }
                }
            }
        }
        return result.toString();
    }
}
