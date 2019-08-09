package cn.lime.controller.technology;

import cn.lime.entity.technology.TechnologyRequirement;
import cn.lime.service.technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @RequestMapping("/find")
    public String findPage(){
        return "technologyRequirement_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<TechnologyRequirement> listPage(){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectAllTechnologyRequirement();
        return technologyRequirements;
    }
}
