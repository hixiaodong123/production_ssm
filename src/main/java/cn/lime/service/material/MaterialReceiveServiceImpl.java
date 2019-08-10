package cn.lime.service.material;


import cn.lime.entity.material.MaterialReceive;
import cn.lime.entity.material.MaterialReceiveExample;
import cn.lime.entity.material.MaterialReceives;
import cn.lime.mapper.material.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public boolean insertMaterialReceive(MaterialReceive materialReceive) {
        int insert = materialReceiveMapper.insert(materialReceive);
        return insert != 0;
    }

    @Override
    public boolean deleteMaterialReceiveById(String receiveId) {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        materialReceiveExample.createCriteria().andReceiveIdEqualTo(receiveId);
        int i = materialReceiveMapper.deleteByExample(materialReceiveExample);
        return i != 0;
    }

    @Override
    public boolean deleteMaterialReceiveByIds(String[] receiveIds) {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        materialReceiveExample.createCriteria().andReceiveIdIn(new ArrayList<>(Arrays.asList(receiveIds)));
        int i = materialReceiveMapper.deleteByExample(materialReceiveExample);
        return i != 0;
    }

    @Override
    public boolean updateMaterialReceive(MaterialReceive materialReceive) {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        materialReceiveExample.createCriteria().andReceiveIdEqualTo(materialReceive.getReceiveId());
        int i = materialReceiveMapper.updateByExample(materialReceive, materialReceiveExample);
        return i != 0;
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

//    @Override
//    public List<MaterialReceives> listMaterialReceivesByLikeId(String receiveId) {
//        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
//        receiveId = "%" + receiveId + "%";
//        materialReceiveExample.createCriteria().andReceiveIdLike(receiveId);
//        return materialReceiveMapper.selectByExample(materialReceiveExample);
//    }
//
//    @Override
//    public List<MaterialReceives> listMaterialReceivesByLikeType(String materialId) {
//        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
//        materialId = "%" + materialId + "%";
//        materialReceiveExample.createCriteria().andMaterialIdLike(materialId);
//        return materialReceiveMapper.selectByExample(materialReceiveExample);
//    }
}
