package cn.lime.service.planprogress.impl;

import cn.lime.entity.planprogress.Product;
import cn.lime.mapper.planprogress.ProductMapper;
import cn.lime.service.planprogress.ProductService;
import org.springframework.beans.PropertyMatches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @Override
    public void deleteByArray(String[] ids, HttpServletRequest request)
    {
        for (String id : ids)
        {
            //遍历删除本地图片
            String str = productMapper.findImage(id);
            String[] images = str.split(",");
            String path = request.getSession().getServletContext().getRealPath("/upload/images/product/");
            for (String image : images)
            {
                String newFileName = image.replaceAll("/production/upload/images/product", "");
                File targetFile = new File(path, newFileName);
                if (targetFile.exists())
                {
                    targetFile.delete();
                }
            }
            //删除数据库数据
            productMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Product> searchByProductName(String searchValue)
    {

        return productMapper.searchByProductName(searchValue);
    }

    @Override
    public List<Product> searchByProductType(String searchValue)
    {
        return productMapper.searchByProductType(searchValue);
    }

    @Override
    public List<Product> searchByProductId(String searchValue)
    {
        return productMapper.searchByProductId(searchValue);
    }

}
