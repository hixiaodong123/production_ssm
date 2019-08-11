package cn.lime.controller.technology;


import cn.lime.entity.technology.Technology;
import cn.lime.service.technology.TechnologyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technology")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    @RequestMapping("/find")
    public String findPage(){
        return "technology_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map listPage(int page,int rows){
        PageHelper.startPage(page,rows);
        List<Technology> technologies = technologyService.listTechnology();
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",technologies);
        map.put("total",total);
        return map;
    }

    //通过超链接进入查看technology的详情 另 获取下拉框中的technology_name信息
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Technology detail(@PathVariable("id") String id){
        Technology technology = technologyService.getTechnologyById(id);
        return technology;
    }

    //获取下拉框中的technology_name信息
    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> comboboxDetail(){
        List<Technology> technologies = technologyService.listTechnology();
        return technologies;
    }

    //edit、add、delete前的判断（未做权限判断，所以直接返回一个空），返回一个json数据，让前端判断
    @RequestMapping(value = {"edit_judge","add_judge","delete_judge"})
    @ResponseBody
    public String editJudge(){
        return "";
    }

    //编辑technology
    @RequestMapping("edit")
    public String edit(){
        return "technology_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(Technology technology){
        int i = technologyService.updateTechnology(technology);
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
        return "technology_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map add(Technology technology){
        int i = technologyService.insertTechnology(technology);
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

    //删除technology
//    @RequestMapping("delete_batch")
//    public String delete(){
//        return "technology_add";
//    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete(String[] ids){
        int i = technologyService.deleteTechnologyBatch(ids);
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
    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public List<Technology> selectTechnologyByIdLike(String searchValue){
        List<Technology> technologies = technologyService.selectTechnologyByIdLike(searchValue);
        return technologies;
    }
    //按工艺名称查询
    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public List<Technology> selectTechnologyByNameLike(String searchValue){
        List<Technology> technologies = technologyService.selectTechnologyByNameLike(searchValue);
        return technologies;
    }
}
