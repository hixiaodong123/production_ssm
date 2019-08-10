package cn.lime.controller.material;

import cn.lime.entity.material.Material;
import cn.lime.entity.material.MaterialResponse;
import cn.lime.entity.material.MaterialJson;
import cn.lime.service.material.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public MaterialResponse insert(Material material) {
        MaterialResponse materialResponse = new MaterialResponse();
        if ("".equals(material.getMaterialId()) || null == material.getMaterialId()) {
            materialResponse.setStatus(403);
            materialResponse.setMsg("新增失败，物料编号不能为空");
            return materialResponse;
        }
        Material findMaterial = materialService.listMaterialsById(material.getMaterialId());
        if (null == findMaterial) {
            materialService.insertMaterial(material);
            materialResponse.setStatus(200);
            materialResponse.setMsg("OK");
            materialResponse.setData(null);
        } else {
            materialResponse.setMsg("新增失败，请稍后重试");
        }
        return materialResponse;
    }

    //更新物料信息
    @RequestMapping("update_all")
    @ResponseBody
    public MaterialResponse UpdateAll(Material material) {
        boolean b = materialService.updateMaterial(material);
        MaterialResponse materialResponse = new MaterialResponse();
        if (b) {
            materialResponse.setStatus(200);
            materialResponse.setMsg("OK");
            materialResponse.setData(null);
        } else {
            materialResponse.setMsg("修改失败，请稍后重试");
        }
        return materialResponse;
    }

    //更新物料备注信息
    @RequestMapping("update_note")
    @ResponseBody
    public MaterialResponse updateNote(Material material) {
        Material findMaterial = materialService.listMaterialsById(material.getMaterialId());
        MaterialResponse materialResponse = new MaterialResponse();
        if (null != findMaterial) {
            findMaterial.setNote(material.getNote());
            materialService.updateMaterial(findMaterial);
            materialResponse.setStatus(200);
            materialResponse.setMsg("OK");
            materialResponse.setData(null);
        } else {
            materialResponse.setMsg("修改失败，请稍后重试");
        }
        return materialResponse;
    }

    //删除物料信息
    @RequestMapping("delete_batch")
    @ResponseBody
    public MaterialResponse deleteBatch(String[] ids) {
        boolean b = materialService.deleteMaterialByIds(ids);
        MaterialResponse materialResponse = new MaterialResponse();
        if (b) {
            materialResponse.setStatus(200);
            materialResponse.setMsg("OK");
            materialResponse.setData(null);
        } else {
            materialResponse.setMsg("删除失败，请稍后重试");
        }
        return materialResponse;
    }

}

