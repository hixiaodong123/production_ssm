package cn.lime.service.technology.impl;


import cn.lime.entity.technology.Process;
import cn.lime.entity.technology.ProcessExample;
import cn.lime.mapper.tehnology.ProcessMapper;
import cn.lime.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> selectAllProcess() {
        List<Process> processes = processMapper.selectByExample(new ProcessExample());
        return processes;
    }

    @Override
    public int updateProcess(Process process) {
        int update = processMapper.updateByPrimaryKey(process);
        return update;
    }

    @Override
    public int insertProcess(Process process) {
        int insert = processMapper.insert(process);
        return insert;
    }

    @Override
    public int deleteProcessBatch(String[] ids) {
        ProcessExample processExample = new ProcessExample();
        processExample.createCriteria().andProcessIdIn(Arrays.asList(ids));
        int i = processMapper.deleteByExample(processExample);
        return i;
    }

    //模糊查询
    //按工艺编号查询
    @Override
    public List<Process> selectProcessByProcessIdLike(String searchValue) {
        ProcessExample processExample = new ProcessExample();
        processExample.createCriteria().andProcessIdLike(searchValue);
        List<Process> processes = processMapper.selectByExample(processExample);
//        List<Process> processes = processMapper.selectProcessByProcessIdLike(searchValue);
        return processes;
    }
    //按工艺计划编号查询
    @Override
    public List<Process> selectProcessByTechnologyPlanIdLike(String searchValue) {
        ProcessExample processExample = new ProcessExample();
        processExample.createCriteria().andTechnologyPlanIdLike(searchValue);
        List<Process> processes = processMapper.selectByExample(processExample);
//        List<Process> processes = processMapper.selectProcessByTechnologyPlanIdLike(searchValue);
        return processes;
    }

    @Override
    public List<Process> listProcesss() {
        return processMapper.selectByExample(new ProcessExample());
    }
}
