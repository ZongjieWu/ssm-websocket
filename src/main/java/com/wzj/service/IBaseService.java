package com.wzj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface IBaseService<T> {


    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
     T queryById(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
     List<T> queryAll();

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     *
     * @param record
     * @return
     */
     T queryOne(T record);

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     *
     * @param o
     * @return
     */
     T queryOneExample(Object o);

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
     List<T> queryListByWhere(T record);

    /**
     * 分页查询
     *
     * @param page
     * @param rows
     * @param record
     * @return
     */
     PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record) ;

    /**
     * 根据条件查询数据列表
     * 使用example 查询
     * @param o
     * @return
     */
    List<T> queryListByWhereExample(Object o);

    /**
     * 分页查询
     * 使用example 查询
     * @param page
     * @param rows
     * @param o
     * @return
     */
    PageInfo<T> queryPageListByWhereExample(Integer page, Integer rows, Object o) ;


    /**
     * 新增数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
     Integer saveSelective(T record) ;


    /**
     * 修改数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
     Integer updateSelective(T record);

    /**
     * 修改数据，使用不为null的字段，条件
     *
     * @param record
     * @return
     */
     Integer updateByWhere(T record, Object o);
    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
     Integer deleteById(Long id) ;

    /**
     * 批量删除
     * @param clazz
     * @param property
     * @param values
     * @return
     */
     Integer deleteByIds(Class<T> clazz, String property, List<Object> values) ;
    /**
     * 根据条件做删除
     *
     * @param record
     * @return
     */
     Integer deleteByWhere(T record) ;
}
