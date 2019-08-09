package cn.lime.service.planprogress.impl;

import cn.lime.entity.planprogress.Order;
import cn.lime.mapper.planprogress.OrderMapper;
import cn.lime.service.planprogress.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 订单业务层实现类
 * @author: Lime
 * @create: 2019-08-09 13:45
 **/

@Service
public class OrderServiceImpl implements OrderService
{

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper)
    {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> findAll()
    {
        return orderMapper.findAll();
    }
}
