package cn.lime.controller.material;

import cn.lime.entity.material.Material;
import cn.lime.entity.material.OperateResponse;
import cn.lime.entity.material.MaterialJson;
import cn.lime.service.material.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("material")
public class MaterialController {


    @Autowired
    MaterialService materialService;

    @RequestMapping("find")
    public String findPage() {
        return "material_list";
    }

    @RequestMapping("get_data")
    @ResponseBody
    public Material[] getData() {
        List<Material> materialList = materialService.listMaterials();
        Material[] materials =materialList.toArray(new Material[0]);
        return materials;
    }

    @RequestMapping("list")
    @ResponseBody
    public MaterialJson listMaterials(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Material> materials = materialService.listMaterials();
        return returnInfo(materials);
    }

    @RequestMapping("search_material_by_materialId")
    @ResponseBody
    public MaterialJson listMaterialsById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<Material> materials = materialService.listMaterialsByLikeId(searchValue);
        return returnInfo(materials);
    }

    @RequestMapping("search_material_by_materialType")
    @ResponseBody
    public MaterialJson listMaterialsByType(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<Material> materials = materialService.listMaterialsByLikeType(searchValue);
        return returnInfo(materials);
    }

    @RequestMapping("get/{materialId}")
    @ResponseBody
    public Material getMaterial(@PathVariable("materialId") String materialId) {
        return materialService.listMaterialById(materialId);
    }

    private MaterialJson returnInfo(List<Material> materials) {
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        long total = pageInfo.getTotal();
        MaterialJson materialList = new MaterialJson();
        materialList.setRows(materials);
        materialList.setTotal(total);
        return materialList;
    }

    //需要增加权限65001
    @RequestMapping({"add_judge","edit_judge","delete_judge"})
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "material_add";
    }

    @RequestMapping("edit")
    public String edit() {
        return "material_edit";
    }

    //新增物料信息
    @RequestMapping("insert")
    @ResponseBody
    public OperateResponse insert(Material material) {
        OperateResponse operateResponse = new OperateResponse();
        if ("".equals(material.getMaterialId()) || null == material.getMaterialId()) {
            operateResponse.setStatus(403);
            operateResponse.setMsg("新增失败，物料编号不能为空");
            return operateResponse;
        }
        Material findMaterial = materialService.listMaterialById(material.getMaterialId());
        if (null == findMaterial) {
            materialService.insertMaterial(material);
            operateResponse.setStatus(200);
            operateResponse.setMsg("OK");
            operateResponse.setData(null);
        }
//        else if (findMaterial.getMaterialId().equals(material.getMaterialId())) {
//            findMaterial.setRemaining(findMaterial.getRemaining() + material.getRemaining());
//            materialService.updateMaterial(findMaterial);
//        }
        else {
            operateResponse.setMsg("新增失败，请稍后重试");
        }
        return operateResponse;
    }

    //更新物料信息
    @RequestMapping("update_all")
    @ResponseBody
    public OperateResponse UpdateAll(Material material) {
        boolean b = materialService.updateMaterial(material);
        OperateResponse operateResponse = new OperateResponse();
        if (b) {
            operateResponse.setStatus(200);
            operateResponse.setMsg("OK");
            operateResponse.setData(null);
        } else {
            operateResponse.setMsg("修改失败，请稍后重试");
        }
        return operateResponse;
    }

    //更新物料备注信息
    @RequestMapping("update_note")
    @ResponseBody
    public OperateResponse updateNote(Material material) {
        Material findMaterial = materialService.listMaterialById(material.getMaterialId());
        OperateResponse operateResponse = new OperateResponse();
        if (null != findMaterial) {
            findMaterial.setNote(material.getNote());
            materialService.updateMaterial(findMaterial);
            operateResponse.setStatus(200);
            operateResponse.setMsg("OK");
            operateResponse.setData(null);
        } else {
            operateResponse.setMsg("修改失败，请稍后重试");
        }
        return operateResponse;
    }

    //删除物料信息
    @RequestMapping("delete_batch")
    @ResponseBody
    public OperateResponse deleteBatch(String[] ids) {
        boolean b = materialService.deleteMaterialByIds(ids);
        OperateResponse operateResponse = new OperateResponse();
        if (b) {
            operateResponse.setStatus(200);
            operateResponse.setMsg("OK");
            operateResponse.setData(null);
        } else {
            operateResponse.setMsg("删除失败，请稍后重试");
        }
        return operateResponse;
    }

}

