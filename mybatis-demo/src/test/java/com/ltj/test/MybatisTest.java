package com.ltj.test;

import com.ltj.mapper.BrandMapper;
import com.ltj.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id = 1;

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectBySingleChoice() throws IOException {
        //接收参数
        int status = 1;
        String companyName="松鼠";
        String brandName="华为";

        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

        //封装对象
        //只接受了一个status
        Brand brand1 = new Brand();
        brand1.setStatus(status);
//        brand1.setCompanyName(companyName);
        //brand1.setBrandName(brandName);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brand = brandMapper.selectBySingleChoice(brand1);
        System.out.println(brand);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName="波导手机";
        String brandName="波导";
        String description="手机中的战斗机";
        int ordered=100;

        //封装对象
        Brand brand1 = new Brand();
        brand1.setStatus(status);
        brand1.setCompanyName(companyName);
        brand1.setBrandName(brandName);
        brand1.setDescription(description);
        brand1.setOrdered(ordered);


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象  true自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand1);

        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd1() throws IOException {
        //接收参数
        int status = 1;
        String companyName="苹果手机";
        String brandName="苹果";
        String description="手机中的战斗机";
        int ordered=20;

        //封装对象
        Brand brand1 = new Brand();
        brand1.setStatus(status);
        brand1.setCompanyName(companyName);
        brand1.setBrandName(brandName);
        brand1.setDescription(description);
        brand1.setOrdered(ordered);


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象  true自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand1);
        System.out.println(brand1.getId());

        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        //接收参数
//        int status = 1;
       String companyName="菠萝手机";
//        String brandName="波导";
//        String description="波导手机，手机中的战斗机,你值得拥有！！！";
//        int ordered=300;
        int id=5;

        //封装对象
        Brand brand1 = new Brand();
//        brand1.setStatus(status);
        brand1.setCompanyName(companyName);
//        brand1.setBrandName(brandName);
//        brand1.setDescription(description);
//        brand1.setOrdered(ordered);
        brand1.setId(id);


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象  true自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        int count=brandMapper.update(brand1);
        System.out.println(count);

        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void delete() throws IOException {
        //接收参数
        int id=5;

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象  true自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteById(id);
        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void deleteById() throws IOException {
        //接收参数
        int[] ids={3,8};

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象  true自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteByIds(ids);
        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }
}