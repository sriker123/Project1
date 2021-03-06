<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpikeCart</title>
<meta charset="utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<head>
<style type="text/css">
body
{
background-color: #070417;
background-image: url("https://www.transparenttextures.com/patterns/asfalt-light.png");
/* This is mostly intended for prototyping; please download the pattern and re-host for production environments. Thank you! */
}

</style>
<style>

h1   {color: #ed9f10;}
b   {color: red;}
</style>

</head>
<body >
	<center>
		<h1>
			<b >Shopping Cart</b>
		</h1>
	</center>

	<%--<center>
		<h2>${msg}</h2>
	</center>

	<center>${role}</center>


	<center>
		<h2>${errormsg}</h2>
	</center>

	${loginmessage} ${smsg }
 --%>
	<%-- <hr>
	<!-- Horizontal Row -->

	<jsp:include page="CategoryMenu1.jsp"></jsp:include>
	<!-- <p align="right"><iframe width="560" height="315" src="https://www.youtube.com/embed/90CB2AwDSBs" frameborder="0" allowfullscreen></iframe></p> -->
	<c:if test="${empty loginmessage }">
		<li><a href="login"><p align="right">
					<span class="glyphicon glyphicon-log-in"></span> Login
				</p></a> <a href="register"><p align="right" class=>
					<span class="glyphicon glyphicon-user"></span> Register
				</p></a></li>
	</c:if>
	<c:if test="${not empty loginmessage}">
		<li><a href="logout"><p align="right">
					<span class="glyphicon glyphicon-log-in"></span> Logout
				</p></a></li>
		<li><a href="mycart"><p align="right">
					<span class="glyphicon glyphicon-cart"></span> Mycart
				</p></a></li>
	</c:if>


	<c:if test="${isAdmin==true}">
		<jsp:include page="AdminHome.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include><br>

	</c:if>

	<c:if test="${not empty errormsg}">
		<jsp:include page="login.jsp"></jsp:include><br>
	</c:if>


	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="register.jsp"></jsp:include>
	</c:if>


	<jsp:include page="AboutUs.jsp"></jsp:include><br> --%>
	<jsp:include page="CategoryMenu1.jsp"></jsp:include>
	<jsp:include page="AboutUs.jsp"></jsp:include>

</body>
</html>