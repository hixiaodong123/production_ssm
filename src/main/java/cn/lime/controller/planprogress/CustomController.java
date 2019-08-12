package cn.lime.controller.planprogress;

import cn.lime.entity.planprogress.Custom;
import cn.lime.service.planprogress.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 客户信息控制器
 * @author: Lime
 * @create: 2019-08-09 15:31
 **/

@Controller
@RequestMapping("/custom")
public class CustomController
{
    private final CustomService customService;


    @Autowired
    public CustomController(CustomService customService)
    {
        this.customService = customService;
    }

    /**
     * @return cn.lime.entity.planprogress.Custom
     * @Author Lime
     * @Description 通过ID查询这个客户, 封装后以json格式返回前端
     * @Date 15:39 2019/8/9
     * @Param [customId]
     **/
    @RequestMapping(value = "/get/{customId}", method = RequestMethod.GET)
    @ResponseBody
    public Custom getCustom(@PathVariable("customId") String customId)
    {
        return customService.findByCustomId(customId);
    }


    /**
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @Author Lime
     * @Description 更新客户信息的表单验证操作
     * @Date 15:51 2019/8/9
     * @Param []
     **/
    @RequestMapping(value = "/edit_judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> editJudge(Custom custom)
    {
        Map<String, Object> map = new HashMap<>();

        //验证客户名
        String customName = custom.getCustomName();
        String regEx = "^[\\u4E00-\\u9FA5A-Za-z0-9]{2,10}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(customName);
        boolean flag = matcher.find();
        if (!flag)
        {
            map.put("msg", "客户名应写简写,不能包括特殊字符!");
            return map;
        }

        //验证电话和传真
        String regEx1 = "^[0-9]+$";
        Pattern compile = Pattern.compile(regEx1);
        String ownerTel = custom.getOwnerTel();
        Matcher matcher1 = compile.matcher(ownerTel);
        boolean b = matcher1.find();
        if (!b)
        {
            map.put("msg", "手机号格式错误!");
            return map;
        }
        String regEx2 = "^[0-9]+$";
        String fax = custom.getFax();
        Pattern compile1 = Pattern.compile(regEx2);
        Matcher matcher2 = compile1.matcher(fax);
        boolean b1 = matcher2.find();
        if (!b1)
        {
            map.put("msg", "传真格式错误!");
            return map;
        }

        //邮箱验证
        String regEx3 = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String email = custom.getEmail();
        Pattern compile2 = Pattern.compile(regEx3);
        Matcher matcher3 = compile2.matcher(email);
        boolean b3 = matcher3.find();
        if (!b3)
        {
            map.put("msg", "邮箱格式错误!");
            return map;
        }
        //全部格式合格放行
        return null;
    }

    /**
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @Author Lime
     * @Description 更新客户信息的方法
     * @Date 16:50 2019/8/9
     * @Param [custom]
     **/
    @RequestMapping(value = "update_all", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateAll(Custom custom)
    {

        Map<String, Object> map = new HashMap<>();
        try
        {
            customService.update(custom);
            map.put("status", "200");
            return map;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //发生异常说明更新失败
            return null;
        }
    }


    //用于展示在order订单增加页面中的custom信息
    @RequestMapping(value = "/get_data", method = RequestMethod.POST)
    @ResponseBody
    public List<Custom> getData()
    {
        //List<Product> list = new ArrayList<>();
        return customService.findAll();
    }


}
