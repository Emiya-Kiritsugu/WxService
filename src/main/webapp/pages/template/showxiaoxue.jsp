<%@ page import="com.xmc.entity.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/6/8
  Time: 下午4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <!-- start: Meta -->
  <title>孺子牛家教网</title>
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
  <style>
    div.box-content>ul.dashboard-list{
      background-color: hsla(0,0%,90%,1);
    }
    div.box-content>ul.dashboard-list>li.mylist{
      padding:5px;
      border: 10px solid hsla(0,0%,100%,1);
    }
    div.box-content>ul.dashboard-list>li.mylist>span.myspan{
      word-break: break-all;
    }
  </style>



</head>
<body class="mybody">
<div class="container-fluid-full">
  <div class="box span4" onTablet="span6" onDesktop="span4">
    <div class="box-header">
      <h2><i class="halflings-icon user"></i><span class="break"></span>小学课程</h2>
      <div class="box-icon">
        <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
        <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
      </div>
    </div>
    <div class="box-content">
      <div id="image-7" class="masonry-thumb">
        <a style="background:url(/staticSource/upload/xiaoxue.png)" title="Sample Image 7" href="/staticSource/upload/xiaoxue.png"><img class="grayscale" src="/staticSource/upload/xiaoxue.png" alt="Sample Image 7"></a>
      </div>
    </div>
  </div><!--/span-->
</div>
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
</body>
</html>

