package cn.lime.controller.material;

import cn.lime.entity.material.MaterialReceive;
import cn.lime.entity.material.MaterialReceiveJson;
import cn.lime.entity.material.MaterialReceives;
import cn.lime.entity.material.OperateResponse;
import cn.lime.service.material.MaterialReceiveService;
import cn.lime.service.material.MaterialService;
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

    @Autowired
    MaterialService materialService;

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

    @RequestMapping("search_materialReceive_by_receiveId")
    @ResponseBody
    public MaterialReceiveJson listMaterialReceivesById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<MaterialReceives> materialReceives = materialReceiveService.listMaterialReceivesByLikeId(searchValue);
        return returnInfo(materialReceives);
    }

    @RequestMapping("search_materialReceive_by_materialId")
    @ResponseBody
    public MaterialReceiveJson listMaterialReceivesByMaterialId(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<MaterialReceives> materialReceives = materialReceiveService.listMaterialReceivesByLikeMaterialId(searchValue);
        return returnInfo(materialReceives);
    }

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
        return "materialReceive_add";
    }



    @RequestMapping("edit")
    public String edit() {
        return "materialReceive_edit";
    }

    //新增物料信息
    @RequestMapping("insert")
    @ResponseBody
    public OperateResponse insert(MaterialReceive materialReceive) {
        OperateResponse operateResponse = new OperateResponse();
        if (materialReceive == null) {
            operateResponse.setStatus(400);
            operateResponse.setMsg("新增失败，请稍后重试");
            operateResponse.setData(null);
            return operateResponse;
        }
        if ("".equals(materialReceive.getReceiveId()) || null == materialReceive.getReceiveId() ||
                "".equals(materialReceive.getMaterialId()) || materialReceive.getMaterialId() == null) {
            operateResponse.setStatus(403);
            operateResponse.setMsg("新增失败，物料编号不能为空");
            return operateResponse;
        }
        String receiveId = materialReceive.getReceiveId();
        MaterialReceive findMaterialReceive = materialReceiveService.listMaterialReceivesById(receiveId);
        if (null == findMaterialReceive) {
            if (materialReceive.getAmount() < 0) {
                operateResponse.setStatus(403);
                operateResponse.setMsg("新增失败，收入数量不能小于零");
                return operateResponse;
            }
            materialReceiveService.insertMaterialReceive(materialReceive);
            operateResponse.setStatus(200);
            operateResponse.setMsg("OK");
            operateResponse.setData(null);
        } else {
            operateResponse.setStatus(400);
            operateResponse.setMsg("新增失败，请稍后重试");
            operateResponse.setData(null);
        }
        return operateResponse;
    }

    //更新物料信息
    @RequestMapping("update_all")
    @ResponseBody
    public OperateResponse UpdateAll(MaterialReceive materialReceive) {
        boolean b = materialReceiveService.updateMaterialReceive(materialReceive);
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
    public OperateResponse updateNote(MaterialReceive materialReceive) {
        MaterialReceive findMaterialReceive = materialReceiveService.listMaterialReceivesById(materialReceive.getReceiveId());
        OperateResponse operateResponse = new OperateResponse();
        if (null != findMaterialReceive) {
            findMaterialReceive.setNote(materialReceive.getNote());
            materialReceiveService.updateMaterialReceive(findMaterialReceive);
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
        boolean b = materialReceiveService.deleteMaterialReceiveByIds(ids);
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

