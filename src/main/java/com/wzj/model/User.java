package com.wzj.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 头像
     */
    @Column(name = "avatar_img")
    private String avatarImg;

    /**
     * 头像
     */
    private String name;

    /**
     * openid
     */
    private String openid;

    /**
     * -2 就是未认证-1就是为未通过 0就是待认证  1通过了
     */
    private Integer kindergarten;

    /**
     * 上线  
     */
    private Integer uid;

    /**
     * 用户金额
     */
    private BigDecimal money;

    /**
     * 用户积分
     */
    private String integrals;

    /**
     * 创建时间
     */
    private String addtime;

    /**
     * 用户手机号
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 用户密码
     */
    private String pwd;

    /**
     * 性别  0保密 1男 2女
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 冻结资金
     */
    @Column(name = "frozen_money")
    private BigDecimal frozenMoney;

    /**
     * 消费积分
     */
    @Column(name = "pay_points")
    private Integer payPoints;

    /**
     * 会员等级积分
     */
    @Column(name = "forzen_money")
    private Integer forzenMoney;

    /**
     * 最后一次登录时间
     */
    @Column(name = "last_login")
    private String lastLogin;

    @Column(name = "last_ip")
    private String lastIp;

    /**
     * 登录次数
     */
    @Column(name = "visit_count")
    private Integer visitCount;

    /**
     * 是否特殊
     */
    @Column(name = "is_special")
    private Integer isSpecial;

    /**
     * 是否生效
     */
    @Column(name = "is_validated")
    private Integer isValidated;

    /**
     * 累计消费
     */
    @Column(name = "credit_line")
    private BigDecimal creditLine;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 会员等级
     */
    @Column(name = "user_rank")
    private Integer userRank;

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
     * 获取头像
     *
     * @return avatar_img - 头像
     */
    public String getAvatarImg() {
        return avatarImg;
    }

    /**
     * 设置头像
     *
     * @param avatarImg 头像
     */
    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    /**
     * 获取头像
     *
     * @return name - 头像
     */
    public String getName() {
        return name;
    }

    /**
     * 设置头像
     *
     * @param name 头像
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取openid
     *
     * @return openid - openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置openid
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取-2 就是未认证-1就是为未通过 0就是待认证  1通过了
     *
     * @return kindergarten - -2 就是未认证-1就是为未通过 0就是待认证  1通过了
     */
    public Integer getKindergarten() {
        return kindergarten;
    }

    /**
     * 设置-2 就是未认证-1就是为未通过 0就是待认证  1通过了
     *
     * @param kindergarten -2 就是未认证-1就是为未通过 0就是待认证  1通过了
     */
    public void setKindergarten(Integer kindergarten) {
        this.kindergarten = kindergarten;
    }

    /**
     * 获取上线  
     *
     * @return uid - 上线  
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置上线  
     *
     * @param uid 上线  
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取用户金额
     *
     * @return money - 用户金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置用户金额
     *
     * @param money 用户金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取用户积分
     *
     * @return integrals - 用户积分
     */
    public String getIntegrals() {
        return integrals;
    }

    /**
     * 设置用户积分
     *
     * @param integrals 用户积分
     */
    public void setIntegrals(String integrals) {
        this.integrals = integrals;
    }

    /**
     * 获取创建时间
     *
     * @return addtime - 创建时间
     */
    public String getAddtime() {
        return addtime;
    }

    /**
     * 设置创建时间
     *
     * @param addtime 创建时间
     */
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取用户手机号
     *
     * @return mobile_phone - 用户手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置用户手机号
     *
     * @param mobilePhone 用户手机号
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取用户密码
     *
     * @return pwd - 用户密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置用户密码
     *
     * @param pwd 用户密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取性别  0保密 1男 2女
     *
     * @return sex - 性别  0保密 1男 2女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别  0保密 1男 2女
     *
     * @param sex 性别  0保密 1男 2女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取冻结资金
     *
     * @return frozen_money - 冻结资金
     */
    public BigDecimal getFrozenMoney() {
        return frozenMoney;
    }

    /**
     * 设置冻结资金
     *
     * @param frozenMoney 冻结资金
     */
    public void setFrozenMoney(BigDecimal frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    /**
     * 获取消费积分
     *
     * @return pay_points - 消费积分
     */
    public Integer getPayPoints() {
        return payPoints;
    }

    /**
     * 设置消费积分
     *
     * @param payPoints 消费积分
     */
    public void setPayPoints(Integer payPoints) {
        this.payPoints = payPoints;
    }

    /**
     * 获取会员等级积分
     *
     * @return forzen_money - 会员等级积分
     */
    public Integer getForzenMoney() {
        return forzenMoney;
    }

    /**
     * 设置会员等级积分
     *
     * @param forzenMoney 会员等级积分
     */
    public void setForzenMoney(Integer forzenMoney) {
        this.forzenMoney = forzenMoney;
    }

    /**
     * 获取最后一次登录时间
     *
     * @return last_login - 最后一次登录时间
     */
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     * 设置最后一次登录时间
     *
     * @param lastLogin 最后一次登录时间
     */
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return last_ip
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * @param lastIp
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * 获取登录次数
     *
     * @return visit_count - 登录次数
     */
    public Integer getVisitCount() {
        return visitCount;
    }

    /**
     * 设置登录次数
     *
     * @param visitCount 登录次数
     */
    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    /**
     * 获取是否特殊
     *
     * @return is_special - 是否特殊
     */
    public Integer getIsSpecial() {
        return isSpecial;
    }

    /**
     * 设置是否特殊
     *
     * @param isSpecial 是否特殊
     */
    public void setIsSpecial(Integer isSpecial) {
        this.isSpecial = isSpecial;
    }

    /**
     * 获取是否生效
     *
     * @return is_validated - 是否生效
     */
    public Integer getIsValidated() {
        return isValidated;
    }

    /**
     * 设置是否生效
     *
     * @param isValidated 是否生效
     */
    public void setIsValidated(Integer isValidated) {
        this.isValidated = isValidated;
    }

    /**
     * 获取累计消费
     *
     * @return credit_line - 累计消费
     */
    public BigDecimal getCreditLine() {
        return creditLine;
    }

    /**
     * 设置累计消费
     *
     * @param creditLine 累计消费
     */
    public void setCreditLine(BigDecimal creditLine) {
        this.creditLine = creditLine;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取会员等级
     *
     * @return user_rank - 会员等级
     */
    public Integer getUserRank() {
        return userRank;
    }

    /**
     * 设置会员等级
     *
     * @param userRank 会员等级
     */
    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }
}