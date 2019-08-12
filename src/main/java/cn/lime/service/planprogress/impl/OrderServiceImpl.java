package cn.lime.service.planprogress.impl;

import cn.lime.entity.planprogress.Order;
import cn.lime.mapper.planprogress.OrderMapper;
import cn.lime.service.planprogress.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @Override
    public void update(Order note)
    {
        orderMapper.updateByPrimaryKeySelective(note);
    }

    @Override
    public void insert(Order order)
    {
        orderMapper.insert(order);
    }

    @Override
    public void deleteByArray(String[] ids, HttpServletRequest request)
    {
        for (String id : ids)
        {
            //遍历删除本地图片
            String str = orderMapper.findImageById(id);
            String[] images = str.split(",");
            String path = request.getSession().getServletContext().getRealPath("/upload/images/product/");
            for (String image : images)
            {
                String newFileName = image.replaceAll("/production/upload/images/product/", "");
                File targetFile = new File(path, newFileName);
                if (targetFile.exists())
                {
                    targetFile.delete();
                }
            }
            //遍历删除本地图片
            String file = orderMapper.findFileById(id);
            String[] files = file.split(",");
            String path1 = request.getSession().getServletContext().getRealPath("/upload/file/");
            for (String image : files)
            {
                String newFileName = image.replaceAll("/production/upload/file/", "");
                File targetFile = new File(path1, newFileName);
                if (targetFile.exists())
                {
                    targetFile.delete();
                }
            }
            //删除数据库
            orderMapper.deleteByPrimaryKey(id);


        }

    }
}
