package com.wzj.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.mapper.UserMapper;
import com.wzj.model.User;
import com.wzj.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl extends BaseService<User> implements IUser{

    @Autowired
    private UserMapper mapper;


}
