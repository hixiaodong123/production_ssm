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

import java.util.List;

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
    public String orderListPage()
    {
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
}
