package cn.lime.controller.technology;

import cn.lime.entity.technology.Process;
import cn.lime.entity.technology.Technology;
import cn.lime.entity.technology.TechnologyPlan;
import cn.lime.service.technology.ProcessService;
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
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    ProcessService processService;

    @RequestMapping("/find")
    public String findPage(){
        return "process_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map listPage(int page,int rows){
        PageHelper.startPage(page,rows);
        List<Process> processes = processService.selectAllProcess();
        PageInfo<Process> pageInfo = new PageInfo<>(processes);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",processes);
        map.put("total",total);
        return map;
    }

    //edit、add、delete前的判断（未做权限判断，所以直接返回一个空），返回一个json数据，让前端判断
    @RequestMapping(value = {"edit_judge","add_judge","delete_judge"})
    @ResponseBody
    public String editJudge(){
        return "";
    }

    //编辑process
    @RequestMapping("edit")
    public String edit(){
        return "process_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(Process process){
        int i = processService.updateProcess(process);
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

    //新增process
    @RequestMapping("add")
    public String add(){
        return "process_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map add(Process process){
        int i = processService.insertProcess(process);
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

    //删除process
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete(String[] ids){
        int i = processService.deleteProcessBatch(ids);
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
    //按工艺编号查询
    @RequestMapping("/search_process_by_processId")
    @ResponseBody
    public List<Process> selectProcessByProcessIdLike(String searchValue){
        List<Process> processes = processService.selectProcessByProcessIdLike("%" + searchValue + "%");
        return processes;
    }
    //按工艺计划编号查询
    @RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public List<Process> selectProcessByTechnologyPlanIdLike(String searchValue){
        List<Process> processes = processService.selectProcessByTechnologyPlanIdLike("%" + searchValue + "%");
        return processes;
    }
}
