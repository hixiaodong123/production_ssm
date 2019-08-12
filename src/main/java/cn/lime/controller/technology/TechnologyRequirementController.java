package cn.lime.controller.technology;

import cn.lime.entity.technology.Technology;
import cn.lime.entity.technology.TechnologyPlan;
import cn.lime.entity.technology.TechnologyRequirement;
import cn.lime.service.technology.TechnologyRequirementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map listPage(int page,int rows){
        PageHelper.startPage(page,rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectAllTechnologyRequirementLeft();
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",technologyRequirements);
        map.put("total",total);
        return map;
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
        return "technologyRequirement_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(TechnologyRequirement technologyRequirement){
        int i = technologyRequirementService.updateTechnologyRequirement(technologyRequirement);
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
        return "technologyRequirement_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map add( TechnologyRequirement technologyRequirement){
        int i = technologyRequirementService.insertTechnologyRequirement(technologyRequirement);
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
        int i = technologyRequirementService.deleteTechnologyRequirementBatch(ids);
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
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public List<TechnologyRequirement> selectTechnologyRequirementByIdLike(String searchValue){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectTechnologyRequirementByTechnologyRequirementIdLike("%" + searchValue + "%");
        return technologyRequirements;
    }
    //按工艺名称查询
    @RequestMapping("/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public List<TechnologyRequirement> selectTechnologyRequirementByNameLike(String searchValue){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectTechnologyRequirementByTechnologyNameLike("%" + searchValue + "%");
        return technologyRequirements;
    }
}
