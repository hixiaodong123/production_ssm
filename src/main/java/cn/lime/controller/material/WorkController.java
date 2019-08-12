package cn.lime.controller.material;


import cn.lime.entity.material.OperateResponse;
import cn.lime.entity.plan.WorkInfo;
import cn.lime.entity.plan.Work;
import cn.lime.service.others.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("work")
public class WorkController {

    @Autowired
    WorkService workService;

    @RequestMapping("get_data")
    @ResponseBody
    public Work[] getData() {
        List<Work> workList = workService.listWorks();
        Work[] works =workList.toArray(new Work[0]);
        return works;
    }

    //需要增加权限65001
    @RequestMapping({"add_judge","edit_judge","delete_judge"})
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("get/{workId}")
    @ResponseBody
    public WorkInfo getWorInfoById(@PathVariable("workId") String workId) {
        return workService.listWorkInfoById(workId);
    }


    //更新物料信息
    @RequestMapping("update_all")
    @ResponseBody
    public OperateResponse UpdateAll(Work work) {
        boolean b = workService.updateWork(work);
        OperateResponse workResponse = new OperateResponse();
        if (b) {
            workResponse.setStatus(200);
            workResponse.setMsg("OK");
            workResponse.setData(null);
        } else {
            workResponse.setMsg("修改失败，请稍后重试");
        }
        return workResponse;
    }
}
