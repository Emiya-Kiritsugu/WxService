<%@ page import="com.xmc.entity.Video" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/5/4
  Time: 下午4:50
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
  <title>查看视频</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <% List<Video> allVideo =(List<Video>) request.getAttribute("allVideo");
          for(Video video:allVideo){
        %>
        <div class="table-responsive">
          <table class="table table-responsive table-bordered ">
            <tbody>
              <tr>
                <td colspan="2"><a href="<%=video.getUrl() %>"><%=video.getName()%></a></td>
              </tr>
              <tr>
                <td>年级：</td><td><%=video.getGrade()%></td>
              </tr>
            <tr>
              <td>描述：</td><td><%=video.getDescription()%></td>
            </tr>
            </tbody>
          </table>
        </div>
        <% }%>
      </div>
    </div>
  </div>
</body>
</html>
