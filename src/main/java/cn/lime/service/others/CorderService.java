package cn.lime.service.others;

import cn.lime.entity.others.Corder;

import java.util.List;

public interface CorderService {
    List<Corder> selectAllCorder();

    Corder selectCorderById(String id);
}
