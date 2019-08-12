package cn.lime.service.qualify;

import cn.lime.entity.qualify.FinalCountCheck;

import java.util.List;

public interface FinalCountCheckService {
    List<FinalCountCheck> listFinalCountCheck();

    FinalCountCheck getFinalCountCheckById(String id);

    int updateFinalCountCheck(FinalCountCheck finalCountCheck);

    int insertFinalCountCheck(FinalCountCheck finalCountCheck);

    int deleteFinalCountCheckBatch(String[] ids);

    List<FinalCountCheck> selectALlFinalCountCheckLeft();

    List<FinalCountCheck> selectFinalCountCheckByFcountCheckIdLike(String searchValue);

    List<FinalCountCheck> selectFinalCountCheckByOrderIdLike(String searchValue);
}
