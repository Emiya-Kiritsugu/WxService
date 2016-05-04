<%@ page import="java.util.List" %>
<%@ page import="com.xmc.entity.Teacher" %>
<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/4/19
  Time: 上午1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title><%=request.getAttribute("title") %></title>
  <link href="/staticSource/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="/staticSource/css/style.css">
  <link rel="stylesheet" href="/staticSource/css/jquery.fileupload.css">
</head>
<body>
<div class="container">
  <div class="row">

    <div class="row">
      <div class="col-lg-12">
        <% List<Teacher> allTeacher2 =(List<Teacher>) request.getAttribute("allTeacher");
          for(Teacher teacher:allTeacher2){
        %>

        <table class="table text-left table-condensed">
          <tbody class="text-left">
          <tr>
            <td><img src="<%=teacher.getPhotoUrl() %>" class="img-circle" width=100 height=100></td>
            <td>
              <table class="table">
                <tr><td>姓名：<%=teacher.getName()%></td></tr>
                <tr><td>成就：<%=teacher.getAchievement()%></td></tr>
                <tr><td>文件：<%=teacher.getProfile()%></td></tr>
              </table>
            </td>
          </tr>

          </tbody>
        </table>

        <% } %>
      </div>
    </div>
  </div>
</div>
</body>
</html>
