<%@ page import="com.xmc.entity.Student" %>
<%@ page import="java.util.List" %>
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
    <% List<Student> allStudent =(List<Student>) request.getAttribute("allStudent");
      for(Student student:allStudent){
    %>
    <div class="col-lg-3">
      <div class="row">
        <div class="col-sm-5">
          <img src="<%=student.getPhotoUrl() %>" class="img-circle" width=100 height=100>
        </div>
        <div clss="col-sm-7">
          <p>姓名：<%=student.getName()%></p>
          <p>高中：<%=student.getSchool()%></p>
          <p>年级：<%=student.getGrade()%></p>
          <p>成就：<%=student.getAchievement()%></p>
        </div>
      </div>

    </div>
    <% } %>
  </div>
</div>
</body>
</html>
