package cn.lime.controller.technology;


import cn.lime.entity.technology.Technology;
import cn.lime.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/technology")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    @RequestMapping("/find")
    public String findPage(){
        return "technology_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Technology> listPage(){
        List<Technology> technologies = technologyService.selectAllTechnology();
        return technologies;
    }
}
