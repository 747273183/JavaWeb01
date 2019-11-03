<%--
  Created by IntelliJ IDEA.
  User: wanglin
  Date: 2019/9/24
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>部门管理</title>
    <style type="text/css">
      table{
        width: 500px;
        margin: 0 auto;
        text-align: center;
      }
      table ,td,th{
        border: 1px solid red;
        border-collapse: collapse;
      }
      caption{
       font-size: 30px;
        margin-bottom: 10px;
      }
    </style>
  </head>
  <body>
  <table>
    <caption>部门管理</caption>
    <tr>
      <th colspan="4">
        <a href="dept/add.jsp">添加</a>
      </th>
    </tr>
    <tr>
      <th>部门编号</th>
      <th>部门名称</th>
      <th colspan="2">操作</th>
    </tr>

    <c:forEach items="${depts}" var="dept">
      <tr>
        <td>${dept.did}</td>
        <td>${dept.dname}</td>
        <td>
          <a href="DeptServlet?method=getOne&did=${dept.did}">修改</a>
        </td>
        <td>
          <a href="DeptServlet?method=delete&did=${dept.did}">删除</a>
        </td>
      </tr>
    </c:forEach>
    <tr>
      <td colspan="4">
        <a href="index.jsp">返回</a>
      </td>
    </tr>
  </table>
  </body>
</html>
