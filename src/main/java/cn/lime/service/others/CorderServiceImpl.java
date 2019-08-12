package cn.lime.service.others;

import cn.lime.entity.others.Corder;
import cn.lime.entity.others.CorderExample;
import cn.lime.mapper.others.CorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorderServiceImpl implements CorderService {
    @Autowired
    CorderMapper corderMapper;

    @Override
    public List<Corder> selectAllCorder() {
        List<Corder> corders = corderMapper.selectByExample(new CorderExample());
        return corders;
    }

    @Override
    public Corder selectCorderById(String id) {
        Corder corder = corderMapper.selectByPrimaryKey(id);
        return corder;
    }
}
