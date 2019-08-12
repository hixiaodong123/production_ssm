package cn.lime.service.technology;



import cn.lime.entity.technology.Technology;

import java.util.List;

public interface TechnologyService {
    //查询全部technology
    List<Technology> listTechnology();

    //根据technology_id查询technology
    Technology getTechnologyById(String id);

    //修改technology
    int updateTechnology(Technology technology);

    int insertTechnology(Technology technology);

    int deleteTechnologyBatch(String[] ids);

    List<Technology> selectTechnologyByIdLike(String searchValue);

    List<Technology> selectTechnologyByNameLike(String searchValue);
}
