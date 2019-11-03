package com.dao;

import com.pojo.Dept;
import com.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDao extends BaseDao{

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Statement st;

    public void update(Emp emp)
    {
        conn = getConn();
        try {
            pstm = conn.prepareStatement("update  emp set ename=?,esex=?,eage=?,ehobby=?,did=? where eid=?");
            pstm.setString(1,emp.getEname());
            pstm.setString(2,emp.getEsex());
            pstm.setInt(3,emp.getEage());
            pstm.setString(4,emp.getEhobby());
            pstm.setInt(5,emp.getDept().getDid());
            pstm.setInt(6,emp.getEid());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    public Emp getOne(int eid)
    {
        Emp emp=new Emp();
        conn = getConn();
        try {
           pstm = conn.prepareStatement("select * from emp where eid=?");
           pstm.setInt(1,eid);
            rs = pstm.executeQuery();
            while (rs!=null && rs.next())
           {
               String ename = rs.getString(2);
               String esex = rs.getString(3);
               int eage=rs.getInt(4);
               String ehobby = rs.getString(5);
               int did=rs.getInt(6);

               emp.setEid(eid);
               emp.setEname(ename);
               emp.setEsex(esex);
               emp.setEage(eage);
               emp.setEhobby(ehobby);

               DeptDao deptDao=new DeptDao();
               Dept dept = deptDao.getOne(did);

               emp.setDept(dept);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return emp;
    }

    public void delete(int eid)
    {
        conn = getConn();
        try {
            pstm = conn.prepareStatement("delete  from emp where eid=?");
            pstm.setInt(1,eid);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }

    }

    //添加
    public void add(Emp emp)
    {
        conn = getConn();
        try {
            pstm = conn.prepareStatement("insert into emp values(null,?,?,?,?,?)");
            pstm.setString(1,emp.getEname());
            pstm.setString(2,emp.getEsex());
            pstm.setInt(3,emp.getEage());
            pstm.setString(4,emp.getEhobby());
            pstm.setInt(5,emp.getDept().getDid());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    //全查询
    public  List<Emp> list()
    {
        List<Emp> emps=new ArrayList<>();
        conn = getConn();
        try {
            pstm = conn.prepareStatement("select eid,ename,esex,eage,ehobby,d.did,d.dname from emp e,dept d where e.did=d.did");
            rs = pstm.executeQuery();
            while (rs!=null && rs.next())
            {
                int eid = rs.getInt(1);
                String ename = rs.getString(2);
                String esex = rs.getString(3);
                int eage=rs.getInt(4);
                String ehobby = rs.getString(5);
                int did=rs.getInt(6);
                String dname=rs.getString(7);



                Dept dept =new Dept(did,dname);

                Emp emp =new Emp(eid,ename,esex,eage,ehobby,dept);
                emps.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return emps;
    }
}
