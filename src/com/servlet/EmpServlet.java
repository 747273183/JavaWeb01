package com.servlet;

import com.dao.DeptDao;
import com.dao.EmpDao;
import com.google.gson.Gson;
import com.pojo.Dept;
import com.pojo.Emp;
import com.sun.deploy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


public class EmpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        //获得请求方法
        String method = request.getParameter("method");
        EmpDao empDao=new  EmpDao();
        DeptDao deptDao=new DeptDao();

        if ("list".equals(method))
        {
            List<Emp> emps = empDao.list();
            request.getSession().setAttribute("emps",emps);
            request.getRequestDispatcher("/emp/list.jsp").forward(request,response);
        }
        else if ("getOne".equals(method))
        {
            String eid = request.getParameter("eid");
            Emp emp = empDao.getOne(Integer.parseInt(eid));
            request.getSession().setAttribute("emp",emp);
            request.getRequestDispatcher("/emp/update.jsp").forward(request,response);
        }
        else if ("jsonList".equals(method))
        {
            //查询数据
            List<Dept> depts = deptDao.list();
            //把数据转换成json字符串
            Gson gson=new Gson();
            String json = gson.toJson(depts);
            out.println(json);
            out.flush();
            out.close();

        }
        else if ("add".equals(method))
        {
            String ename = request.getParameter("ename");
            String esex = request.getParameter("esex");
            String eage = request.getParameter("eage");
            String[] ehobbies = request.getParameterValues("ehobby");
            String ehobby = StringUtils.join(Arrays.asList(ehobbies), ",");
            String did = request.getParameter("did");

            Dept dept=deptDao.getOne(Integer.parseInt(did));
            Emp emp=new Emp(null,ename,esex,Integer.parseInt(eage),ehobby,dept);

            empDao.add(emp);
        }
        else if ("update".equals(method))
        {
            String eid = request.getParameter("eid");
            String ename = request.getParameter("ename");
            String esex = request.getParameter("esex");
            String eage = request.getParameter("eage");
            String[] ehobbies = request.getParameterValues("ehobby");
            String ehobby = StringUtils.join(Arrays.asList(ehobbies), ",");
            String did = request.getParameter("did");

            Dept dept=deptDao.getOne(Integer.parseInt(did));
            Emp emp=new Emp(Integer.parseInt(eid),ename,esex,Integer.parseInt(eage),ehobby,dept);

            empDao.update(emp);
        }
        else if ("delete".equals(method))
        {
            String eid = request.getParameter("eid");
            empDao.delete(Integer.parseInt(eid));
        }
    }


}
