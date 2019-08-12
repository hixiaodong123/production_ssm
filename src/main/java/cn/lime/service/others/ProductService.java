package cn.lime.service.others;

import cn.lime.entity.plan.Product;

import java.util.List;

public interface ProductService {

      //获取表product中的所有数据
      List<Product> listProducts();

    Product listProductById(String productId);
}
