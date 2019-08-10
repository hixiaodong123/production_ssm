package cn.lime.service.material;

import cn.lime.entity.material.Material;
import cn.lime.entity.material.MaterialExample;
import cn.lime.mapper.material.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public boolean insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert != 0;
    }

    @Override
    public boolean deleteMaterialById(String materialId) {
        MaterialExample materialExample = new MaterialExample();
        materialExample.createCriteria().andMaterialIdEqualTo(materialId);
        int i = materialMapper.deleteByExample(materialExample);
        return i != 0;
    }

    @Override
    public boolean deleteMaterialByIds(String[] materialIds) {
        MaterialExample materialExample = new MaterialExample();
        materialExample.createCriteria().andMaterialIdIn(Arrays.asList(materialIds));
        int i = materialMapper.deleteByExample(materialExample);
        return i != 0;
    }

    @Override
    public boolean updateMaterial(Material material) {
        MaterialExample materialExample = new MaterialExample();
        materialExample.createCriteria().andMaterialIdEqualTo(material.getMaterialId());
        int i = materialMapper.updateByExample(material, materialExample);
        return i != 0;
    }

    @Override
    public List<Material> listMaterials() {
        return materialMapper.selectByExample(new MaterialExample());
    }

    @Override
    public Material listMaterialsById(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

    @Override
    public List<Material> listMaterialsByLikeId(String materialId) {
        MaterialExample materialExample = new MaterialExample();
        materialId = "%" + materialId + "%";
        materialExample.createCriteria().andMaterialIdLike(materialId);
        return materialMapper.selectByExample(materialExample);
    }

    @Override
    public List<Material> listMaterialsByLikeType(String materialType) {
        MaterialExample materialExample = new MaterialExample();
        materialType = "%" + materialType + "%";
        materialExample.createCriteria().andMaterialTypeLike(materialType);
        return materialMapper.selectByExample(materialExample);
    }
}
