package cn.lime.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
public class BaseTest {
    SqlSessionFactory sessionFactory;
    SqlSession sqlSession;
    @Before
    public void initooo() throws IOException {
        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
    }

    @After
    public void closeooo(){
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void tes1() {
//        sqlSession = sessionFactory.openSession();
//        TechnologyMapper mapper = this.sqlSession.getMapper(TechnologyMapper.class);
//        TechnologyExample technologyExample = new TechnologyExample();
//        technologyExample.createCriteria().andTechnologyIdEqualTo("001");
//        List<Technology> technologies = mapper.selectByExample(technologyExample);
//        for (Technology technology : technologies) {
//            System.out.println("technology = " + technology);
//        }
    }
}
