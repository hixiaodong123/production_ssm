package cn.lime.controller.qualify;

import cn.lime.entity.qualify.FinalCountCheck;
import cn.lime.service.qualify.FinalCountCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/f_count_check")
public class FinalCountCheckController {
    @Autowired
    FinalCountCheckService finalCountCheckService;

    @RequestMapping("/find")
    public String findPage(){
        return "f_count_check_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map listPage(int page, int rows){
        PageHelper.startPage(page,rows);
        List<FinalCountCheck> finalCountChecks =finalCountCheckService.selectALlFinalCountCheckLeft();
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",finalCountChecks);
        map.put("total",total);
        return map;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public FinalCountCheck detail(@PathVariable("id") String id){
        FinalCountCheck finalCountCheck = finalCountCheckService.getFinalCountCheckById(id);
        return finalCountCheck;
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<FinalCountCheck> comboboxDetail(){
        List<FinalCountCheck> finalCountChecks = finalCountCheckService.listFinalCountCheck();
        return finalCountChecks;
    }

    //edit、add、delete前的判断（未做权限判断，所以直接返回一个空），返回一个json数据，让前端判断
    @RequestMapping(value = {"edit_judge","add_judge","delete_judge"})
    @ResponseBody
    public String editJudge(){
        return "";
    }

    //编辑
    @RequestMapping("edit")
    public String edit(){
        return "f_count_check_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(FinalCountCheck finalCountCheck){
        int i = finalCountCheckService.updateFinalCountCheck(finalCountCheck);
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

    //新增
    @RequestMapping("add")
    public String add(){
        return "f_count_check_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map add(FinalCountCheck finalCountCheck){
        int i = finalCountCheckService.insertFinalCountCheck(finalCountCheck);
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
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete(String[] ids){
        int i = finalCountCheckService.deleteFinalCountCheckBatch(ids);
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

//    **************搜索框查找****************
//    按id查询
    @RequestMapping("/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public List<FinalCountCheck> selectFinalCountCheckByFcountCheckIdLike(String searchValue){
        List<FinalCountCheck> finalCountChecks = finalCountCheckService.selectFinalCountCheckByFcountCheckIdLike("%" + searchValue + "%");
        return finalCountChecks;
    }
//    按工艺名称查询
    @RequestMapping("/search_fCountCheck_by_orderId")
    @ResponseBody
    public List<FinalCountCheck> selectFinalCountCheckByOrderIdLike(String searchValue){
        List<FinalCountCheck> finalCountChecks = finalCountCheckService.selectFinalCountCheckByOrderIdLike("%" + searchValue + "%");
        return finalCountChecks;
    }
}
