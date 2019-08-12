package cn.lime.controller.others;

import cn.lime.entity.others.Corder;
import cn.lime.service.others.CorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    CorderService corderService;

    //获取下拉框中的technology_name信息
    @RequestMapping("get_data")
    @ResponseBody
    public List<Corder> comboboxDetail(){
        List<Corder> corders = corderService.selectAllCorder();
        return corders;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Corder detail(@PathVariable("id") String id){
        Corder corder = corderService.selectCorderById(id);
        return corder;
    }
}
