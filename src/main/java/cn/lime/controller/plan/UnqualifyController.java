package cn.lime.controller.plan;


import cn.lime.entity.material.OperateResponse;
import cn.lime.entity.qualify.Unqualify;
import cn.lime.entity.qualify.UnqualifyJson;
import cn.lime.service.qualify.UnqualifyService;
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
@RequestMapping("unqualify")
public class UnqualifyController {

    @Autowired
    UnqualifyService unqualifyService;

    @RequestMapping("find")
    public String findPage() {
        return "unqualify_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> listUnqualify(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<UnqualifyJson> unqualifyJsonList = unqualifyService.listUnqualifys();
        return returnInfo(unqualifyJsonList);
    }

    @RequestMapping("search_unqualify_by_unqualifyId")
    @ResponseBody
    public Map<String, Object> listUnqualifyById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<UnqualifyJson> unqualifyList = unqualifyService.listUnqualifysByLikeId(searchValue);
        return returnInfo(unqualifyList);
    }

    @RequestMapping("search_unqualify_by_productName")
    @ResponseBody
    public Map<String, Object> listUnqualifyByUnqualifyName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<UnqualifyJson> unqualifyJsonList = unqualifyService.listUnqualifysByLikeProductName(searchValue);
        return returnInfo(unqualifyJsonList);
    }

    private Map<String, Object> returnInfo(List<UnqualifyJson> unqualifyJsonList) {
        PageInfo<UnqualifyJson> pageInfo = new PageInfo<>(unqualifyJsonList);
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", unqualifyJsonList);
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
        return "unqualify_add";
    }



    @RequestMapping("edit")
    public String edit() {
        return "unqualify_edit";
    }

    private OperateResponse successOperate() {
        OperateResponse operateResponse = new OperateResponse();
        operateResponse.setStatus(200);
        operateResponse.setMsg("OK");
        operateResponse.setData(null);
        return operateResponse;
    }

    private OperateResponse failOperate() {
        OperateResponse operateResponse = new OperateResponse();
        operateResponse.setStatus(403);
        operateResponse.setData(null);
        return operateResponse;
    }

    //新增部门信息
    @RequestMapping("insert")
    @ResponseBody
    public OperateResponse insert(Unqualify unqualify) {
        boolean flag = unqualifyService.insertUnqualify(unqualify);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("存在相同的不合格品申请编号，新增失败");
        return operateResponse;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public OperateResponse UpdateAll(Unqualify unqualify) {
        boolean flag = unqualifyService.updateUnqualify(unqualify);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("更新不合格品申请信息失败");
        return operateResponse;
    }

    //更新部门备注信息
    @RequestMapping("update_note")
    @ResponseBody
    public OperateResponse updateNote(Unqualify unqualify) {
        boolean flag = unqualifyService.updateUnqualifyNote(unqualify);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("更新部门备注信息失败，请重试");
        return operateResponse;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public OperateResponse deleteBatch(String[] ids) {
        boolean flag = unqualifyService.deleteUnqualifyByIds(ids);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("批次删除失败，请重试");
        return operateResponse;
    }

}

