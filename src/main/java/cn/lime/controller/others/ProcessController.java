package cn.lime.controller.others;


import cn.lime.entity.others.Process;
import cn.lime.service.others.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("process")
public class ProcessController {

    @Autowired
    ProcessService processService;
    
    //获取表process中全部的信息
    @RequestMapping("get_data")
    @ResponseBody
    public Process[] getData() {
        List<Process> processList = processService.listProcesss();
        Process[] processs =processList.toArray(new Process[0]);
        return processs;
    }

}
