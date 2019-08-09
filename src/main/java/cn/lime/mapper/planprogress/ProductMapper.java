package cn.lime.mapper.planprogress;

import cn.lime.entity.planprogress.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}