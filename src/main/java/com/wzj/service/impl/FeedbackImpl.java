package com.wzj.service.impl;


import com.wzj.mapper.FeedbackMapper;
import com.wzj.model.Feedback;
import com.wzj.service.IFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackImpl extends BaseService<Feedback> implements IFeedback {

    @Autowired
    private FeedbackMapper mapper;


}
