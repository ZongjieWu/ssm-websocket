package com.wzj.controller;

import com.github.pagehelper.PageInfo;
import com.wzj.model.CommodityType;
import com.wzj.service.ICommodityType;
import com.wzj.vo.Casdate;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 商家内分类
@Controller
public class CommodityTypeAction {
    @Autowired
    private ICommodityType commodityTypeService;

    /**
     * 增加分类
     * @param commodityType
     * @return
     */
    @RequestMapping("AddCommodityTypeAction")
    @ResponseBody
    public Map addCommodityType(CommodityType commodityType){
        boolean flag = commodityTypeService.saveSelective(commodityType) > 0 ? true : false;
        Map<String, Object> map = new HashMap<>();
        map.put("data", flag);
        return map;
    }

    /**
     * 修改分类
     * @param commodityType
     * @return
     */
    @RequestMapping("UpdateCommodityTypeAction")
    @ResponseBody
    public Map updateCommodityType(CommodityType commodityType){
        boolean flag = commodityTypeService.updateSelective(commodityType) > 0 ? true : false;
        Map<String, Object> map = new HashMap<>();
        map.put("data", flag);
        return map;
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @RequestMapping("DeleteCommodityTypeAction")
    @ResponseBody
    public Map deleteCommodityType(Long id){
        boolean flag = commodityTypeService.deleteById(id) > 0 ? true : false;
        Map<String, Object> map = new HashMap<>();
        map.put("data", flag);
        return map;
    }

    /**
     * 前端查询店铺内商品分类  id 店铺id   全部给前端  前端进行分类
     * @return
     */
    @RequestMapping("FindAllCommodityTypeAction")
    @ResponseBody
    public Map findAll(Long id){
        CommodityType commodityType = new CommodityType();
        commodityType.setKindergartenId(id);
        commodityType.setStatus(1);
        List<CommodityType> list = commodityTypeService.queryListByWhere(commodityType);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", list);
        return map;
    }


    /**
     * 前端查询店铺内商品分类  id 店铺id   全部给前端  前端进行分类
     * @return
     */
    @RequestMapping("FindByTypeId")
    @ResponseBody
    public Map FindByTypeId(Long id){
        CommodityType commodityType = new CommodityType();
        commodityType.setTypeId(id);
        commodityType.setStatus(1);
        List<CommodityType> list = commodityTypeService.queryListByWhere(commodityType);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", list);
        return map;
    }

    /**
     * 后端接口
     * @param page
     * @param limit
     * @param id 店铺id
     * @return
     */
    @RequestMapping("FindAllCommodityTypeJavaAction")
    @ResponseBody
    public Map findAllJava(Integer page, Integer limit, Long id, Long typeId){
        CommodityType commodityType = new CommodityType();
        commodityType.setKindergartenId(id);
        commodityType.setTypeId(typeId);
        System.out.println(typeId);
        PageInfo<CommodityType> pageInfo = commodityTypeService.queryPageListByWhere(page, limit, commodityType);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("jumpCommodityType")
    public String jumpCommodityType(){
        return "WEB-INF/view/business/commodity/commodityType";
    }

    // 跳转
    @RequestMapping("jumpCommodType1")
    public String jumpCommodType1(Integer id, HttpServletRequest request){
        request.setAttribute("typeId", id);
        return "WEB-INF/view/business/commodity/commodityType1";
    }

    // 跳转
    @RequestMapping("jumpCasdate")
    public String jumpCasdate(Long id, HttpServletRequest request){
        System.out.println("id==========="+id);
        System.out.println("jumpCasdatejumpCasdatejumpCasdatejumpCasdatejumpCasdate");
        CommodityType type = new CommodityType();
        type.setKindergartenId(id);
        List<CommodityType> list = (List<CommodityType>)commodityTypeService.queryListByWhere(type);
        System.out.println("list大下======"+list.size());
        List<Casdate> casdateList=new ArrayList<Casdate>();
        Casdate casdate=null;
        for (CommodityType commodityType:list){
            casdate=new Casdate();
            casdate.setId(commodityType.getId());
            casdate.setPid(commodityType.getTypeId());
            casdate.setTitle(commodityType.getTypeName());
            casdateList.add(casdate);
        }
        System.out.println("size==="+casdateList.size());
        request.setAttribute("list", new JSONArray(list).toString());
        return "WEB-INF/views/test/casdate";
    }
}
