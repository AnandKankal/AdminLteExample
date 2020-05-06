<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="formjstl"%>
<%@page import="com.javabykiran.model.Users"%>
<%@ include file="prevent.jsp" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>JavaByKiran | Dashboard</title>
    
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    
    
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"/>'>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href='<spring:url value="/resources/css/AdminLTE.min.css"/>'>
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
     <link href='<spring:url value="/resources/dist/css/skins/_all-skins.min.css"/>' rel="stylesheet" />
    
  </head>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
      <header class="main-header">
        <!-- Logo -->
        <a href="dashboard" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>JBK</b></span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>Java By Kiran</b></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="logout" class="">LOGOUT</a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="<spring:url value="/resources/dist/img/user2-160x160.jpg"/>" class="img-circle" alt="User Image">
            </div>
            <%
            

            
            String msg = (String)request.getAttribute("msg");
            	
            %>
            <div class="pull-left info">
              <p><%
              session.getAttribute("username");
              out.println(session.getAttribute("username")); %></p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview"><a href="dashboard">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
            <li><a href="showUserList"><i class="fa fa-user"></i> <span>Users</span></a></li>
            <li><a href="operators"><i class="fa fa-retweet"></i> <span>Operators</span></a></li>
            <li class="treeview"><a href="links"><i class="fa fa-external-link"></i> <span>     Useful Links</span></a></li>
            <li class="treeview"><a href="downloads">
            <i class="fa fa-download"></i> <span>Downloads</span></a></li>
            <li><a href="logout"><i class="fa fa-power-off"></i> <span>Logout</span></a></li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Dashboard
            <small>Courses Offered</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
          </ol>
        </section>
        <div style="color:green;" id="msg"><%= (msg != null ? msg : "")  %></div>

        <!-- Main content -->
        <section class="content">
          <!-- Small boxes (Stat box) -->
          <div class="row">
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-aqua">
                <div class="inner">
                  <h3>Selenium</h3>
                  <p>Automation Testing</p>
                </div>
                <div class="icon">
                  <i class="ion ion-bag"></i>
                </div>
                <a href="<spring:url value="/resources/pdf/selenium-testing-syllabus-jbk.pdf"/>" class="small-box-footer" target="_blank">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                  <h3>Java / J2EE</h3>
                  <p>Software Development</p>
                </div>
                <div class="icon">
                  <i class="ion ion-stats-bars"></i>
                </div>
                <a href="<spring:url value="/resources/pdf/java-j2ee-syllabus-jbk.pdf"/>" class="small-box-footer" target="_blank">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-yellow">
                <div class="inner">
                  <h3>Python</h3>
                  <p>Data Science</p>
                </div>
                <div class="icon">
                  <i class="ion ion-person-add"></i>
                </div>
                <a href="<spring:url value="/resources/pdf/python-syllabus.pdf"/>" class="small-box-footer" target="_blank">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-red">
                <div class="inner">
                  <h3>Php</h3>
                  <p>Web Development</p>
                </div>
                <div class="icon">
                  <i class="ion ion-pie-graph"></i>
                </div>
                <a href="dashboard" class="small-box-footer" target="_blank">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
          </div><!-- /.row -->
           

        </section><!-- /.content -->

      </div><!-- /.content-wrapper -->
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Design for Selenium Automation Test</b> V 2.3.0
        </div>
        <strong>Copyright &copy; 
        <script>
            var CurrentYear = new Date().getFullYear()
            var pastYear = new Date().getFullYear()-1
            document.write(pastYear+"-"+CurrentYear)
        </script> <a href="https://www.javabykiran.com/" target="_blank">JavaByKiran</a>.</strong> All rights reserved.
      </footer>

     
     
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class="control-sidebar-bg"></div>
    </div><!-- ./wrapper -->



    <!-- jQuery 2.1.4 -->
    <script src="<spring:url value="/resources/plugins/jQuery/jQuery-2.1.4.min.js"/>"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.5 -->
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
    <!-- Morris.js charts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="<spring:url value="/resources/plugins/morris/morris.min.js"/>"></script>
    <!-- Sparkline -->
    <script src="<spring:url value="/resources/plugins/sparkline/jquery.sparkline.min.js"/>"></script>
    <!-- jvectormap -->
    <script src="<spring:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"></script>
    <script src="<spring:url value="/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>"></script>
    <!-- jQuery Knob Chart -->
    <script src="<spring:url value="/resources/plugins/knob/jquery.knob.js"/>"></script>
    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script src="<spring:url value="/resources/plugins/daterangepicker/daterangepicker.js"/>"></script>
    <!-- datepicker -->
    <script src="<spring:url value="/resources/plugins/datepicker/bootstrap-datepicker.js"/>"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<spring:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"></script>
    <!-- Slimscroll -->
    <script src="<spring:url value="/resources/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
    <!-- FastClick -->
    <script src="<spring:url value="/resources/plugins/fastclick/fastclick.min.js"/>"></script>
    <!-- AdminLTE App -->
    <script src="<spring:url value="/resources/dist/js/app.min.js"/>"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<spring:url value="/resources/dist/js/pages/dashboard.js"/>"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<spring:url value="/resources/dist/js/demo.js"/>"></script>
  </body>
  <script type="text/javascript">
  setTimeout(function() {
      $('#msg').fadeOut('slow');
  }, 1000); // <-- time in milliseconds
  </script>
  
</html>
