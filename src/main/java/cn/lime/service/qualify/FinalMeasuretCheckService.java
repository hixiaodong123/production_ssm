package cn.lime.service.qualify;

import cn.lime.entity.qualify.FinalMeasuretCheck;

import java.util.List;

public interface FinalMeasuretCheckService {
    int updateFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck);

    List<FinalMeasuretCheck> listFinalMeasuretChecks();

    List<FinalMeasuretCheck> selectAllFinalMeasuretChecksLeft();

    int insertFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck);

    int deleteFinalMeasuretCheckBatch(String[] ids);

    List<FinalMeasuretCheck> selectFinalMeasureCheckByFmeasureCheckIdLike(String searchValue);

    List<FinalMeasuretCheck> selectFinalMeasureCheckByOrderIdLike(String searchValue);
}
