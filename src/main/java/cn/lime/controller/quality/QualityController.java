package cn.lime.controller.quality;

import cn.lime.entity.quality.ProcessCountCheck;
import cn.lime.entity.quality.ProcessMeasureCheck;
import cn.lime.service.QualityService;
import cn.lime.utils.ControllerMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class QualityController {

    @Autowired
    QualityService qualityService;
    //质量监控里面的 工序质量质检 表单的获取
    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public Map<String, Object> ReturnPMeasureCheckList(int page, int rows){
        return qualityService.selectAllProcessMeasureCheck(page,rows);
    }

    @RequestMapping("p_measure_check/find")
    public String goToPMeasureCheckList(HttpServletRequest request)
    {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("pMeasureCheck:add");
        strings.add("pMeasureCheck:edit");
        strings.add("pMeasureCheck:delete");
        request.getSession().setAttribute("sysPermissionList",strings);
        return "p_measure_check_list";
    }

    //质量监控里面的 工序质量质检 增加按钮
    @RequestMapping("pMeasureCheck/add_judge")
    @ResponseBody
    public void returnPMeasureCheckAddJudge(){
    }

    @RequestMapping("p_measure_check/add")
    public String goToPMeasureCheckAdd(){
        return "p_measure_check_add";
    }

    @PostMapping("p_measure_check/insert")
    @ResponseBody
    public Map<String, Object> insertPMeasureCheck(ProcessMeasureCheck processMeasureCheck){
        int i = qualityService.insertSelective(processMeasureCheck);
        return ControllerMapUtil.MapString(i==1);
    }

    //质量监控里面的 工序质量质检 编辑按钮
    @RequestMapping("pMeasureCheck/edit_judge")
    @ResponseBody
    public void returnPMeasureCheckEdit(){
    }

    @RequestMapping("p_measure_check/edit")
    public String GoToPMeasureCheckEdit(){
        return "p_measure_check_edit";
    }

    @RequestMapping("p_measure_check/update_all")
    @ResponseBody
    public Map<String, Object> UpdatePMeasureCheckByIdInPMeasureCheckEdit(ProcessMeasureCheck processMeasureCheck){
        int i = qualityService.updateByPrimaryKeySelective(processMeasureCheck);
        return ControllerMapUtil.MapString(i==1);
    }

    //质量监控里面的 工序质量质检 删除按钮
    @RequestMapping("pMeasureCheck/delete_judge")
    @ResponseBody
    public void returnPMeasureCheckDelete(){
    }

    @RequestMapping("p_measure_check/delete_batch")
    @ResponseBody
    public Map<String,Object> delectPMeasureCheckById(String ids){
        int i = qualityService.deleteByPrimaryKey(ids);
        return ControllerMapUtil.MapString(i==1);
    }

    //质量监控里面的 工序质量质检 根据工序质量编号 来进行模糊查询
    @GetMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public Map<String,Object> likeSelectPMeasureCheckBypMeasureCheckId(String searchValue,int page,int rows) {
        return qualityService.likeSelectPMeasureCheckBypMeasureCheckId(searchValue,page,rows);
    }

    //质量监控里面的 工序计数质检 表单的获取
    @RequestMapping("p_count_check/list")
    @ResponseBody
    public Map<String, Object> ReturnPCountCheckList(int page, int rows){
        return qualityService.selectAllPCountCheck(page,rows);
    }

    @RequestMapping("p_count_check/find")
    public String goToPCountCheckList(HttpServletRequest request)
    {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("pCountCheck:add");
        strings.add("pCountCheck:edit");
        strings.add("pCountCheck:delete");
        request.getSession().setAttribute("sysPermissionList",strings);
        return "p_count_check_list";
    }

    //质量监控里面的 工序计数质检 增加按钮
    @RequestMapping("pCountCheck/add_judge")
    @ResponseBody
    public void returnPCountCheckAddJudge(){
    }

    @RequestMapping("p_count_check/add")
    public String goToPCountCheckAdd(){
        return "p_count_check_add";
    }

    @PostMapping("p_count_check/insert")
    @ResponseBody
    public Map<String, Object> insertPCountCheck(ProcessCountCheck processCountCheck){
        int i = qualityService.insert(processCountCheck);
        return ControllerMapUtil.MapString(i==1);
    }

    //质量监控里面的 工序计数质检 增加按钮
    @RequestMapping("pCountCheck/edit_judge")
    @ResponseBody
    public void returnPCountCheckEdit(){
    }

    @RequestMapping("p_count_check/edit")
    public String GoToPCountCheckEdit(){
        return "p_count_check_edit";
    }

    @RequestMapping("p_count_check/update_all")
    @ResponseBody
    public Map<String, Object> UpdatePCountCheckByIdInPCountCheckEdit(ProcessCountCheck processCountCheck){
        int i = qualityService.updateByPrimaryKeySelective(processCountCheck);
        return ControllerMapUtil.MapString(i==1);
    }

    //质量监控里面的 工序计数质检 删除按钮
    @RequestMapping("pCountCheck/delete_judge")
    @ResponseBody
    public void returnPCountCheckDelete(){
    }

    @RequestMapping("p_count_check/delete_batch")
    @ResponseBody
    public Map<String,Object> delectPCountCheckById(String ids){
        int i = qualityService.deleteCountByPrimaryKey(ids);
        return ControllerMapUtil.MapString(i==1);
    }

    //质量监控里面的 工序计量质检 根据工程计数质检编号编号 来进行模糊查询
    @GetMapping("p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public Map<String,Object> likeSelectPCountCheckBypCountCheckId(String searchValue,int page,int rows) {
        return qualityService.likeSelectPCountCheckBypCountCheckId(searchValue,page,rows);
    }


}
