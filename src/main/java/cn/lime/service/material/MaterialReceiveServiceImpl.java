package cn.lime.service.material;


import cn.lime.entity.material.Material;
import cn.lime.entity.material.MaterialReceive;
import cn.lime.entity.material.MaterialReceiveExample;
import cn.lime.entity.material.MaterialReceives;
import cn.lime.mapper.material.MaterialMapper;
import cn.lime.mapper.material.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public boolean insertMaterialReceive(MaterialReceive materialReceive) {
        boolean flag = false;
        try {
            materialReceiveMapper.insert(materialReceive);
            String materialId = materialReceive.getMaterialId();
            Material material = materialMapper.selectByPrimaryKey(materialId);
            material.setRemaining(material.getRemaining() + materialReceive.getAmount());
            materialMapper.updateByPrimaryKey(material);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteMaterialReceiveById(String receiveId) {
            return 0 != materialReceiveMapper.deleteByPrimaryKey(receiveId);
    }

    @Override
    public boolean deleteMaterialReceiveByIds(String[] receiveIds) {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        materialReceiveExample.createCriteria().andReceiveIdIn(Arrays.asList(receiveIds));
        return 0 !=materialReceiveMapper.deleteByExample(materialReceiveExample);
    }

    @Override
    public boolean updateMaterialReceive(MaterialReceive materialReceive) {
        return 0 != materialReceiveMapper.updateByPrimaryKey(materialReceive);
    }

    @Override
    public List<MaterialReceives> listMaterialReceives() {
        List<MaterialReceives> materialReceivesList = new ArrayList<>();
        List<MaterialReceive> materialReceiveList = materialReceiveMapper.
                selectByExample(new MaterialReceiveExample());
        for (MaterialReceive materialReceive : materialReceiveList) {
            MaterialReceives materialReceives = materialReceiveMapper.
                    queryMaterialReceivesByReceiveId(materialReceive.getReceiveId());
            materialReceivesList.add(materialReceives);
        }
        return materialReceivesList;
    }

    @Override
    public MaterialReceive listMaterialReceivesById(String receiveId) {
        return materialReceiveMapper.selectByPrimaryKey(receiveId);
    }

    @Override
    public List<MaterialReceives> listMaterialReceivesByLikeId(String receiveId) {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        receiveId = "%" + receiveId + "%";
        materialReceiveExample.createCriteria().andReceiveIdLike(receiveId);
        List<MaterialReceives> materialReceivesList = new ArrayList<>();
        List<MaterialReceive> materialReceiveList = materialReceiveMapper.selectByExample(materialReceiveExample);
        for (MaterialReceive mrs : materialReceiveList) {
            MaterialReceives materialReceives = materialReceiveMapper.
                    queryMaterialReceivesByReceiveId(mrs.getReceiveId());
            materialReceivesList.add(materialReceives);
        }
        return materialReceivesList;
    }

    @Override
    public List<MaterialReceives> listMaterialReceivesByLikeMaterialId(String materialId) {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        materialId = "%" + materialId + "%";
        materialReceiveExample.createCriteria().andMaterialIdLike(materialId);
        List<MaterialReceives> materialReceivesList = new ArrayList<>();
        List<MaterialReceive> materialReceiveList = materialReceiveMapper.selectByExample(materialReceiveExample);
        for (MaterialReceive mrs : materialReceiveList) {
            MaterialReceives materialReceives = materialReceiveMapper.
                    queryMaterialReceivesByReceiveId(mrs.getReceiveId());
            materialReceivesList.add(materialReceives);
        }
        return materialReceivesList;
    }
}
