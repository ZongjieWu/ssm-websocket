package com.wzj.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public abstract class BaseService<T> implements IBaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> queryAll() {
        return mapper.select(null);
    }

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     *
     * @param record
     * @return
     */
    public T queryOne(T record) {
        return mapper.selectOne(record);
    }

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     *
     * @param o
     * @return
     */
    @Override
    public T queryOneExample(Object o) {
        return mapper.selectOneByExample(o);
    }

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return mapper.select(record);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param rows
     * @param record
     * @return
     */
    public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record) {
        // 设置分页条件
        PageHelper.startPage(page, rows);
        List<T> list = this.queryListByWhere(record);
        return new PageInfo<T>(list);
    }

    @Override
    public List<T> queryListByWhereExample(Object o) {
        return mapper.selectByExample(o);
    }

    @Override
    public PageInfo<T> queryPageListByWhereExample(Integer page, Integer rows, Object o) {
        // 设置分页条件
        PageHelper.startPage(page, rows);
        List<T> list = this.queryListByWhereExample(o);
        return new PageInfo<T>(list);
    }

    /**
     * 新增数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    public Integer saveSelective(T record) {
        //record.setCreated(new Date());
        //record.setUpdated(record.getCreated());
        return mapper.insertSelective(record);
    }



    /**
     * 修改数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    public Integer updateSelective(T record) {
        //record.setUpdated(new Date());
        return mapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 修改数据，使用不为null的字段，条件
     *
     * @param record
     * @return
     */
    @Override
    public Integer updateByWhere(T record, Object o) {

        return mapper.updateByExampleSelective(record, o);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        //record.setUpdated(new Date());
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param clazz
     * @param property
     * @param values
     * @return
     */
    public Integer deleteByIds(Class<T> clazz, String property, List<Object> values) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, values);
        return mapper.deleteByExample(example);
    }

    /**
     * 根据条件做删除
     *
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record) {
        return mapper.delete(record);
    }

}

