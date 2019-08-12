package cn.lime.service.material;

import cn.lime.entity.material.MaterialReceive;
import cn.lime.entity.material.MaterialReceives;

import java.util.List;

public interface MaterialReceiveService {

    boolean insertMaterialReceive(MaterialReceive materialReceive);

    boolean deleteMaterialReceiveById(String materialReceiveId);

    boolean deleteMaterialReceiveByIds(String[] materialReceiveIds);

    boolean updateMaterialReceive(MaterialReceive materialReceive);

    List<MaterialReceives> listMaterialReceives();

    MaterialReceive listMaterialReceivesById(String materialReceiveId);

    List<MaterialReceives> listMaterialReceivesByLikeId(String materialReceiveId);

    List<MaterialReceives> listMaterialReceivesByLikeMaterialId(String materialReceiveId);

}
