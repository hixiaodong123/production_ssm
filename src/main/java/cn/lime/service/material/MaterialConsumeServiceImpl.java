package cn.lime.service.material;


import cn.lime.entity.material.*;
import cn.lime.mapper.material.MaterialConsumeMapper;
import cn.lime.mapper.material.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public boolean insertMaterialConsume(MaterialConsume materialConsume) {
        boolean flag = false;
        try {
            materialConsumeMapper.insert(materialConsume);
            Material material = materialMapper.selectByPrimaryKey(materialConsume.getMaterialId());
            material.setRemaining(material.getRemaining() - materialConsume.getConsumeAmount());
            materialMapper.updateByPrimaryKey(material);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteMaterialConsumeById(String consumeId) {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        materialConsumeExample.createCriteria().andConsumeIdEqualTo(consumeId);
        return 0 != materialConsumeMapper.deleteByExample(materialConsumeExample);
    }

    @Override
    public boolean deleteMaterialConsumeByIds(String[] consumeIds) {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        materialConsumeExample.createCriteria().andConsumeIdIn(Arrays.asList(consumeIds));
        int i = materialConsumeMapper.deleteByExample(materialConsumeExample);
        return i != 0;
    }

    @Override
    public boolean updateMaterialConsume(MaterialConsume materialConsume) {
        return 0 != materialConsumeMapper.updateByPrimaryKey(materialConsume);
    }

    @Override
    public List<MaterialConsumes> listMaterialConsumes() {
        List<MaterialConsumes> materialConsumesList = new ArrayList<>();
        List<MaterialConsume> materialConsumeList = materialConsumeMapper.
                selectByExample(new MaterialConsumeExample());
        for (MaterialConsume materialConsume : materialConsumeList) {
            MaterialConsumes materialConsumes = materialConsumeMapper.
                    queryMaterialConsumesByConsumeId(materialConsume.getConsumeId());
            materialConsumesList.add(materialConsumes);
        }
        return materialConsumesList;
    }

    @Override
    public MaterialConsume listMaterialConsumesByConsumeId(String consumeId) {
        return materialConsumeMapper.selectByPrimaryKey(consumeId);
    }

    @Override
    public List<MaterialConsumes> listMaterialConsumesByLikeConsumeId(String consumeId) {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        consumeId = "%" + consumeId + "%";
        materialConsumeExample.createCriteria().andConsumeIdLike(consumeId);
        List<MaterialConsumes> materialConsumesList = new ArrayList<>();
        List<MaterialConsume> materialConsumeList = materialConsumeMapper.selectByExample(materialConsumeExample);
        for (MaterialConsume mrs : materialConsumeList) {
            MaterialConsumes materialConsumes = materialConsumeMapper.
                    queryMaterialConsumesByConsumeId(mrs.getConsumeId());
            materialConsumesList.add(materialConsumes);
        }
        return materialConsumesList;
    }

    @Override
    public List<MaterialConsumes> listMaterialConsumesByLikeWorkId(String workId) {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        workId = "%" + workId + "%";
        materialConsumeExample.createCriteria().andWorkIdLike(workId);
        List<MaterialConsumes> materialConsumesList = new ArrayList<>();
        List<MaterialConsume> materialConsumeList = materialConsumeMapper.selectByExample(materialConsumeExample);
        for (MaterialConsume mrs : materialConsumeList) {
            MaterialConsumes materialConsumes = materialConsumeMapper.
                    queryMaterialConsumesByConsumeId(mrs.getConsumeId());
            materialConsumesList.add(materialConsumes);
        }
        return materialConsumesList;
    }

    @Override
    public List<MaterialConsumes> listMaterialConsumesByLikeMaterialId(String materialId) {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        materialId = "%" + materialId + "%";
        materialConsumeExample.createCriteria().andMaterialIdLike(materialId);
        List<MaterialConsumes> materialConsumesList = new ArrayList<>();
        List<MaterialConsume> materialConsumeList = materialConsumeMapper.selectByExample(materialConsumeExample);
        for (MaterialConsume mrs : materialConsumeList) {
            MaterialConsumes materialConsumes = materialConsumeMapper.
                    queryMaterialConsumesByConsumeId(mrs.getConsumeId());
            materialConsumesList.add(materialConsumes);
        }
        return materialConsumesList;
    }
}
