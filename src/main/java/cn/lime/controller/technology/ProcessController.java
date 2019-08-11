package cn.lime.controller.technology;

import cn.lime.entity.technology.Process;
import cn.lime.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public List<Process> listPage(){
        List<Process> processes = processService.selectAllProcess();
        return processes;
    }
}
