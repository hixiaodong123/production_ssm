package cn.lime.service.material;

import cn.lime.entity.material.Material;
import cn.lime.entity.material.MaterialConsume;
import cn.lime.entity.material.MaterialConsumes;

import java.util.List;

public interface MaterialConsumeService {

    boolean insertMaterialConsume(MaterialConsume materialConsume);

    boolean deleteMaterialConsumeById(String materialConsumeId);

    boolean deleteMaterialConsumeByIds(String[] materialConsumeIds);

    boolean updateMaterialConsume(MaterialConsume materialConsume);

    List<MaterialConsumes> listMaterialConsumes();

    MaterialConsume listMaterialConsumesByConsumeId(String consumeId);

    List<MaterialConsumes> listMaterialConsumesByLikeConsumeId(String consumeId);

    List<MaterialConsumes> listMaterialConsumesByLikeWorkId(String workId);

    List<MaterialConsumes> listMaterialConsumesByLikeMaterialId(String materialConsumeId);

}
