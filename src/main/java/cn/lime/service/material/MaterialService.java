package cn.lime.service.material;

import cn.lime.entity.material.Material;

import java.util.List;

public interface MaterialService {

    boolean insertMaterial(Material material);

    boolean deleteMaterialById(String materialId);

    boolean deleteMaterialByIds(String[] materialIds);

    boolean updateMaterial(Material material);

    List<Material> listMaterials();

    Material listMaterialById(String materialId);

    List<Material> listMaterialsByLikeId(String materialId);

    List<Material> listMaterialsByLikeType(String materialId);

}
