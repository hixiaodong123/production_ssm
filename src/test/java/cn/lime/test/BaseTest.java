package cn.lime.test;

import cn.lime.entity.device.Device;
import cn.lime.mapper.device.DeviceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
*
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit

*/

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-mapper.xml", "classpath:spring/spring-service.xml"})
public class BaseTest
{
    @Autowired
    DeviceMapper deviceMapper;

    @Test
    public void test1(){
        List<Device> devices = deviceMapper.selectAllDevice();
        for (Device device : devices) {
            System.out.println(device);
        }
    }
}
