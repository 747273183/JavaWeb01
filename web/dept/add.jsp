<%--
  Created by IntelliJ IDEA.
  User: wanglin
  Date: 2019/9/25
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
    <style type="text/css">
        table{
            width: 300px;
            margin: 0 auto;
            text-align: center;
        }
        table,td,th{
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
<form action="/JavaWeb01/DeptServlet?method=add" method="post">
    <table>
        <caption>添加部门</caption>
        <tr>
            <td>部门名称</td>
            <td>
                <input type="text" name="dname"  />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"  />

            </td>
        </tr>

    </table>

</form>
</body>
</html>
