package com.wzj.model;

import javax.persistence.*;

@Table(name = "commodity_type")
public class CommodityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类名称
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 分类图标
     */
    @Column(name = "type_img")
    private String typeImg;

    /**
     * 开启关闭  0关闭  1开启
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sotck;

    /**
     * 父级id   如果有多级分类
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 入驻商家id
     */
    @Column(name = "kindergarten_id")
    private Long kindergartenId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类名称
     *
     * @return type_name - 分类名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置分类名称
     *
     * @param typeName 分类名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取分类图标
     *
     * @return type_img - 分类图标
     */
    public String getTypeImg() {
        return typeImg;
    }

    /**
     * 设置分类图标
     *
     * @param typeImg 分类图标
     */
    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg;
    }

    /**
     * 获取开启关闭  0关闭  1开启
     *
     * @return status - 开启关闭  0关闭  1开启
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置开启关闭  0关闭  1开启
     *
     * @param status 开启关闭  0关闭  1开启
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取排序
     *
     * @return sotck - 排序
     */
    public Integer getSotck() {
        return sotck;
    }

    /**
     * 设置排序
     *
     * @param sotck 排序
     */
    public void setSotck(Integer sotck) {
        this.sotck = sotck;
    }

    /**
     * 获取父级id   如果有多级分类
     *
     * @return type_id - 父级id   如果有多级分类
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置父级id   如果有多级分类
     *
     * @param typeId 父级id   如果有多级分类
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取入驻商家id
     *
     * @return kindergarten_id - 入驻商家id
     */
    public Long getKindergartenId() {
        return kindergartenId;
    }

    /**
     * 设置入驻商家id
     *
     * @param kindergartenId 入驻商家id
     */
    public void setKindergartenId(Long kindergartenId) {
        this.kindergartenId = kindergartenId;
    }
}