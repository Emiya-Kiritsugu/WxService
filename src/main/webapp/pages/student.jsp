<%@ page import="java.util.List" %>
<%@ page import="com.xmc.entity.Teacher" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="com.xmc.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/4/11
  Time: 上午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8"%>
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
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="javascript:void(0)">Brand</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li ><a href="#">主页 <span class="sr-only">(current)</span></a></li>
          <li class="active"><a href="/view/allstudent">管理学生</a></li>
          <li ><a href="/view/allteacher">管理老师</a></li>
        </ul>
        <form class="navbar-form navbar-left" role="search">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">Link</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">Separated link</a></li>
            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>

  <div class="table-responsive">
    <table class="table">
      <thead>
      <tr>
        <th>学生编号</th>
        <th>学生姓名</th>
        <th>年级</th>
        <th>学校</th>
        <th>成就</th>
        <th>修改</th>
        <th>删除</th>
      </tr>
      </thead>
      <tbody>
      <%
        List<Student> allStudent =(List<Student>) request.getAttribute("allStudent");
        if(!allStudent.isEmpty()){
          for(Student student:allStudent){
            out.println("<tr id=\""+student.getStuNo()+"\">");
            out.println("<td>" + student.getStuNo() + "</td>");
            out.println("<td>" + student.getName() + "</td>");
            out.println("<td>" + student.getGrade() + "</td>");
            out.println("<td>" + student.getSchool() + "</td>");
            out.println("<td>" + student.getAchievement() + "</td>");
            out.println("<td><a data-toggle=\"modal\" data-target=\"#updateModal\" href=\"javascript:void(0)\" onclick=update("+student.getStuNo()+")><span class=\"glyphicon glyphicon-wrench\"></span></a></td>");
            out.println("<td><a data-toggle=\"modal\" data-target=\"#deleteModal\" href=\"javascript:void(0)\" onclick=deleteStu("+student.getStuNo()+")><span class=\"glyphicon glyphicon-remove\"></span></a></td>");
            out.println("</tr>");
          }
        }else{
          out.println("<tr>");
          out.println("<td>" + "/" + "</td>");
          out.println("<td>" + "/" + "</td>");
          out.println("<td>" + "/" + "</td>");
          out.println("<td>" + "/" + "</td>");
          out.println("<td>" + "/" + "</td>");
          out.println("<td>" + "/" + "</td>");
          out.println("<td>" + "/" + "</td>");
          out.println("<td>" + "/" + "</td>");
          out.println("</tr>");
        }
      %>
      <tr>
        <td colspan="7"><button class="btn btn-default" data-toggle="modal" data-target="#updateModal" onclick="add()">添加</button></td>
      </tr>
      </tbody>
    </table>
  </div>
</div>
<img src="/staticSource/upload/1460998755648test.png"/>

<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">更新学生信息</h4>
      </div>
      <div class="modal-body">
        <form id="updateStudent" action="/view/updatestudent" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="studentNo" class="col-sm-2 control-label">StudentNo</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="studentNo" name="studentNo" value="0">
            </div>
          </div>
          <div class="form-group">
            <label for="studentName" class="col-sm-2 control-label">StudentName</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="studentName" name="name">
            </div>
          </div>
          <div id="sexbox" class="form-group">
            <div class="col-sm-2"></div>
              <label>
                <input type="radio" name="sex" id="sex1" value="true" checked>
                男
              </label>
              <label>
                <input type="radio" name="sex" id="sex2" value="false">
                女
              </label>
          </div>
          <div class="form-group">
            <label for="grade" class="col-sm-2 control-label">StudentGrade</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="grade" name="grade">
            </div>
          </div>
          <div class="form-group">
            <label for="school" class="col-sm-2 control-label">school</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="school" name="school">
            </div>
          </div>
          <div class="form-group">
            <label for="achieve" class="col-sm-2 control-label">Achievement</label>
            <div class="col-sm-10">
              <textarea class="form-control" rows="3" id="achieve" name="achieve"></textarea>
            </div>
          </div>
          <div class="form-group">
            <label for="achieve" class="col-sm-2 control-label">Achievement</label>
            <div class="col-sm-10">
              <input type="file" name="studentPhoto" enctype="multipart/form-data"/>
            </div>
          </div>
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </form>

      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
<!-- js资源 -->
<script src="/staticSource/jquery-1.12.3.min.js"></script>
<script src="/staticSource/js/bootstrap.min.js"></script>
<script src="/staticSource/student.js"></script>
<script src="/staticSource/js/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/staticSource/js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="/staticSource/js/jquery.fileupload.js"></script>
<script>
  /*jslint unparam: true */
  /*global window, $ */
  $(function () {
    'use strict';
    // Change this to the location of your server-side upload handler:
    var url = "/view/uploadPic";
    $('#fileupload').fileupload({
      url: url,
      dataType: 'json',
      done: function (e, data) {
        $.each(data.result.files, function (index, file) {
          $('<p/>').text(file.name).appendTo('#files');
        });
      },
      progressall: function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#progress .progress-bar').css(
                'width',
                progress + '%'
        );
      }
    }).prop('disabled', !$.support.fileInput)
            .parent().addClass($.support.fileInput ? undefined : 'disabled');
  });
</script>
</body>
</html>
