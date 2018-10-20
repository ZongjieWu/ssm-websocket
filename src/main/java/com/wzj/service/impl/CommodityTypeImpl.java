package com.wzj.service.impl;

import com.wzj.mapper.CommodityTypeMapper;
import com.wzj.model.CommodityType;
import com.wzj.service.ICommodityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityTypeImpl extends BaseService<CommodityType> implements ICommodityType {

    @Autowired
    private CommodityTypeMapper mapper;


}
