package cn.lime.mapper.planprogress;

import cn.lime.entity.planprogress.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper
{
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> findAll();

    @Select("select image from c_order where order_id = #{id}")
    String findImageById(String id);

    @Select("select file from c_order where order_id = #{id}")
    String findFileById(String id);
}