package cn.lime.service.others;

import cn.lime.entity.plan.Work;
import cn.lime.entity.plan.WorkExample;
import cn.lime.entity.plan.WorkInfo;
import cn.lime.mapper.plan.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;

//    @Override
//    public boolean insertWork(Work others) {
//        int insert = workMapper.insert(others);
//        return insert != 0;
//    }
//
//    @Override
//    public boolean deleteWorkById(String workId) {
//        WorkExample workExample = new WorkExample();
//        workExample.createCriteria().andWorkIdEqualTo(workId);
//        int i = workMapper.deleteByExample(workExample);
//        return i != 0;
//    }
//
//    @Override
//    public boolean deleteWorkByIds(String[] workIds) {
//        WorkExample workExample = new WorkExample();
//        workExample.createCriteria().andWorkIdIn(Arrays.asList(workIds));
//        int i = workMapper.deleteByExample(workExample);
//        return i != 0;
//    }

    @Override
    public boolean updateWork(Work work) {
        WorkExample workExample = new WorkExample();
        workExample.createCriteria().andWorkIdEqualTo(work.getWorkId());
        int i = workMapper.updateByExample(work, workExample);
        return i != 0;
    }

    @Override
    public List<Work> listWorks() {
        return workMapper.selectByExample(new WorkExample());
    }

    @Override
    public WorkInfo listWorkInfoById(String workId) {
        return workMapper.selectWorkInfoByWordId(workId);
    }

//    @Override
//    public List<Work> listWorksByLikeId(String workId) {
//        WorkExample workExample = new WorkExample();
//        workId = "%" + workId + "%";
//        workExample.createCriteria().andWorkIdLike(workId);
//        return workMapper.selectByExample(workExample);
//    }

//    @Override
//    public List<Work> listWorksByLikeType(String workType) {
//        WorkExample workExample = new WorkExample();
//        workType = "%" + workType + "%";
//        workExample.createCriteria().andWorkTypeLike(workType);
//        return workMapper.selectByExample(workExample);
//    }
}
