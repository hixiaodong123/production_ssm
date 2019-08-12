package cn.lime.service.others;



import cn.lime.entity.others.Device;
import cn.lime.entity.others.DeviceExample;
import cn.lime.mapper.others.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;
    
    @Override
    public List<Device> listDevices() {
        return deviceMapper.selectByExample(new DeviceExample());
    }

}
