package cn.lime.service.qualify;


import cn.lime.entity.plan.Product;
import cn.lime.entity.plan.ProductExample;
import cn.lime.entity.qualify.Unqualify;
import cn.lime.entity.qualify.UnqualifyExample;
import cn.lime.entity.qualify.UnqualifyJson;
import cn.lime.mapper.plan.ProductMapper;
import cn.lime.mapper.qualify.UnqualifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyMapper unqualifyMapper;

    @Autowired
    ProductMapper productMapper;
    

    @Override
    public boolean insertUnqualify(Unqualify unqualify) {
        Unqualify findUnqualify = unqualifyMapper.selectByPrimaryKey(unqualify.getUnqualifyApplyId());
        if (null == findUnqualify) {
            unqualifyMapper.insert(unqualify);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUnqualifyById(String unqualifyId) {
            return 0 != unqualifyMapper.deleteByPrimaryKey(unqualifyId);
    }

    @Override
    public boolean deleteUnqualifyByIds(String[] unqualifyIds) {
        UnqualifyExample unqualifyExample = new UnqualifyExample();
        unqualifyExample.createCriteria().andUnqualifyApplyIdIn(Arrays.asList(unqualifyIds));
        return 0 != unqualifyMapper.deleteByExample(unqualifyExample);
    }

    @Override
    public boolean updateUnqualify(Unqualify unqualify) {
        return 0 != unqualifyMapper.updateByPrimaryKey(unqualify);
    }

    @Override
    public boolean updateUnqualifyNote(Unqualify unqualify) {
        Unqualify uAI = unqualifyMapper.selectByPrimaryKey(unqualify.getUnqualifyApplyId());
        uAI.setNote(unqualify.getNote());
        return 0 != unqualifyMapper.updateByPrimaryKey(uAI);
    }

    @Override
    public List<UnqualifyJson> listUnqualifys() {
        List<Unqualify> unqualifyList = unqualifyMapper.selectByExample(new UnqualifyExample());
        return selectUnqualifyJson(unqualifyList);
    }

    @Override
    public List<UnqualifyJson> listUnqualifysByLikeId(String unqualifyApplyId) {
        UnqualifyExample unqualifyExample = new UnqualifyExample();
        unqualifyApplyId = "%" + unqualifyApplyId + "%";
        unqualifyExample.createCriteria().andUnqualifyApplyIdLike(unqualifyApplyId);
        List<Unqualify> unqualifyList = unqualifyMapper.selectByExample(unqualifyExample);
        return selectUnqualifyJson(unqualifyList);
    }


    @Override
    public List<UnqualifyJson> listUnqualifysByLikeProductName(String productName) {
        ProductExample productExample = new ProductExample();
        productName = "%" + productName + "%";
        productExample.createCriteria().andProductNameLike(productName);
        List<Product> productList = productMapper.selectByExample(productExample);
        List<Unqualify> unqualifyList = new ArrayList<>();
        for (Product product : productList) {
            UnqualifyExample unqualifyExample = new UnqualifyExample();
            unqualifyExample.createCriteria().andProductIdEqualTo(product.getProductId());
            List<Unqualify> unqualifys = unqualifyMapper.selectByExample(unqualifyExample);
            unqualifyList.addAll(unqualifys);
        }
        return selectUnqualifyJson(unqualifyList);
    }

    private List<UnqualifyJson> selectUnqualifyJson(List<Unqualify> UnqualifyList) {
        List<UnqualifyJson> UnqualifyJsonList = new ArrayList<>();
        for (Unqualify unqualify : UnqualifyList) {
            UnqualifyJson UnqualifyJson = unqualifyMapper.selectUnqualifyJsonById(unqualify.getUnqualifyApplyId());
            UnqualifyJsonList.add(UnqualifyJson);
        }
        return UnqualifyJsonList;

    }
}
