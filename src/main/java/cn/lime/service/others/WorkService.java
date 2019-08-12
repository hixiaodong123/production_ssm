package cn.lime.service.others;

import cn.lime.entity.plan.Work;
import cn.lime.entity.plan.WorkInfo;

import java.util.List;

public interface WorkService {

//    boolean insertWork(Work others);
//
//    boolean deleteWorkById(String workId);
//
//    boolean deleteWorkByIds(String[] workIds);
//
//    boolean updateWork(Work others);
//
      List<Work> listWorks();

      WorkInfo listWorkInfoById(String workId);

      boolean updateWork(Work work);

//    List<Work> listWorksByLikeId(String workId);
//
//    List<Work> listWorksByLikeType(String workId);

}
