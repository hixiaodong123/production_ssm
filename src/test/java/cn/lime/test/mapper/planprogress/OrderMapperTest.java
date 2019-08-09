package cn.lime.test.mapper.planprogress;

import cn.lime.entity.planprogress.Order;
import cn.lime.mapper.planprogress.OrderMapper;
import cn.lime.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 测试订单类
 * @author: Lime
 * @create: 2019-08-09 14:11
 **/

public class OrderMapperTest extends BaseTest
{
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testFindAll()
    {

        List<Order> all = orderMapper.findAll();
        for (Order order : all)
        {
            System.out.println(order);
        }

    }


    @Test
    public void testDemo1()
    {
        String regEx = "^[\\u4E00-\\u9FA5A-Za-z0-9]{2,10}$";
        String str = "1";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.find();
        System.out.println(b);
    }
}
