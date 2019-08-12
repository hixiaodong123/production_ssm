package cn.lime.service;

import cn.lime.entity.planprogress.Custom;

/**
 * @description: 客户业务层接口
 * @author: Lime
 * @create: 2019-08-09 15:40
 **/

public interface CustomService
{

    Custom findByCustomId(String customId);

    void update(Custom custom);
}
