<%@ page import="java.util.List" %>
<%@ page import="com.xmc.entity.Teacher" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="com.xmc.entity.Video" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.TreeMap" %>
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
          <li ><a href="/view/allstudent">学生风采</a></li>
          <li ><a href="/view/allteacher">老师风采</a></li>
          <li class="active"><a href="/view/allVideo?grade=JUNIOR_THREE">课程列表</a></li>
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

  <div class="row">
    <div class="col-lg-12">
      <div>

        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="<%=(String)request.getAttribute("JUNIOR_THREE")%>"><a href="/view/allVideo?grade=JUNIOR_THREE">一年级</a></li>
          <li role="presentation" class="<%=(String)request.getAttribute("SENIOR_ONE")%>"><a href="/view/allVideo?grade=SENIOR_ONE">二年级</a></li>
          <li role="presentation" class="<%=(String)request.getAttribute("SENIOR_TWO")%>"><a href="/view/allVideo?grade=SENIOR_TWO">三年级</a></li>
          <li role="presentation" class="<%=(String)request.getAttribute("SENIOR_THREE")%>"><a href="/view/allVideo?grade=SENIOR_THREE">四年级</a></li>
          <li role="presentation" class="<%=(String)request.getAttribute("OTHERS")%>"><a href="/view/allVideo?grade=OTHERS">其他</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
          <div role="tabpanel" class="tab-pane active" id="grade1">
            <div class="table-responsive">
              <table class="table table-condensed">
                <thead>
                  <tr>
                    <th>课程</th>
                    <th style="text-align: center">视频</th>
                  </tr>
                </thead>
                <tbody>
                <%
                  Map<String,List<Video>> videoMap = (Map<String,List<Video>>)request.getAttribute("allVideo");
                  for(Map.Entry<String,List<Video>> entry:videoMap.entrySet()){
                %>
                  <tr>
                    <td>
                      <%=entry.getKey()%>
                    </td>
                    <td style="text-align: center">

                        <table class="table table-bordered" >
                          <thead>
                            <tr >
                              <th style="text-align: center">视频名称</th>
                              <th style="text-align: center">视频描述</th>
                              <th style="text-align: center">删除</th>
                            </tr>
                          </thead>
                          <tbody>
                          <%for(Video v:entry.getValue()){%>
                            <tr>
                              <td style="text-align: center"><a href="<%=v.getUrl()%>"><%=v.getName()%></a></td>
                              <td style="text-align: center"><%=v.getDescription()%></td>
                              <td style="text-align: center"><button class="btn btn-danger" _fun="delete" _video="<%=v.getId()%>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                            </tr>
                          <%}%>
                            <tr>
                              <td colspan="3" style="text-align: center"><button class="btn btn-primary" _fun="add"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button></td>
                            </tr>
                          </tbody>
                        </table>
                    </td>
                  </tr>
                <%}%>
                </tbody>

              </table>
            </div>
          </div>
          <div role="tabpanel" class="tab-pane" id="grade2">...</div>
          <div role="tabpanel" class="tab-pane" id="grade3">...</div>
          <div role="tabpanel" class="tab-pane" id="grade4">...</div>
          <div role="tabpanel" class="tab-pane" id="other">...</div>
        </div>

      </div>
    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">更新老师信息</h4>
      </div>
      <div class="modal-body">
        <form id="updateTeacher" action="/view/updateteacher" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="teacherNo" class="col-sm-2 control-label">TeacherNo</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="teacherNo" name="teachNo">
            </div>
          </div>
          <div class="form-group">
            <label for="teacherName" class="col-sm-2 control-label">TeacherName</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="teacherName" name="name">
            </div>
          </div>
          <div class="form-group">
            <label for="profile" class="col-sm-2 control-label">Profile</label>
            <div class="col-sm-10">
              <textarea class="form-control" rows="3" id="profile" name="profile"></textarea>
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
              <input type="file" name="teacherPhoto" enctype="multipart/form-data"/>
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

<div class="modal fade" id="addvideo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel2">更新老师信息</h4>
      </div>
      <div class="modal-body">
        <form id="addvideoform" action="/view/addvideo" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="name" name="name">
            </div>
          </div>
          <div class="form-group">
            <label for="grade" class="col-sm-2 control-label">Grade</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="grade" name="grade">
            </div>
          </div>
          <div class="form-group">
            <label for="desc" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-10">
              <textarea class="form-control" rows="3" id="desc" name="desc"></textarea>
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-10">
              <input type="file" name="video" enctype="multipart/form-data"/>
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
<script src="/staticSource/js/handlebars-v4.0.5.js"></script>
<script src="/staticSource/teacher.js"></script>
</body>
</html>
