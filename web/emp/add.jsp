<%--
  Created by IntelliJ IDEA.
  User: wanglin
  Date: 2019/9/25
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加员工</title>
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
    <script src="/JavaWeb01/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $.post("EmpServlet?method=jsonList", function(data) {

                console.log(data)
                for ( var i = 0; i < data.length; i++) {
                    var did = data[i].did;
                    var dname = data[i].dname;
                    $("select").append("<option value='" + did + "'>" + dname + "</option>");
                }
            }, "json");
        });
    </script>
</head>
<body>
<form action="/JavaWeb01/EmpServlet?method=add" method="post">
    <table>
        <caption>添加员工</caption>
        <tr>
            <td>员工姓名</td>
            <td>
                <input type="text" name="ename"  />
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
               男 <input type="radio" name="esex" value="男"  />
                女 <input type="radio" name="esex" value="女"  />
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="eage"  />
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                喝酒 <input type="checkbox" name="ehobby"  value="喝酒"  />
                杀人<input type="checkbox" name="ehobby"  value="杀人"  />
                做饭<input type="checkbox" name="ehobby"  value="做饭"  />
                跳舞<input type="checkbox" name="ehobby"  value="跳舞"  />
            </td>
        </tr>
        <tr>
            <td>所属部门</td>
            <td>
                <select name="did">
                <c:forEach items="${depts}" var="dept">
                    <option value="${dept.did}">${dept.dname}</option>
                </c:forEach>
                </select>
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
