<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script type="text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};

</script> 

<%
String username = (String)request.getAttribute("username");
response.setHeader("Cache-Control","no-cache,must-revalidate,no-store");
	if(session.getAttribute("username")==null)
	response.sendRedirect(" ");
%>