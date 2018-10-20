package com.wzj.model;

import javax.persistence.*;

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 添加时间
     */
    private String time;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 反馈内容
     */
    private String text;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取添加时间
     *
     * @return time - 添加时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置添加时间
     *
     * @param time 添加时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取用户id
     *
     * @return uid - 用户id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置用户id
     *
     * @param uid 用户id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取反馈内容
     *
     * @return text - 反馈内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置反馈内容
     *
     * @param text 反馈内容
     */
    public void setText(String text) {
        this.text = text;
    }
}