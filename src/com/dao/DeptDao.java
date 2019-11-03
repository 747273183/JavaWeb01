package com.dao;

import com.pojo.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDao extends BaseDao{

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Statement st;

    public void update(Dept dept)
    {
        conn = getConn();
        try {
            pstm = conn.prepareStatement("update  dept set dname=? where did=?");
            pstm.setString(1,dept.getDname());
            pstm.setInt(2,dept.getDid());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    public Dept getOne(int did)
    {
        Dept dept=new Dept();
        conn = getConn();
        try {
           pstm = conn.prepareStatement("select * from dept where did=?");
           pstm.setInt(1,did);
           rs = pstm.executeQuery();
           while (rs!=null && rs.next())
           {
               String dname = rs.getString(2);
               dept.setDid(did);
               dept.setDname(dname);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return dept;
    }

    public void delete(int did)
    {
        conn = getConn();
        try {
            pstm = conn.prepareStatement("delete  from dept where did=?");
            pstm.setInt(1,did);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

    }

    //添加
    public void add(Dept dept)
    {
        conn = getConn();
        try {
            pstm = conn.prepareStatement("insert into dept values(null,?)");
            pstm.setString(1,dept.getDname());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    //全查询
    public  List<Dept> list()
    {
        List<Dept> depts=new ArrayList<>();
        conn = getConn();
        try {
            pstm = conn.prepareStatement("select * from dept");
            rs = pstm.executeQuery();
            while (rs!=null && rs.next())
            {
                int did = rs.getInt(1);
                String dname = rs.getString(2);
                Dept dept =new Dept(did,dname);
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return depts;
    }
}
