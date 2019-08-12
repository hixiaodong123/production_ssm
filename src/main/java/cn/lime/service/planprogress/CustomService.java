package cn.lime.service.planprogress;

import cn.lime.entity.planprogress.Custom;

import java.util.List;

/**
 * @description: 客户业务层接口
 * @author: Lime
 * @create: 2019-08-09 15:40
 **/

public interface CustomService
{

    Custom findByCustomId(String customId);

    void update(Custom custom);

    List<Custom> findAll();
}
