package cn.lime.service.planprogress;

import cn.lime.entity.planprogress.Order;

import java.util.List;

/**
 * @description: 订单业务层接口
 * @author: Lime
 * @create: 2019-08-09 13:44
 **/

public interface OrderService
{
    List<Order> findAll();
}
