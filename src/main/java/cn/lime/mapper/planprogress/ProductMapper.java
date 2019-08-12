package cn.lime.mapper.planprogress;

import cn.lime.entity.planprogress.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    @Select("select * from product")
    List<Product> findAll();

    @Select("select image from product where product_id like #{id}")
    String findImage(String id);

    @Select("select * from product where product_name like #{searchValue}")
    List<Product> searchByProductName(String searchValue);

    @Select("select * from product where product_type like #{searchValue}")
    List<Product> searchByProductType(String searchValue);

    @Select("select * from product where product_id like #{searchValue}")
    List<Product> searchByProductId(String searchValue);
}