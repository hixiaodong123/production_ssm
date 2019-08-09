package cn.lime.test.mapper.planprogress;
import cn.lime.entity.planprogress.Custom;
import cn.lime.mapper.planprogress.CustomMapper;
import cn.lime.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @description: 客户测试持久层
 * @author: Lime
 * @create: 2019-08-08 11:22
 **/

public class CustomMapperTest extends BaseTest
{
    @Autowired
    private CustomMapper customMapper;

    @Test
    public void testFindById()
    {
        Custom custom = customMapper.selectByPrimaryKey("001");
        System.out.println(custom);
    }
}
