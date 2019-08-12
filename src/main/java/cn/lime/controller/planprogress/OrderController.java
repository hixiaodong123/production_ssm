package cn.lime.controller.planprogress;

import cn.lime.entity.planprogress.Order;
import cn.lime.entity.planprogress.QueryList;
import cn.lime.service.planprogress.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 订单控制器
 * @author: Lime
 * @create: 2019-08-09 09:26
 **/

@Controller
@RequestMapping("/order")
public class OrderController
{

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    //返回管理的页面
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String orderListPage(HttpServletRequest request)
    {
        //添加一个用于权限管理的集合
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
        return "order_list";
    }

    //显示页面的数据
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public QueryList<Order> orderListData(String page, String rows)
    {
        QueryList<Order> queryList = new QueryList<>();
        //查询所有的订单,封装成List
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Order> list = orderService.findAll();
        queryList.setRows(list);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        queryList.setTotal(total);
        return queryList;
    }

    //编辑权限给予
    //edit_judge
    @RequestMapping(value = "/edit_judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> editJudge()
    {
        return null;
    }

    //编辑更新订单说明
    @RequestMapping(value = "/update_note", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateNote(Order order)
    {
        Map<String, Object> map = new HashMap<>();
        try
        {
            orderService.update(order);
            //更新成功
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
            return map;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //更新失败
            map.put("msg", "更新失败!");
            return map;
        }

    }

    //添加权限给予
    //add_judge
    @RequestMapping(value = "/add_judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addJudge()
    {
        return null;
    }

    //跳转add页面
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request)
    {
        return "order_add";
    }


    //添加请求的方法
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(Order order)
    {

        Map<String, Object> map = new HashMap<>();
        try
        {
            orderService.insert(order);
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
            return map;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //增加失败的可能性只有Id冲突
            map.put("status", 0);
            map.put("msg", "编号主键已存在!冲突!");
            map.put("data", null);
            return map;
        }
    }

    //删除权限给与
    //delete_judge
    @RequestMapping(value = "/delete_judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> deleteJudge()
    {
        return null;
    }

    //删除请求实现
    @RequestMapping(value = "/delete_batch", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteBatch(String[] ids, HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<>();
        try
        {
            orderService.deleteByArray(ids, request);
            map.put("status", "200");
            map.put("msg", "OK");
            map.put("data", null);
            return map;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            map.put("data", "删除失败!");
            return map;
        }
    }


}
