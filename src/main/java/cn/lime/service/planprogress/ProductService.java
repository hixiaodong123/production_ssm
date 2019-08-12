package cn.lime.service.planprogress;

import cn.lime.entity.planprogress.Product;

import java.util.List;

/**
 * @description: 产品信息业务层接口
 * @author: Lime
 * @create: 2019-08-09 17:19
 **/

public interface ProductService
{
    Product findByProductId(String productId);

    List<Product> findAll();

    void update(Product product);

    void insert(Product product);
}
