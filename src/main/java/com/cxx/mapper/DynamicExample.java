package com.cxx.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class DynamicExample implements Serializable
{
    /**
     * 新增、修改对象
     */
    private Object entity;
    
    /**
     * 新增、修改对象集
     */
    private List<Object> entitys;
    
    /**
     * serialVersionUID: DynamicExample
     * 
     * @since 1.0.0
     */
    private static final long serialVersionUID = -1862372462685254166L;
    
    /**
     * 查询字段
     */
    private String[] columnList;
    
    /**
     * 完整sql语句
     */
    private String querySqlClause;
    
    /**
     * 排序规则
     */
    protected String orderByClause;
    
    /**
     * 是否去重
     */
    protected boolean distinct;
    
    /**
     * 主键
     */
    protected String primaryKey;
    
    /**
     * 表名
     */
    protected String tableName;
    
    /**
     * 查询条件
     */
    protected List<Criteria> oredCriteria;
    
    /**
     * 开始下标
     */
    protected int limitStart = -1;
    
    /**
     * 结束下标
     */
    protected int limitEnd = -1;
    
    public DynamicExample()
    {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    public DynamicExample(String tableName)
    {
        this.tableName = tableName;
        oredCriteria = new ArrayList<Criteria>();
    }
    
    public Object getEntity()
    {
        return entity;
    }
    
    public void setEntity(Object entity)
    {
        this.entity = entity;
    }
    
    public List<Object> getEntitys()
    {
        return entitys;
    }
    
    public void setEntitys(List<Object> entitys)
    {
        this.entitys = entitys;
    }
    
    public String getPrimaryKey()
    {
        return primaryKey;
    }
    
    public void setPrimaryKey(String primaryKey)
    {
        this.primaryKey = primaryKey;
    }
    
    public String[] getColumnList()
    {
        return columnList;
    }
    
    public void setColumnList(String[] columnList)
    {
        this.columnList = columnList;
    }
    
    public void addColumn(String column)
    {
        if (null != this.columnList && null != column)
        {
            ArrayUtils.add(this.columnList, column);
        }
    }
    
    public String getQuerySqlClause()
    {
        return querySqlClause;
    }
    
    public void setQuerySqlClause(String querySqlClause)
    {
        this.querySqlClause = querySqlClause;
    }
    
    public void setOrderByClause(String orderByClause)
    {
        this.orderByClause = orderByClause;
    }
    
    public String getOrderByClause()
    {
        return orderByClause;
    }
    
    public String getTableName()
    {
        return tableName;
    }
    
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    
    public void setDistinct(boolean distinct)
    {
        this.distinct = distinct;
    }
    
    public boolean isDistinct()
    {
        return distinct;
    }
    
    public List<Criteria> getOredCriteria()
    {
        return oredCriteria;
    }
    
    public void or(Criteria criteria)
    {
        oredCriteria.add(criteria);
    }
    
    public Criteria or(String alias)
    {
        Criteria criteria = createCriteriaInternal(alias);
        oredCriteria.add(criteria);
        return criteria;
    }
    
    public Criteria or()
    {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    public Criteria createCriteria()
    {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0)
        {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    public Criteria createCriteria(String alias)
    {
        Criteria criteria = createCriteriaInternal(alias);
        if (oredCriteria.size() == 0)
        {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    protected Criteria createCriteriaInternal()
    {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    protected Criteria createCriteriaInternal(String alias)
    {
        Criteria criteria = new Criteria(alias);
        return criteria;
    }
    
    public void clear()
    {
        oredCriteria.clear();
        columnList = null;
        orderByClause = null;
        querySqlClause = null;
        distinct = false;
        primaryKey = null;
        entity = null;
        entitys = null;
    }
    
    public void setLimitStart(int limitStart)
    {
        this.limitStart = limitStart;
    }
    
    public int getLimitStart()
    {
        return limitStart;
    }
    
    public void setLimitEnd(int limitEnd)
    {
        this.limitEnd = limitEnd;
    }
    
    public int getLimitEnd()
    {
        return limitEnd;
    }
    
    public static class Criteria extends GeneratedCriteria implements Serializable
    {
        /**
         * serialVersionUID: Criteria
         * 
         * @since 1.0.0
         */
        
        private static final long serialVersionUID = 4242157649751900005L;
        
        /**
         * 别名
         */
        private String alias;
        
        protected Criteria()
        {
            super();
        }
        
        protected Criteria(String alias)
        {
            super();
            this.alias = alias;
        }
        
        public String getAlias()
        {
            return alias;
        }
        
        public void setAlias(String alias)
        {
            this.alias = alias;
        }
    }
    
    public static class Criterion implements Serializable
    {
        private String condition;
        
        private Object value;
        
        private Object secondValue;
        
        private boolean noValue;
        
        private boolean singleValue;
        
        private boolean betweenValue;
        
        private boolean listValue;
        
        private String typeHandler;
        
        /**
         * erp_group
         */
        private static final long serialVersionUID = 1L;
        
        public String getCondition()
        {
            return condition;
        }
        
        public Object getValue()
        {
            return value;
        }
        
        public Object getSecondValue()
        {
            return secondValue;
        }
        
        public boolean isNoValue()
        {
            return noValue;
        }
        
        public boolean isSingleValue()
        {
            return singleValue;
        }
        
        public boolean isBetweenValue()
        {
            return betweenValue;
        }
        
        public boolean isListValue()
        {
            return listValue;
        }
        
        public String getTypeHandler()
        {
            return typeHandler;
        }
        
        protected Criterion(String condition)
        {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        
        protected Criterion(String condition, Object value, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>)
            {
                this.listValue = true;
            }
            else
            {
                this.singleValue = true;
            }
        }
        
        protected Criterion(String condition, Object value)
        {
            this(condition, value, null);
        }
        
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }
        
        protected Criterion(String condition, Object value, Object secondValue)
        {
            this(condition, value, secondValue, null);
        }
    }
    
    protected abstract static class GeneratedCriteria implements Serializable
    {
        /**
         * serialVersionUID: GeneratedCriteria
         * 
         * @since 1.0.0
         */
        private static final long serialVersionUID = -763621388263781174L;
        
        protected List<Criterion> criteria;
        
        protected GeneratedCriteria()
        {
            super();
            criteria = new ArrayList<Criterion>();
        }
        
        public boolean isValid()
        {
            return criteria.size() > 0;
        }
        
        public List<Criterion> getAllCriteria()
        {
            return criteria;
        }
        
        public List<Criterion> getCriteria()
        {
            return criteria;
        }
        
        protected void addCriterion(String condition)
        {
            if (condition == null)
            {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }
        
        protected void addCriterionRelated(String condition, Object value, String property)
        {
            if (value == null)
            {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
        
        protected void addCriterion(String condition, Object value, String property)
        {
            if (value == null)
            {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            if (value instanceof List<?>)
            {
                criteria.add(new Criterion(condition, value));
            }
            else
            {
                criteria.add(new Criterion(condition, " '" + value + "' "));
            }
            
        }
        
        protected void addCriterion(String condition, Object value1, Object value2, String property)
        {
            if (value1 == null || value2 == null)
            {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, " '" + value1 + "' ", " '" + value2 + "' "));
        }
        
        public Criteria andIsNull(String field)
        {
            addCriterion(field + " is null");
            return (Criteria)this;
        }
        
        public Criteria andIsNotNull(String field)
        {
            addCriterion(field + " is not null");
            return (Criteria)this;
        }
        
        public Criteria andEqualTo(String field, Object value)
        {
            addCriterion(field + " =", value, field);
            return (Criteria)this;
        }
        
        public Criteria andNotEqualTo(String field, Object value)
        {
            addCriterion(field + " <>", value, field);
            return (Criteria)this;
        }
        
        public Criteria andGreaterThan(String field, Object value)
        {
            addCriterion(field + " >", value, field);
            return (Criteria)this;
        }
        
        public Criteria andGreaterThanOrEqualTo(String field, Object value)
        {
            addCriterion(field + " >=", value, field);
            return (Criteria)this;
        }
        
        public Criteria andLessThan(String field, Object value)
        {
            addCriterion(field + " <", value, field);
            return (Criteria)this;
        }
        
        public Criteria andLessThanOrEqualTo(String field, Object value)
        {
            addCriterion(field + " <=", value, field);
            return (Criteria)this;
        }
        
        public Criteria andIn(String field, List<?> values)
        {
            addCriterion(field + " in", values, field);
            return (Criteria)this;
        }
        
        public Criteria andNotIn(String field, List<?> values)
        {
            addCriterion(field + " not in", values, field);
            return (Criteria)this;
        }
        
        public Criteria andLike(String field, Object value)
        {
            addCriterion(field + " like", value, field);
            return (Criteria)this;
        }
        
        public Criteria andNotLike(String field, Object value)
        {
            addCriterion(field + " not like", value, field);
            return (Criteria)this;
        }
        
        public Criteria andBetween(String field, Object value1, Object value2)
        {
            addCriterion(field + " between", value1, value2, field);
            return (Criteria)this;
        }
        
        public Criteria andNotBetween(String field, Object value1, Object value2)
        {
            addCriterion(field + " not between", value1, value2, field);
            return (Criteria)this;
        }
        
        public Criteria andEqualToRelated(String field, Object value)
        {
            addCriterionRelated(field + " =", value, field);
            return (Criteria)this;
        }
        
        public Criteria andNotEqualToRelated(String field, Object value)
        {
            addCriterionRelated(field + " <>", value, field);
            return (Criteria)this;
        }
        
        public Criteria andGreaterThanRelated(String field, Object value)
        {
            addCriterionRelated(field + " >", value, field);
            return (Criteria)this;
        }
        
        public Criteria andGreaterThanOrEqualToRelated(String field, Object value)
        {
            addCriterionRelated(field + " >=", value, field);
            return (Criteria)this;
        }
        
        public Criteria andLessThanRelated(String field, Object value)
        {
            addCriterionRelated(field + " <", value, field);
            return (Criteria)this;
        }
        
        public Criteria andLessThanOrEqualToRelated(String field, Object value)
        {
            addCriterionRelated(field + " <=", value, field);
            return (Criteria)this;
        }
        
        public Criteria andLikeRelated(String field, Object value)
        {
            addCriterionRelated(field + " like", value, field);
            return (Criteria)this;
        }
        
        public Criteria andNotLikeRelated(String field, Object value)
        {
            addCriterionRelated(field + " not like", value, field);
            return (Criteria)this;
        }
        
    }
}
