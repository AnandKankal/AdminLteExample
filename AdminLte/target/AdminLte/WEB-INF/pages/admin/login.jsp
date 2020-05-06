
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="formjstl"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>JavaByKiran | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    
    <link href='<spring:url value="/resources/css/AdminLTE.css"/>' rel="stylesheet" />
    
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"/>'>
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
   
    <!-- Theme style -->
    <link rel="stylesheet" href='<spring:url value="/resources/css/AdminLTE.min.css"/>'>
    <!-- iCheck -->
    <link rel="stylesheet" href='<spring:url value="/resources/plugins/iCheck/square/blue.css"/>'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- let's add tag srping:url -->
<!--<spring:url value="/resources/AdminLTE.css" var="adminLTEcss" />-->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!--  <link href="${adminLTEcss}" rel="stylesheet" />-->

<!-- Finish adding tags -->
    
  </head>
  <body class="hold-transition login-page">
    
    <div class="login-box">
    <center>
        <img src="<spring:url value="/resources/images/jbk.png"/>" height="150px">
    </center>  
      <div class="login-logo">
        <a href="#"><b>Java By Kiran</b><h4>JAVA | SELENIUM | PYTHON</h4></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        
        <form id="form" action="login" method="post">
        <% String msg = (String)request.getAttribute("msg"); %>
        	<div  style="color:green;" id="msg"><%= (msg != null ? msg : "")  %></div>
          <div class="form-group has-feedback">
            <input type="text" id="email" name="username" class="form-control" placeholder="Email">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            <div id="email_error" style="color:red;"></div>
          </div>
          <div class="form-group has-feedback">
            <input type="password" id="password" name="password" class="form-control" placeholder="Password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            <div id="password_error" style="color:red;"></div>
          </div>
          <div class="row">
            
            <div class="col-xs-12">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
            </div><!-- /.col -->
          </div>
        </form>


        <br>
        <a href="register" class="text-center">Register a new membership</a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="<spring:url value="/resources/plugins/jQuery/jQuery-2.1.4.min.js"/>"></script>
    <!-- <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script> -->
    <!-- Bootstrap 3.3.5 -->
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
    <!--  <script src="bootstrap/js/bootstrap.min.js"></script>-->
    <!-- iCheck -->
    <script src="<spring:url value="/resources/plugins/iCheck/icheck.min.js"/>"></script>
    <!--  <script src="plugins/iCheck/icheck.min.js"></script>-->
    <script>
    setTimeout(function() {
        $('#msg').fadeOut('slow');
    }, 1000); // <-- time in milliseconds
    
    
    
      $("#form").submit(function(){
        var email = $("#email").val();
        var password = $("#password").val();

        if(email=='' && password==''){
          $("#email_error").text("Please enter email.");
          $("#password_error").text("Please enter password.");
          return false;
        }

        if(email!='' && password==''){
          if(!validateEmail(email)){
            $("#email_error").text("Please enter valid email.");
          }
          
          $("#password_error").text("Please enter password.");

          return false;
        }

        if(email=='' && password!=''){
          

          $("#email_error").text("Please enter email");
          return false;
        }

        var bol = true;
		return true;
        });

      $(function () {
       /* $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });*/
      });

      function validateEmail($email) {
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return emailReg.test( $email );
      }
    </script>
  </body>
</html>
