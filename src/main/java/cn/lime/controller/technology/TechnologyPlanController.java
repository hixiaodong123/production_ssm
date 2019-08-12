package cn.lime.controller.technology;

import cn.lime.entity.technology.Technology;
import cn.lime.entity.technology.TechnologyPlan;
import cn.lime.entity.technology.TechnologyRequirement;
import cn.lime.service.technology.TechnologyPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("/find")
    public String findPage(){
        return "technologyPlan_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map listPage(int page,int rows){
        PageHelper.startPage(page,rows);
        List<TechnologyPlan> technologyPlans = technologyPlanService.selectAllTechnologyPlanLeft();
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlans);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",technologyPlans);
        map.put("total",total);
        return map;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public TechnologyPlan detail(@PathVariable("id") String id){
        TechnologyPlan technologyPlan = technologyPlanService.selectTechnologyPlanById(id);
        return technologyPlan;
    }

    //获取下拉框中的technology_name信息
    @RequestMapping("get_data")
    @ResponseBody
    public List<TechnologyPlan> comboboxDetail(){
        List<TechnologyPlan> technologyPlans = technologyPlanService.selectAllTechnologyPlan();
        return technologyPlans;
    }

    //edit、add、delete前的判断（未做权限判断，所以直接返回一个空），返回一个json数据，让前端判断
    @RequestMapping(value = {"edit_judge","add_judge","delete_judge"})
    @ResponseBody
    public String editJudge(){
        return "";
    }

    //编辑technologyPlan
    @RequestMapping("edit")
    public String edit(){
        return "technologyPlan_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(TechnologyPlan technologyPlan){
        int i = technologyPlanService.updateTechnologyPlan(technologyPlan);
        HashMap<String, String> hashMap = null;
        if(i == 1){
            hashMap = new HashMap<>();
            hashMap.put("status","200");
            hashMap.put("msg","OK");
            hashMap.put("data",null);
        }else{
            hashMap = new HashMap<>();
            hashMap.put("status","302");
        }
        return hashMap;
    }

    //新增technology
    @RequestMapping("add")
    public String add(){
        return "technologyPlan_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map add( TechnologyPlan technologyPlan){
        int i = technologyPlanService.insertTechnologyPlan(technologyPlan);
        HashMap<String, String> hashMap = null;
        if(i == 1){
            hashMap = new HashMap<>();
            hashMap.put("status","200");
            hashMap.put("msg","OK");
            hashMap.put("data",null);
        }else{
            hashMap = new HashMap<>();
            hashMap.put("status","302");
        }
        return hashMap;
    }

    //批量删除technologyPlan
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete(String[] ids){
        int i = technologyPlanService.deleteTechnologyPlanBatch(ids);
        HashMap<String, String> hashMap = null;
        if(i != 0){
            hashMap = new HashMap<>();
            hashMap.put("status","200");
            hashMap.put("msg","OK");
            hashMap.put("data",null);
        }else{
            hashMap = new HashMap<>();
            hashMap.put("status","302");
        }
        return hashMap;
    }

    //**************搜索框查找****************
    //按id查询
    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public List<TechnologyPlan> selectTechnologyPlanByTechnologyPlanIdLike(String searchValue){
        List<TechnologyPlan> technologyPlans = technologyPlanService.selectTechnologyPlanByTechnologyPlanIdLike("%" + searchValue + "%");
        return technologyPlans;
    }
    //按工艺名称查询
    @RequestMapping("/search_technologyPlan_by_technologyName")
    @ResponseBody
    public List<TechnologyPlan> selectTechnologyPlanByTechnologyNameLike(String searchValue){
        List<TechnologyPlan> technologyPlans = technologyPlanService.selectTechnologyPlanByTechnologyNameLike("%" + searchValue + "%");
        return technologyPlans;
    }
}
