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
    <title>员工管理</title>
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
    <caption>员工管理</caption>
    <tr>
      <th colspan="8">
        <a href="emp/add.jsp">添加</a>
      </th>
    </tr>
    <tr>
      <th>员工编号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>爱好</th>
      <th>所属部门</th>
      <th colspan="2">操作</th>
    </tr>

    <c:forEach items="${emps}" var="emp">
      <tr>
        <td>${emp.eid}</td>
        <td>${emp.ename}</td>
        <td>${emp.esex}</td>
        <td>${emp.eage}</td>
        <td>${emp.ehobby}</td>
        <td>${emp.dept.dname}</td>
        <td>
          <a href="EmpServlet?method=getOne&eid=${emp.eid}">修改</a>
        </td>
        <td>
          <a href="EmpServlet?method=delete&eid=${emp.eid}">删除</a>
        </td>
      </tr>
    </c:forEach>
      <tr>
          <td colspan="8">
              <a href="index.jsp">返回</a>
          </td>
      </tr>
  </table>
  </body>
</html>
