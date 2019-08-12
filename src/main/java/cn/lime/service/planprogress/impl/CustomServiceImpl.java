package cn.lime.service.planprogress.impl;

import cn.lime.entity.planprogress.Custom;
import cn.lime.mapper.planprogress.CustomMapper;
import cn.lime.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 客户业务层实现类
 * @author: Lime
 * @create: 2019-08-09 15:42
 **/
@Service
public class CustomServiceImpl implements CustomService
{

    private final CustomMapper customMapper;

    @Autowired
    public CustomServiceImpl(CustomMapper customMapper)
    {
        this.customMapper = customMapper;
    }


    @Override
    public Custom findByCustomId(String customId)
    {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public void update(Custom custom)
    {
        customMapper.updateByPrimaryKeySelective(custom);
    }
}
