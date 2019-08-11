package cn.lime.controller.technology;

import cn.lime.entity.technology.TechnologyPlan;
import cn.lime.service.technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public List<TechnologyPlan> listPage(){
        List<TechnologyPlan> technologyPlans = technologyPlanService.selectAllTechnologyPlan();
        return technologyPlans;
    }
}
