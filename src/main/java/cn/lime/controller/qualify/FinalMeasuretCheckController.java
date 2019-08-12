package cn.lime.controller.qualify;

import cn.lime.entity.qualify.FinalMeasuretCheck;
import cn.lime.service.qualify.FinalMeasuretCheckService;
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
@RequestMapping("measure")
public class FinalMeasuretCheckController {
    @Autowired
    FinalMeasuretCheckService finalMeasuretCheckService;

    @RequestMapping("/find")
    public String findPage(){
        return "measurement_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map listPage(int page, int rows){
        PageHelper.startPage(page,rows);
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckService.selectAllFinalMeasuretChecksLeft();
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasuretChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",finalMeasuretChecks);
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
        return "measurement_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(FinalMeasuretCheck finalMeasuretCheck){
        int i = finalMeasuretCheckService.updateFinalMeasuretCheck(finalMeasuretCheck);
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
        return "measurement_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map add( FinalMeasuretCheck finalMeasuretCheck){
        int i = finalMeasuretCheckService.insertFinalMeasuretCheck(finalMeasuretCheck);
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
        int i = finalMeasuretCheckService.deleteFinalMeasuretCheckBatch(ids);
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
    @RequestMapping("/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public List<FinalMeasuretCheck> selectFinalMeasureCheckByFmeasureCheckIdLike(String searchValue){
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckService.selectFinalMeasureCheckByFmeasureCheckIdLike("%" + searchValue + "%");
        return finalMeasuretChecks;
    }
    //按工艺名称查询
    @RequestMapping("/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public List<FinalMeasuretCheck> selectFinalMeasureCheckByOrderIdLike(String searchValue){
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckService.selectFinalMeasureCheckByOrderIdLike("%" + searchValue + "%");
        return finalMeasuretChecks;
    }
}
