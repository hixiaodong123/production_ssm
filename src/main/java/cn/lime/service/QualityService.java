package cn.lime.service;

import cn.lime.entity.quality.ProcessCountCheck;
import cn.lime.entity.quality.ProcessMeasureCheck;

import java.util.Map;

public interface QualityService {
    Map<String, Object> selectAllProcessMeasureCheck(int page, int rows);

    int insertSelective(ProcessMeasureCheck record);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int deleteByPrimaryKey(String pMeasureCheckId);

    Map<String,Object> likeSelectPMeasureCheckBypMeasureCheckId(String searchValue,int page,int rows);

    Map<String, Object> selectAllPCountCheck(int page,int rows);

    int insert(ProcessCountCheck record);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int deleteCountByPrimaryKey(String pCountCheckId);

    Map<String,Object> likeSelectPCountCheckBypCountCheckId(String searchValue,int page,int rows);
}
