package cn.lime.service.qualify.impl;

import cn.lime.entity.qualify.FinalMeasuretCheck;
import cn.lime.entity.qualify.FinalMeasuretCheckExample;
import cn.lime.mapper.qualify.FinalMeasuretCheckMapper;
import cn.lime.service.qualify.FinalMeasuretCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FinalMeasuretCheckServiceImpl implements FinalMeasuretCheckService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public int updateFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck) {
        int i = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
        return i;
    }

    @Override
    public List<FinalMeasuretCheck> listFinalMeasuretChecks() {
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExample(finalMeasuretCheckExample);
        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> selectAllFinalMeasuretChecksLeft() {
        List<FinalMeasuretCheck> technologyPlans = finalMeasuretCheckMapper.selectAllFinalMeasuretChecksLeft();
        return technologyPlans;
    }

    @Override
    public int insertFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck) {
        int insert = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
        return insert;
    }

    @Override
    public int deleteFinalMeasuretCheckBatch(String[] ids) {
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        finalMeasuretCheckExample.createCriteria().andFMeasureCheckIdIn(Arrays.asList(ids));
        int i = finalMeasuretCheckMapper.deleteByExample(finalMeasuretCheckExample);
        return i;
    }

    @Override
    public List<FinalMeasuretCheck> selectFinalMeasureCheckByFmeasureCheckIdLike(String searchValue) {
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectFinalMeasureCheckByFmeasureCheckIdLike(searchValue);
        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> selectFinalMeasureCheckByOrderIdLike(String searchValue) {
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectFinalMeasureCheckByOrderIdLike(searchValue);
        return finalMeasuretChecks;
    }
}
