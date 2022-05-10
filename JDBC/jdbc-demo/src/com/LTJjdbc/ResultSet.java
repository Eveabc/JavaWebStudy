package com.LTJjdbc;

import com.LTJjdbc.pojo.Demo;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC API详解：Result
 */
public class ResultSet {

    @Test
    public void testResultSet() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        //String url="jdbc:mysql://localhost:3306/food?useSSL=false";
        //如果连接的是本机，3306可以简写
        String url="jdbc:mysql:///food?useSSL=false";
        String username="root";
        String password="151858";
        Connection conn= DriverManager.getConnection(url,username,password);

        //3.定义sql
        String sql="select * from demo";

        //4.获取statement对象
        Statement stmt = conn.createStatement();

        //5.执行sql
        java.sql.ResultSet rs = stmt.executeQuery(sql);

        //创建集合
        List<Demo> list=new ArrayList<>();

        //6.遍历输出
        while (rs.next()){
            Demo demo=new Demo();

            //获取数据
            String name=rs.getString("name");
            String sex=rs.getString("sex");

           //赋值
            demo.setName(name);
            demo.setSex(sex);

            //存入集合
            list.add(demo);
        }

        System.out.println(list);

        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
