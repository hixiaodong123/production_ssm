package cn.lime.controller.others;


import cn.lime.entity.plan.Product;
import cn.lime.service.others.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    //获取表product中全部的信息
    @RequestMapping("get_data")
    @ResponseBody
    public Product[] getData() {
        List<Product> productList = productService.listProducts();
        Product[] products =productList.toArray(new Product[0]);
        return products;
    }

    @RequestMapping("get/{productId}")
    @ResponseBody
    public Product getProduct(@PathVariable("productId") String productId) {
        return productService.listProductById(productId);
    }

}
