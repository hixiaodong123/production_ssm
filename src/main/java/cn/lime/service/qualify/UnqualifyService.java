package cn.lime.service.qualify;


import cn.lime.entity.qualify.Unqualify;
import cn.lime.entity.qualify.UnqualifyJson;

import java.util.List;

public interface UnqualifyService {

    boolean insertUnqualify(Unqualify unqualify);

    boolean deleteUnqualifyById(String empId);

    boolean deleteUnqualifyByIds(String[] empIds);

    boolean updateUnqualify(Unqualify unqualify);

    boolean updateUnqualifyNote(Unqualify unqualify);

    List<UnqualifyJson> listUnqualifys();

    List<UnqualifyJson> listUnqualifysByLikeId(String qualifyApplyId);

    List<UnqualifyJson> listUnqualifysByLikeProductName(String ProductName);

}
