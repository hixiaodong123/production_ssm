package cn.lime.controller.others;


import cn.lime.entity.others.Device;
import cn.lime.service.others.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("deviceList")
public class DeviceController {

    @Autowired
    DeviceService deviceService;
    
    //获取表device中全部的信息
    @RequestMapping("get_data")
    @ResponseBody
    public Device[] getData() {
        List<Device> deviceList = deviceService.listDevices();
        Device[] devices =deviceList.toArray(new Device[0]);
        return devices;
    }

}