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
    <% List<Teacher> allTeacher =(List<Teacher>) request.getAttribute("allTeacher");
      for(Teacher teacher:allTeacher){
    %>
    <div class="col-lg-3">
      <div class="row">
        <div class="col-sm-5">
          <img src="<%=teacher.getPhotoUrl() %>" class="img-circle" width=100 height=100>
        </div>
        <div clss="col-sm-7">
          <p>姓名：<%=teacher.getName()%></p>
          <p>成就：<%=teacher.getAchievement()%></p>
          <p>文件：<%=teacher.getProfile()%></p>
        </div>
      </div>

    </div>
    <% } %>
  </div>
</div>
</body>
</html>
