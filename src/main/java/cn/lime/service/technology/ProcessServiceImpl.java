package cn.lime.service.technology;

import cn.lime.entity.technology.Process;
import cn.lime.entity.technology.ProcessExample;
import cn.lime.mapper.tehnology.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService{
    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> selectAllProcess() {
        List<Process> processes = processMapper.selectByExample(new ProcessExample());
        return processes;
    }
}
