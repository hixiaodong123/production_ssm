package cn.lime.controller.planprogress;

import cn.lime.entity.planprogress.Order;
import cn.lime.entity.planprogress.Product;
import cn.lime.entity.planprogress.QueryList;
import cn.lime.service.planprogress.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 产品信息模块控制器
 * @author: Lime
 * @create: 2019-08-09 16:51
 **/

@Controller
@RequestMapping("/product")
public class ProductController
{

    //注入业务层依赖
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }


    //页面跳转
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String getList(HttpServletRequest request)
    {
        //添加一个用于权限管理的集合
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
        return "product_list";
    }

    //显示所有产品信息页面的请求
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public QueryList<Product> orderListData(String page, String rows)
    {
        QueryList<Product> queryList = new QueryList<>();
        //查询所有的订单,封装成List
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Product> list = productService.findAll();
        queryList.setRows(list);
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        queryList.setTotal(total);
        return queryList;
    }

    //产品的介绍修改表单的验证请求
    @RequestMapping(value = "/edit_judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> editJudge()
    {
        return null;
    }

    //更新产品中的note的请求
    @RequestMapping(value = "/update_note", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateNote(Product product)
    {
        Map<String, Object> map = new HashMap<>();

        String note = product.getNote();
        if ("".equals(note) || note == null)
        {
            //数据为空,不能提交
            map.put("status", "100");
            return map;
        }

        try
        {
            productService.update(product);
            //没有异常就是更新成功了
            map.put("status", "200");
            return map;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //更新失败
            return null;
        }
    }

    //添加权限验证
    @RequestMapping(value = "/add_judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addJudge()
    {
        return null;
    }

    //跳转添加页面
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add()
    {
        return "product_add";
    }


    //添加一个产品的请求
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(Product product)
    {
        Map<String, Object> map = new HashMap<>();
        try
        {
            productService.insert(product);
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
            return map;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //增加失败的可能性只有Id冲突
            map.put("status", 0);
            map.put("msg", "编号主键已存在!冲突!");
            map.put("data", null);
            return map;
        }

    }


    //更新产品页面跳转
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit()
    {
        return "product_edit";
    }

    //更新产品提交请求
    @RequestMapping(value = "update_all",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateAll(Product product)
    {
        Map<String,Object> map = new HashMap<>();
        try
        {
            productService.update(product);
            map.put("status","200");
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            map.put("msg","更新失败!");
            return map;
        }

    }

    //删除权限给与
    @RequestMapping(value = "/delete_judge", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> deleteJudge()
    {
        return null;
    }

    //删除请求实现
    //@RequestMapping(value = "/delete_batch",method = RequestMethod.POST)


    //显示单个产品的页面请求
    @RequestMapping(value = "/get/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable("productId") String productId)
    {
        return productService.findByProductId(productId);
    }


}
