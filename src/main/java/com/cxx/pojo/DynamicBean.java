package com.cxx.pojo;

import java.io.Serializable;
import java.util.Map;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

public class DynamicBean implements Serializable
{
    /**
     * serialVersionUID: DynamicBean
     * 
     * @since 1.0.0
     */
    
    private static final long serialVersionUID = 6120264085959768506L;
    
    /**
     * 实体Object
     */
    private Object object = null;
    
    /**
     * 属性map
     */
    private BeanMap beanMap = null;
    
    public DynamicBean()
    {
        super();
    }
    
    /**
     * @function: 创建一个新对象
     *            <p>
     *            createNewInstance: DynamicBean.
     *            </p>
     * @param propertyMap
     */
    public DynamicBean(Map<?, ?> propertyMap)
    {
        this.object = generateBean(propertyMap);
        this.beanMap = BeanMap.create(this.object);
    }
    
    /**
     * 创建一个新对象 createNewInstance: DynamicBean.
     * 
     * @param entity
     */
    public DynamicBean(Object entity)
    {
        this.object = entity;
        this.beanMap = BeanMap.create(entity);
    }
    
    /**
     * 
     * @function: 给bean属性赋值
     * @param property
     * @param value void
     * @exception @author:chenxx
     * @since 1.0.0
     */
    public void setValue(String property, Object value)
    {
        beanMap.put(property, value);
    }
    
    /**
     * 
     * @function: 通过属性名得到属性值
     * @param property
     * @return Object
     * @exception @author:chenxx
     * @since 1.0.0
     */
    public Object getValue(String property)
    {
        return beanMap.get(property);
    }
    
    /**
     * 
     * @function: 得到该实体bean对象
     * @return Object
     * @exception @author:chenxx
     * @since 1.0.0
     */
    public Object getObject()
    {
        return this.object;
    }
    
    public BeanMap getBeanMap()
    {
        return beanMap;
    }
    
    /**
     * 
     * @function: propertyMap
     * @param propertyMap
     * @return Object
     * @exception @author:chenxx
     * @since 1.0.0
     */
    private Object generateBean(Map<?, ?> propertyMap)
    {
        BeanGenerator generator = new BeanGenerator();
        BeanGenerator.addProperties(generator, propertyMap);
        return generator.create();
    }
}
