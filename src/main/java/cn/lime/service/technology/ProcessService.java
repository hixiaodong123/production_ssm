package cn.lime.service.technology;

import cn.lime.entity.technology.Process;

import java.util.List;

public interface ProcessService {
    List<Process> selectAllProcess();

    int updateProcess(Process process);

    int insertProcess(Process process);

    int deleteProcessBatch(String[] ids);

    List<Process> selectProcessByProcessIdLike(String searchValue);

    List<Process> selectProcessByTechnologyPlanIdLike(String searchValue);
}
