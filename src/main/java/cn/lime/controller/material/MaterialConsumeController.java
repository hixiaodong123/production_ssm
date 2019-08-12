package cn.lime.controller.material;

import cn.lime.entity.material.Material;
import cn.lime.entity.material.MaterialConsume;
import cn.lime.entity.material.MaterialConsumes;
import cn.lime.entity.material.OperateResponse;
import cn.lime.service.material.MaterialConsumeService;
import cn.lime.service.material.MaterialService;
import cn.lime.service.others.WorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("materialConsume")
public class MaterialConsumeController {


    @Autowired
    MaterialConsumeService materialConsumeService;

    @Autowired
    MaterialService materialService;

    @Autowired
    WorkService workService;

    @RequestMapping("find")
    public String findPage() {
        return "materialConsume_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> listMaterialConsumes(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialConsumes> materialConsumes = materialConsumeService.listMaterialConsumes();

        return returnInfo(materialConsumes);
    }

    @RequestMapping("search_materialConsume_by_consumeId")
    @ResponseBody
    public Map<String, Object> listMaterialConsumesByConsumeId(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<MaterialConsumes> materialConsumes = materialConsumeService.listMaterialConsumesByLikeConsumeId(searchValue);
        return returnInfo(materialConsumes);
    }

    @RequestMapping("search_materialConsume_by_workId")
    @ResponseBody
    public Map<String, Object> listMaterialConsumesByWorkId(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<MaterialConsumes> materialConsumes = materialConsumeService.listMaterialConsumesByLikeWorkId(searchValue);
        return returnInfo(materialConsumes);
    }

    @RequestMapping("search_materialConsume_by_materialId")
    @ResponseBody
    public Map<String, Object> listMaterialConsumesByMaterialId(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<MaterialConsumes> materialConsumes = materialConsumeService.listMaterialConsumesByLikeMaterialId(searchValue);
        return returnInfo(materialConsumes);
    }

    private Map<String, Object> returnInfo(List<MaterialConsumes> materialConsumes) {
        PageInfo<MaterialConsumes> pageInfo = new PageInfo<>(materialConsumes);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", materialConsumes);
        return map;
    }

    //需要增加权限65001
    @RequestMapping({"add_judge","edit_judge","delete_judge"})
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "materialConsume_add";
    }



    @RequestMapping("edit")
    public String edit() {
        return "materialConsume_edit";
    }

    //新增物料消耗信息
    @RequestMapping("insert")
    @ResponseBody
    public OperateResponse insert(MaterialConsume materialConsume) {
        OperateResponse operateResponse = new OperateResponse();
        if (materialConsume == null) {
            operateResponse.setStatus(400);
            operateResponse.setMsg("新增物料消耗信息失败，请稍后重试");
            operateResponse.setData(null);
            return operateResponse;
        }
        if ("".equals(materialConsume.getConsumeId()) || null == materialConsume.getConsumeId() ||
                "".equals(materialConsume.getMaterialId()) || materialConsume.getMaterialId() == null) {
            operateResponse.setStatus(403);
            operateResponse.setMsg("新增失败，物料消耗编号不能为空");
            return operateResponse;
        }
        Material material = materialService.listMaterialById(materialConsume.getMaterialId());
        MaterialConsume findMaterialConsume = materialConsumeService.listMaterialConsumesByConsumeId(materialConsume.getConsumeId());
        if (null == findMaterialConsume) {
            if (materialConsume.getConsumeAmount() < 0) {
                operateResponse.setStatus(403);
                operateResponse.setMsg("新增失败，消耗数量不能小于零");
                return operateResponse;
            } else if (materialConsume.getConsumeAmount() > material.getRemaining()) {
                operateResponse.setStatus(403);
                operateResponse.setMsg("新增失败，消耗数量不能大于现有库存数：" + material.getRemaining());
                return operateResponse;
            } else {
                materialConsumeService.insertMaterialConsume(materialConsume);
                operateResponse.setStatus(200);
                operateResponse.setMsg("OK");
                operateResponse.setData(null);
            }
        } else {
            operateResponse.setStatus(400);
            operateResponse.setMsg("新增失败，已存在相同编号");
            operateResponse.setData(null);
        }
        return operateResponse;
    }

    //更新物料消耗信息
    @RequestMapping("update_all")
    @ResponseBody
    public OperateResponse UpdateAll(MaterialConsume materialConsume) {
        OperateResponse operateResponse = new OperateResponse();

        if (materialConsume == null) {
            operateResponse.setStatus(400);
            operateResponse.setMsg("更新失败，请稍后重试");
            operateResponse.setData(null);
            return operateResponse;
        }
        if ("".equals(materialConsume.getConsumeId()) || null == materialConsume.getConsumeId() ||
                "".equals(materialConsume.getMaterialId()) || materialConsume.getMaterialId() == null) {
            operateResponse.setStatus(403);
            operateResponse.setMsg("更新失败，物料消耗编号不能为空");
            return operateResponse;
        }
        Material material = materialService.listMaterialById(materialConsume.getMaterialId());
        MaterialConsume findMaterialConsume = materialConsumeService.listMaterialConsumesByConsumeId(materialConsume.getConsumeId());
        if (materialConsume.getConsumeAmount() < 0) {
            operateResponse.setStatus(403);
            operateResponse.setMsg("修改失败，消耗数量不能小于零");
            return operateResponse;
        } else if (materialConsume.getConsumeAmount() > material.getRemaining()) {
            operateResponse.setStatus(403);
            operateResponse.setMsg("修改失败，消耗数量不能大于现有库存数：" + material.getRemaining());
            return operateResponse;
        } else {
            materialConsumeService.updateMaterialConsume(materialConsume);
            operateResponse = successOperate(operateResponse);
        }
        return operateResponse;
    }

    //更新物料消耗备注信息
    @RequestMapping("update_note")
    @ResponseBody
    public OperateResponse updateNote(MaterialConsume materialConsume) {
        MaterialConsume findMaterialConsume = materialConsumeService.listMaterialConsumesByConsumeId(materialConsume.getConsumeId());
        OperateResponse operateResponse = new OperateResponse();
        if (null != findMaterialConsume) {
            findMaterialConsume.setNote(materialConsume.getNote());
            materialConsumeService.updateMaterialConsume(findMaterialConsume);
            operateResponse = successOperate(operateResponse);
        } else {
            operateResponse.setMsg("修改失败，请稍后重试");
        }
        return operateResponse;
    }

    //删除物料消耗信息
    @RequestMapping("delete_batch")
    @ResponseBody
    public OperateResponse deleteBatch(String[] ids) {
        boolean b = materialConsumeService.deleteMaterialConsumeByIds(ids);
        OperateResponse operateResponse = new OperateResponse();
        if (b) {
            operateResponse = successOperate(operateResponse);
        } else {
            operateResponse.setMsg("删除失败，请稍后重试");
        }
        return operateResponse;
    }

    private OperateResponse successOperate(OperateResponse operateResponse) {
        operateResponse.setStatus(200);
        operateResponse.setMsg("OK");
        operateResponse.setData(null);
        return operateResponse;
    }
}

