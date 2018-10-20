package com.wzj.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.github.pagehelper.PageInfo;
import com.wzj.model.User;
import com.wzj.service.IUser;
import com.wzj.utils.GetIp;
import com.wzj.utils.RandomUtils;
import com.wzj.utils.SmsDemo;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录
 */
@Controller
public class UserAction {


    @Autowired
    private IUser service;

    @RequestMapping("")
    public String index(){
        return "WEB-INF/views/index";
    }
    /**
     * 用户登录
     * @param user
     * @param code
     * @return
     */
    @RequestMapping("UserAdd")
    @ResponseBody
    public void addUser (User user, String code) {
        /*Map<String, Object> map = new HashMap<>();
        //通过code获取openid
        String openid = getOpenid(code);
        logger.info("openid==="+openid);
        //查询数据库有没有
        User user1 = service.getOpenid(openid);
        boolean flag = false;
        if (user1 == null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(new Date());
            user.setAddtime(time);
            user.setIntegrals("0");
            user.setMoney("0");
            user.setKindergarten(-2);
            user.setOpenid(openid);
            flag = service.addUser(user);
        }
        //如果flag==true 就把数据库信息返回
        if (flag) {
            user1 = service.getOpenid(openid);
        }
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", user1);
        return map;*/
    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @RequestMapping("UserLogin")
    @ResponseBody
    public Map userLogin(User user, String phone){
        user.setMobilePhone(phone);
        User u = service.queryOne(user);
        Map<String, Object> map = new HashMap<>();
        int i = u == null ? 0 : 1;
        if (u != null) {
            u.setVisitCount(u.getVisitCount()+1);
            u.setLastLogin(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            service.updateSelective(u);
            u.setPwd("");
            map.put("result", 1);
            map.put("msg", "成功");
            map.put("userinfo", u);
        }
        if (u == null) {
            user.setPwd(null);
            if (service.queryOne(user) == null){
                map.put("result", 0);
                map.put("msg", "账号不存在");
            }else {
                map.put("result", 0);
                map.put("msg", "密码错误");
            }
        }
        return map;
    }

    /**
     * 免密登录
     * @param phone
     * @param phone
     * @return
     */
    @RequestMapping("UserNoPwdLogin")
    @ResponseBody
    public Map userNoPwdLogin(String phone, HttpServletRequest request){
        User user = new User();
        user.setMobilePhone(phone);
        User u = service.queryOne(user);
        Map<String, Object> map = new HashMap<>();
        if (u == null){
            user.setAddtime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            user.setLastLogin(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            user.setVisitCount(1);
            user.setLastIp(GetIp.getIP(request));
            service.saveSelective(user);
            u = service.queryOne(user);
        }else {
            u.setLastLogin(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            u.setVisitCount(u.getVisitCount()+1);
            service.updateSelective(u);
        }
        int i = u == null ? 0 : 1;
        u.setPwd("");
        map.put("result", i);
        map.put("userinfo", u);
        return map;
    }




    /**
     * 发送验证码
     * @param phone 发送验证码
     * @return
     */
    @RequestMapping("UserCode")
    @ResponseBody
    public Map userCode(String phone){
        Map<String, Object> map = new HashMap<>();
        String code = RandomUtils.code();
        int result = 0;
        try {
            SendSmsResponse response = SmsDemo.sendSms(phone, code);
            result = "OK".equals(response.getCode()) ? 1 : 0;
        }catch (Exception e){
            result = -1;
        }
        map.put("result", result);
        if (result == 1){
            map.put("verify",code);
        }else {
            map.put("verify","");
        }
        return map;
    }

    /**
     * 根据主键查出用户信息
     * @param id
     * @return
     */
    @RequestMapping("UserGetId")
    @ResponseBody
    public Map getId (Long id) {
        Map<String, Object> map = new HashMap<>();
        User user = service.queryById(id);

        map.put("result", 1);
        //map.put("msg", "成功");
        map.put("data", user);
        return map;
    }

    /**
     * 修改用户信息
     * @param user  type 0 修改基础信息等 已id作为判断  1修改密码忘记密码等  已手机号作为判断
     * @return
     */
    @RequestMapping("UserUpdate")
    @ResponseBody
    public Map updateUser (User user, int type) {
        System.out.println(type);
        System.out.println(user.getMobilePhone()+"=="+user.getPwd());
        Map<String, Object> map = new HashMap<>();
        boolean flag = false;
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("mobilePhone", user.getMobilePhone());
        if (type == 0)
            flag = service.updateSelective(user) > 0 ? true : false;
        else
            flag = service.updateByWhere(user, example) > 0 ? true : false;
        map.put("result", flag ? 1 : 0);
        return map;
    }

    /**
     * 根据用户id查出对应的已经认证了商家的用户
     * @param id 用户id
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("UserFindByUid")
    @ResponseBody
    public Map findByUid (Integer id, Integer page, Integer limit) {
        return null;
    }

    /**
     * 后台推荐页面
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("UserFindBy")
    @ResponseBody
    public Map findBy (Integer page, Integer limit) {
        return null;
    }

    /**
     * 查詢所有用戶
     * @param name 名字模糊查詢
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("UserFindByName")
    @ResponseBody
    public Map findByName (String name, Integer page, Integer limit) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (name != null) criteria.andCondition(" name like '%"+name+"%' or mobile_phone like '%"+name+"%'");
        PageInfo<User> pageInfo = service.queryPageListByWhereExample(page, limit, example);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    /**
     * 根据用户id跳转到商家详情
     * @param id 用户id
     * @param request
     * @return
     */
    @RequestMapping("UserByKindJump")
    public String getKin (Long id, HttpServletRequest request) {

        return "WEB-INF/view/kindergarten/detailUser";
    }

    @RequestMapping("jumpUser")
    public String jumpUser(){
        return "WEB-INF/view/user/user";
    }


    /**
     * 获取openid方法
     * @return
     */
    private String getOpenid (String code) {
        System.out.println(code);
        String openid = "";
        String appid = "wx484fb50fef45d217";
        String appsecret = "c15461d260c3359e38987a828b4bd38a";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appsecret+"&js_code="+code+"&grant_type=authorization_code";
        /*HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseContent = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseContent+"响应报文");
            Map<String,String> res = new HashMap<>();
            Gson gson = new Gson();
            res = gson.fromJson(responseContent, res.getClass());
            openid =  res.get("openid");
            System.out.println(openid+"获取到了openid");
        }catch (Exception e) {
            System.out.println("请求错误");
        }*/
        return openid;
    }

    //后面是跳转

    @RequestMapping("jump5")
    public String jump5(){
        return "WEB-INF/view/kindergarten/user";
    }

    @RequestMapping("jump21")
    public String jump(){
        return "WEB-INF/view/kindergarten/recommend";
    }

    @RequestMapping("jumpMemberRank")
    public String jumpMemberRank(){
        return "WEB-INF/view/statistics/memberRank";
    }
}
