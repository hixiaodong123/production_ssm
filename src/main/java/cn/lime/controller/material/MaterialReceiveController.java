package cn.lime.controller.material;

import cn.lime.entity.material.MaterialReceive;
import cn.lime.entity.material.MaterialReceiveJson;
import cn.lime.entity.material.MaterialReceives;
import cn.lime.entity.material.MaterialResponse;
import cn.lime.service.material.MaterialReceiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("materialReceive")
public class MaterialReceiveController {


    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("find")
    public String findPage() {
        return "materialReceive_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public MaterialReceiveJson listMaterialReceives(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialReceives> materialReceives = materialReceiveService.listMaterialReceives();
        return returnInfo(materialReceives);
    }

//    @RequestMapping("search_materialReceive_by_ReceiveId")
//    @ResponseBody
//    public MaterialReceiveJson listMaterialReceivesById(int page, int rows, String searchValue) {
//        PageHelper.startPage(page, rows);
//        List<MaterialReceives> materialReceives = materialReceiveService.listMaterialReceivesByLikeId(searchValue);
//        return returnInfo(materialReceives);
//    }
//
//    @RequestMapping("search_materialReceive_by_materialId")
//    @ResponseBody
//    public MaterialReceiveJson listMaterialReceivesByType(int page, int rows, String searchValue) {
//        PageHelper.startPage(page, rows);
//        List<MaterialReceives> materialReceives = materialReceiveService.listMaterialReceivesByLikeType(searchValue);
//        return returnInfo(materialReceives);
//    }

    private MaterialReceiveJson returnInfo(List<MaterialReceives> materialReceives) {
        PageInfo<MaterialReceives> pageInfo = new PageInfo<>(materialReceives);
        long total = pageInfo.getTotal();
        MaterialReceiveJson materialReceiveJson = new MaterialReceiveJson();
        materialReceiveJson.setRows(materialReceives);
        materialReceiveJson.setTotal(total);
        return materialReceiveJson;
    }

    //需要增加权限65001
    @RequestMapping({"add_judge","edit_judge","delete_judge"})
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "materialReceive_list";
    }

    @RequestMapping("edit")
    public String edit() {
        return "materialReceive_edit";
    }

    //新增物料信息
    @RequestMapping("insert")
    @ResponseBody
    public MaterialResponse insert(MaterialReceive materialReceive) {
        MaterialResponse materialResponse = new MaterialResponse();
        if ("".equals(materialReceive.getReceiveId()) || null == materialReceive.getReceiveId()) {
            materialResponse.setStatus(403);
            materialResponse.setMsg("新增失败，物料编号不能为空");
            return materialResponse;
        }
        MaterialReceive findMaterialReceive = materialReceiveService.listMaterialReceivesById(materialReceive.getReceiveId());
        if (null == findMaterialReceive) {
            materialReceiveService.insertMaterialReceive(materialReceive);
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
    public MaterialResponse UpdateAll(MaterialReceive materialReceive) {
        boolean b = materialReceiveService.updateMaterialReceive(materialReceive);
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
    public MaterialResponse updateNote(MaterialReceive materialReceive) {
        MaterialReceive findMaterialReceive = materialReceiveService.listMaterialReceivesById(materialReceive.getReceiveId());
        MaterialResponse materialResponse = new MaterialResponse();
        if (null != findMaterialReceive) {
            findMaterialReceive.setNote(materialReceive.getNote());
            materialReceiveService.updateMaterialReceive(findMaterialReceive);
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
        boolean b = materialReceiveService.deleteMaterialReceiveByIds(ids);
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

