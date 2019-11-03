package com.servlet;

import com.dao.DeptDao;
import com.google.gson.Gson;
import com.pojo.Dept;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class DeptServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        //获得请求方法
        String method = request.getParameter("method");
        DeptDao deptDao=new DeptDao();
        //根据请求方法处理并响应
        if ("list".equals(method))
        {
            //查询数据
            List<Dept> depts = deptDao.list();
            //把数据保存在session中
            request.getSession().setAttribute("depts",depts);
            //转发
            request.getRequestDispatcher("/dept/list.jsp").forward(request,response);
        }

        else if ("add".equals(method))
        {
            String dname = request.getParameter("dname");
            Dept dept =new Dept();
            dept.setDname(dname);
            deptDao.add(dept);
            //转发
            request.getRequestDispatcher("DeptServlet?method=list").forward(request,response);
        }
        else if ("delete".equals(method))
        {
            String did = request.getParameter("did");
            deptDao.delete(Integer.parseInt(did));
            //转发
            request.getRequestDispatcher("DeptServlet?method=list").forward(request,response);
        }
        else if("getOne".equals(method))
        {
            String did = request.getParameter("did");
            Dept dept = deptDao.getOne(Integer.parseInt(did));
            //把数据保存在session中
            request.getSession().setAttribute("dept",dept);
            //转发
            request.getRequestDispatcher("/dept/update.jsp").forward(request,response);
        }
        else if("update".equals(method))
        {
            String did = request.getParameter("did");
            String dname=request.getParameter("dname");
            Dept dept =new Dept();
            dept.setDid(Integer.parseInt(did));
            dept.setDname(dname);
            deptDao.update(dept);
            //转发
            request.getRequestDispatcher("DeptServlet?method=list").forward(request,response);
        }
    }
}
