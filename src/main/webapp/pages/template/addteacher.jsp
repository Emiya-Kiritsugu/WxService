<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/6/8
  Time: 下午3:56
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/6/8
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ page import="com.xmc.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/6/7
  Time: 下午11:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- start: Meta -->
  <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
  <meta name="description" content="Bootstrap Metro Dashboard">
  <meta name="author" content="Dennis Ji">
  <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <!-- end: Meta -->

  <!-- start: Mobile Specific -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- end: Mobile Specific -->

  <!-- start: CSS -->
  <link id="bootstrap-style" href="/staticSource/css/bootstrap.min.css" rel="stylesheet">
  <link href="/staticSource/css/bootstrap-responsive.min.css" rel="stylesheet">
  <link id="base-style" href="/staticSource/css/style.css" rel="stylesheet">
  <link id="base-style-responsive" href="/staticSource/css/style-responsive.css" rel="stylesheet">
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
  <!-- end: CSS -->


  <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <link id="ie-style" href="/staticSource/css/ie.css" rel="stylesheet">
  <![endif]-->

  <!--[if IE 9]>
  <link id="ie9style" href="/staticSource/css/ie9.css" rel="stylesheet">
  <![endif]-->

  <!-- start: Favicon -->
  <link rel="shortcut icon" href="/staticSource/img/favicon.ico">
  <!-- end: Favicon -->




</head>

<body>
<!-- start: Header -->
<div class="navbar">
  <div class="navbar-inner">
    <div class="container-fluid">
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <a class="brand" href="index.html"><span>Metro</span></a>

      <!-- start: Header Menu -->
      <div class="nav-no-collapse header-nav">
        <ul class="nav pull-right">
          <li class="dropdown hidden-phone">
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="halflings-icon white warning-sign"></i>
            </a>
            <ul class="dropdown-menu notifications">
              <li class="dropdown-menu-title">
                <span>You have 11 notifications</span>
                <a href="#refresh"><i class="icon-repeat"></i></a>
              </li>
              <li>
                <a href="#">
                  <span class="icon blue"><i class="icon-user"></i></span>
                  <span class="message">New user registration</span>
                  <span class="time">1 min</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="icon green"><i class="icon-comment-alt"></i></span>
                  <span class="message">New comment</span>
                  <span class="time">7 min</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="icon green"><i class="icon-comment-alt"></i></span>
                  <span class="message">New comment</span>
                  <span class="time">8 min</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="icon green"><i class="icon-comment-alt"></i></span>
                  <span class="message">New comment</span>
                  <span class="time">16 min</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="icon blue"><i class="icon-user"></i></span>
                  <span class="message">New user registration</span>
                  <span class="time">36 min</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="icon yellow"><i class="icon-shopping-cart"></i></span>
                  <span class="message">2 items sold</span>
                  <span class="time">1 hour</span>
                </a>
              </li>
              <li class="warning">
                <a href="#">
                  <span class="icon red"><i class="icon-user"></i></span>
                  <span class="message">User deleted account</span>
                  <span class="time">2 hour</span>
                </a>
              </li>
              <li class="warning">
                <a href="#">
                  <span class="icon red"><i class="icon-shopping-cart"></i></span>
                  <span class="message">New comment</span>
                  <span class="time">6 hour</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="icon green"><i class="icon-comment-alt"></i></span>
                  <span class="message">New comment</span>
                  <span class="time">yesterday</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="icon blue"><i class="icon-user"></i></span>
                  <span class="message">New user registration</span>
                  <span class="time">yesterday</span>
                </a>
              </li>
              <li class="dropdown-menu-sub-footer">
                <a>View all notifications</a>
              </li>
            </ul>
          </li>
          <!-- start: Notifications Dropdown -->
          <li class="dropdown hidden-phone">
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="halflings-icon white tasks"></i>
            </a>
            <ul class="dropdown-menu tasks">
              <li class="dropdown-menu-title">
                <span>You have 17 tasks in progress</span>
                <a href="#refresh"><i class="icon-repeat"></i></a>
              </li>
              <li>
                <a href="#">
										<span class="header">
											<span class="title">iOS Development</span>
											<span class="percent"></span>
										</span>
                  <div class="taskProgress progressSlim red">80</div>
                </a>
              </li>
              <li>
                <a href="#">
										<span class="header">
											<span class="title">Android Development</span>
											<span class="percent"></span>
										</span>
                  <div class="taskProgress progressSlim green">47</div>
                </a>
              </li>
              <li>
                <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                  <div class="taskProgress progressSlim yellow">32</div>
                </a>
              </li>
              <li>
                <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                  <div class="taskProgress progressSlim greenLight">63</div>
                </a>
              </li>
              <li>
                <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                  <div class="taskProgress progressSlim orange">80</div>
                </a>
              </li>
              <li>
                <a class="dropdown-menu-sub-footer">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- end: Notifications Dropdown -->
          <!-- start: Message Dropdown -->
          <li class="dropdown hidden-phone">
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="halflings-icon white envelope"></i>
            </a>
            <ul class="dropdown-menu messages">
              <li class="dropdown-menu-title">
                <span>You have 9 messages</span>
                <a href="#refresh"><i class="icon-repeat"></i></a>
              </li>
              <li>
                <a href="#">
                  <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	6 min
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	56 min
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	3 hours
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	yesterday
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="avatar"><img src="img/avatar5.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	Jul 25, 2012
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                </a>
              </li>
              <li>
                <a class="dropdown-menu-sub-footer">View all messages</a>
              </li>
            </ul>
          </li>
          <!-- end: Message Dropdown -->
          <li>
            <a class="btn" href="#">
              <i class="halflings-icon white wrench"></i>
            </a>
          </li>
          <!-- start: User Dropdown -->
          <li class="dropdown">
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="halflings-icon white user"></i> Dennis Ji
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li class="dropdown-menu-title">
                <span>Account Settings</span>
              </li>
              <li><a href="#"><i class="halflings-icon user"></i> Profile</a></li>
              <li><a href="login.html"><i class="halflings-icon off"></i> Logout</a></li>
            </ul>
          </li>
          <!-- end: User Dropdown -->
        </ul>
      </div>
      <!-- end: Header Menu -->

    </div>
  </div>
</div>
<!-- start: Header -->

<div class="container-fluid-full">
  <div class="row-fluid">

    <!-- start: Main Menu -->
    <div id="sidebar-left" class="span2">
      <div class="nav-collapse sidebar-nav">
        <ul class="nav nav-tabs nav-stacked main-menu">
          <li><a href="/view/allteacher"><i class="icon-bar-chart"></i><span class="hidden-tablet"> 教师管理</span></a></li>
          <li><a href="/view/allstudent"><i class="icon-envelope"></i><span class="hidden-tablet"> 学生管理</span></a></li>
          <li><a href="/view/managecourse"><i class="icon-envelope"></i><span class="hidden-tablet"> 课程管理</span></a></li>
          <li class="active"><a href="/view/managenotice"><i class="icon-envelope"></i><span class="hidden-tablet"> 公告管理</span></a></li>
        </ul>
      </div>
    </div>
    <!-- end: Main Menu -->

    <noscript>
      <div class="alert alert-block span10">
        <h4 class="alert-heading">Warning!</h4>
        <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
      </div>
    </noscript>

    <!-- start: Content -->
    <div id="content" class="span10">


      <ul class="breadcrumb">
        <li>
          <i class="icon-home"></i>
          <a href="index.html">孺子牛家教网</a>
          <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">教师管理</a><i class="icon-angle-right"></i></li>
        <li><a href="#">教师信息</a></li>
      </ul>

      <div class="row-fluid sortable">
        <div class="box span12">
          <div class="box-header" data-original-title>
            <h2><i class="halflings-icon edit"></i><span class="break"></span>详细信息</h2>
            <div class="box-icon">
              <a href="#" class="btn-setting"><i class="halflings-icon wrench"></i></a>
              <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
              <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
            </div>
          </div>
          <div class="box-content">
            <form class="form-horizontal" action="/view/updateteacher" method="post" enctype="multipart/form-data">
              <fieldset>

                <div class="control-group">
                  <label class="control-label" for="disabledInput">老师ID：</label>
                  <div class="controls">
                    <input class="input-xlarge" readonly id="disabledInput" name="teachNo" type="text" value="">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="focusedInput">老师姓名：</label>
                  <div class="controls">
                    <input class="input-xlarge focused" id="focusedInput" type="text" value="">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="fileInput">选择照片：</label>
                  <div class="controls">
                    <input class="input-file uniform_on" id="fileInput" name="teacherPhoto" type="file" enctype="multipart/form-data">
                  </div>
                </div>
                <div class="control-group success">
                  <label class="control-label" for="inputSuccess">成就：</label>
                  <div class="controls">
                    <input type="text" id="inputSuccess" name="achieve" value="">
                    <span class="help-inline"></span>
                  </div>
                </div>
                <div class="control-group hidden-phone">
                  <label class="control-label" for="textarea2">简介：</label>
                  <div class="controls">
                    <textarea class="cleditor" id="textarea2" name="profile" rows="3"></textarea>
                  </div>
                </div>
                <div class="form-actions">
                  <button type="submit" class="btn btn-primary">添加</button>
                </div>
              </fieldset>
            </form>

          </div>
        </div><!--/span-->

      </div><!--/row-->

    </div><!--/.fluid-container-->

    <!-- end: Content -->
  </div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>
    <h3>Settings</h3>
  </div>
  <div class="modal-body">
    <p>Here settings can be configured...</p>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal">Close</a>
    <a href="#" class="btn btn-primary">Save changes</a>
  </div>
</div>

<div class="clearfix"></div>

<footer>

  <p>
    <span style="text-align:left;float:left">&copy; 2013 <a href="http://jiji262.github.io/Bootstrap_Metro_Dashboard/" alt="Bootstrap_Metro_Dashboard">Bootstrap Metro Dashboard</a></span>

  </p>

</footer>

<!-- start: JavaScript-->
<script src="/staticSource/js/myjs.js"></script>
<script src="/staticSource/js/jquery-1.9.1.min.js"></script>
<script src="/staticSource/js/jquery-migrate-1.0.0.min.js"></script>

<script src="/staticSource/js/jquery-ui-1.10.0.custom.min.js"></script>

<script src="/staticSource/js/jquery.ui.touch-punch.js"></script>

<script src="/staticSource/js/modernizr.js"></script>

<script src="/staticSource/js/bootstrap.min.js"></script>

<script src="/staticSource/js/jquery.cookie.js"></script>

<script src='/staticSource/js/fullcalendar.min.js'></script>

<script src='/staticSource/js/jquery.dataTables.min.js'></script>

<script src="/staticSource/js/excanvas.js"></script>
<script src="/staticSource/js/jquery.flot.js"></script>
<script src="/staticSource/js/jquery.flot.pie.js"></script>
<script src="/staticSource/js/jquery.flot.stack.js"></script>
<script src="/staticSource/js/jquery.flot.resize.min.js"></script>

<script src="/staticSource/js/jquery.chosen.min.js"></script>

<script src="/staticSource/js/jquery.uniform.min.js"></script>

<script src="/staticSource/js/jquery.cleditor.min.js"></script>

<script src="/staticSource/js/jquery.noty.js"></script>

<script src="/staticSource/js/jquery.elfinder.min.js"></script>

<script src="/staticSource/js/jquery.raty.min.js"></script>

<script src="/staticSource/js/jquery.iphone.toggle.js"></script>

<script src="/staticSource/js/jquery.uploadify-3.1.min.js"></script>

<script src="/staticSource/js/jquery.gritter.min.js"></script>

<script src="/staticSource/js/jquery.imagesloaded.js"></script>

<script src="/staticSource/js/jquery.masonry.min.js"></script>

<script src="/staticSource/js/jquery.knob.modified.js"></script>

<script src="/staticSource/js/jquery.sparkline.min.js"></script>

<script src="/staticSource/js/counter.js"></script>

<script src="/staticSource/js/retina.js"></script>

<script src="/staticSource/js/custom.js"></script>
<!-- end: JavaScript-->

</body>
</html>


