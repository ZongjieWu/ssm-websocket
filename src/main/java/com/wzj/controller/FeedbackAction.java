package com.wzj.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.model.Feedback;
import com.wzj.service.IFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 意见反馈
 */
@Controller
public class FeedbackAction {


    @Autowired
    private IFeedback service;

    /**
     * 前端添加意见反馈
     * @param feedback
     * @return
     */
    @RequestMapping("FeedbackAdd")
    @ResponseBody
    public Map addFeedback (Feedback feedback) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        feedback.setTime(df.format(new Date()));
        boolean flag = service.saveSelective(feedback) > 0 ? true : false;
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "成功");
        map.put("data", flag);
        return map;
    }

    /**
     * 后台查看数据
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("FeedbackFindAll")
    @ResponseBody
    public Map addFeedback (Integer page, Integer limit) {
        PageHelper.orderBy(" id desc ");
        PageInfo<Feedback> pageInfo = service.queryPageListByWhere(page, limit, new Feedback());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        System.out.println("大小为+++++++++++++++++++"+pageInfo.getList().size());
        return map;
    }

    // 跳转
    @RequestMapping("showFeedback")
    public String showFeedback () {
        return "WEB-INF/views/admin/feedback/feedback";
    }
}
