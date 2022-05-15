package com.ltj.mapper;


import com.ltj.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     * 查询所有
     */
    public List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * 条件查询
     *         参数接收
     *          1.散装参数@Param("sql语句中的参数占位符")
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);
    //List<Brand> selectByCondition(Brand brand);
    //  List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectBySingleChoice(Brand brand);

    void add(Brand brand);

    /**
     * 修改数据
     * @param brand
     * @return
     */
    int update(Brand brand);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);
}
