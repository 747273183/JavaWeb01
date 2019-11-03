package com.dao;

import java.sql.*;

public class BaseDao {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    //获得连接
    public Connection getConn()
    {
        String url="jdbc:mysql://localhost:3306/hr";

        String user="root";
        String password="123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //释放资源
    public  void close()
    {
        try {
            if (rs!=null)
            {
                rs.close();
            }
            if (pstm!=null)
            {
                pstm.close();
            }
            if (conn!=null)
            {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
