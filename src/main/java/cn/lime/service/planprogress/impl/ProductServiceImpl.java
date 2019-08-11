package cn.lime.service.planprogress.impl;

import cn.lime.entity.planprogress.Product;
import cn.lime.mapper.planprogress.ProductMapper;
import cn.lime.service.planprogress.ProductService;
import org.springframework.beans.PropertyMatches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 产品信息业务层实现类
 * @author: Lime
 * @create: 2019-08-09 17:19
 **/

@Service
public class ProductServiceImpl implements ProductService
{
    //出入持久层依赖
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper)
    {
        this.productMapper = productMapper;
    }

    @Override
    public Product findByProductId(String productId)
    {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> findAll()
    {
        return productMapper.findAll();
    }

    @Override
    public void update(Product product)
    {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public void insert(Product product)
    {
        productMapper.insert(product);
    }
}
