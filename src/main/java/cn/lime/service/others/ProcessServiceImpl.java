package cn.lime.service.others;



import cn.lime.entity.others.Process;
import cn.lime.entity.others.ProcessExample;
import cn.lime.mapper.ohters.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;
    
    @Override
    public List<Process> listProcesss() {
        return processMapper.selectByExample(new ProcessExample());
    }

}
