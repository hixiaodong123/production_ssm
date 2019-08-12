package cn.lime.controller.planprogress.upload;

import cn.lime.entity.planprogress.Order;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description: 文件上传控制器
 * @author: Lime
 * @create: 2019-08-10 16:17
 **/

@Controller
@RequestMapping("/file")
public class FileUploadController
{


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(MultipartFile file, HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<>();
        //获取文件上传的路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/file/");
        //判断该路径是否存在
        File file1 = new File(realPath);
        if (!file1.exists())
        {
            //如果不存在就创建一个
            file1.mkdirs();
        }
        //获取文件的名字
        String filename = file.getOriginalFilename();
        //上传路径+名字
        String url = request.getContextPath() + "/upload/file/" + filename;
        //开始上传
        try
        {
            File file2 = new File(realPath, filename);
            file.transferTo(file2);
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

    //删除添加界面文件
    //界面图片删除的同时也要删除本地文件
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> delete(String fileName, HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<>();
        // 文件路径
        String path = request.getSession().getServletContext().getRealPath("/upload/file/");
        String newFileName = fileName.replaceAll("/production/upload/file/", "");
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
        return map;
    }


    //文件下载的请求方法
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("fileName") String fileName) throws Exception
    {
        //下载文件路径
        String path = request.getSession().getServletContext().getRealPath("/upload/file/");
        //该路径一定存在,不用判断是否存在
        HttpHeaders headers = new HttpHeaders();
        fileName = fileName.replaceAll("/production/upload/file/", "");
        File file = new File(path + File.separator + fileName);
        //下载显示的文件名，解决中文名称乱码问题
        fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        //通知浏览器以attachment（下载方式）打开
        headers.setContentDispositionFormData("attachment", fileName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
