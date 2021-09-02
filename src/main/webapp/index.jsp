<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Research-pedia</title>

<link href="<c:url value="/resources/css/login-page.css"/>" rel="stylesheet"/>
</head>
<body>


<label class="title"><b>Research-pedia</b></label>

<form class="login-container" action="login.htm" method="post">
<input class="userinput" type="text" name="username" placeholder="Username"/>
<br/>
<input class="userpass" type="password" name="password" placeholder="Password"/>
<br/>
<button class="login" type="submit" name="login">Login</button>
</form>
<br/>
<a class="profile" href="profile/create.htm"><b>New User? Create Profile</b></a>

</body>
</html>