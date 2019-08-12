package cn.lime.service.others;



import cn.lime.entity.plan.Product;
import cn.lime.entity.plan.ProductExample;
import cn.lime.mapper.plan.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> listProducts() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public Product listProductById(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

}
