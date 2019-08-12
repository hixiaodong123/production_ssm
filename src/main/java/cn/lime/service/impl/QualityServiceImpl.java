package cn.lime.service.impl;

import cn.lime.entity.quality.ProcessCountCheck;
import cn.lime.entity.quality.ProcessMeasureCheck;
import cn.lime.mapper.quality.ProcessCountCheckMapper;
import cn.lime.mapper.quality.ProcessMeasureCheckMapper;
import cn.lime.service.QualityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QualityServiceImpl implements QualityService {
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Override
    public Map<String, Object> selectAllProcessMeasureCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectAllProcessMeasureCheck();
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",processMeasureChecks);
        return map;
    }

    @Override
    public int insertSelective(ProcessMeasureCheck record) {
        return processMeasureCheckMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(ProcessMeasureCheck record) {
        return processMeasureCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String pMeasureCheckId) {
        return processMeasureCheckMapper.deleteByPrimaryKey(pMeasureCheckId);
    }

    @Override
    public Map<String, Object> likeSelectPMeasureCheckBypMeasureCheckId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        String pMeasureCheckId="%"+searchValue+"%";
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.likeSelectUserByRoleName(pMeasureCheckId);
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",processMeasureChecks);
        return map;
    }

    @Override
    public Map<String, Object> selectAllPCountCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectAllPCountCheck();
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processCountChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",processCountChecks);
        return map;
    }

    @Override
    public int insert(ProcessCountCheck record) {
        return processCountCheckMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(ProcessCountCheck record) {
        return processCountCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteCountByPrimaryKey(String pCountCheckId) {
        return processCountCheckMapper.deleteByPrimaryKey(pCountCheckId);
    }

    @Override
    public Map<String, Object> likeSelectPCountCheckBypCountCheckId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        String pCountCheckMapperId="%"+searchValue+"%";
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.likeSelectPCountCheckBypCountCheckId(pCountCheckMapperId);
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processCountChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",processCountChecks);
        return map;
    }
}
