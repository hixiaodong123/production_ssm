package cn.lime.controller.planprogress.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description: 图片文件上传的控制器
 * @author: Lime
 * @create: 2019-08-09 20:50
 **/

@Controller
@RequestMapping("/pic")
public class PictureUploadController
{

    //图片上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(MultipartFile uploadFile, HttpServletRequest request)
    {


        Map<String, Object> map = new HashMap<>();
        //获取文件上传的路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/images/product");
        //判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists())
        {
            //如果不存在就创建一个
            file.mkdirs();
        }
        //获取文件的名字
        String filename = uploadFile.getOriginalFilename();
        //对文件名做唯一化处理
        String uuid = UUID.randomUUID().toString().replace("-", "_");
        filename = uuid + "_" + filename;
        String url = request.getContextPath() + "/upload/images/product/" + filename;

        //开始上传
        try
        {
            uploadFile.transferTo(new File(realPath, filename));
            map.put("error", 0);
            map.put("url", url);
            return map;
        }
        catch (IOException | IllegalStateException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    //删除添加界面图片的请求
    //界面图片删除的同时也要删除本地图片
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> delete(String picName, HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<>();
        // 文件路径
        String path = request.getSession().getServletContext().getRealPath("/upload/images/product/");
        String newFileName = picName.replaceAll("/production/upload/images/product/","");
        File targetFile = new File(path, newFileName);
        if (targetFile.exists())
        {
            try
            {
                targetFile.delete();
                map.put("data", "success");
                return map;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }

        }
        map.put("data", "success");
        return map;    }
}
