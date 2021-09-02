<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/home-page.css"/>" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>


<div class="search-container">
<form action="aoi.htm" method="get">
<select class="search" name="area">
  <option value="Select One" >Select One</option>
  <option value="Applied Science">Applied Science</option>
  <option value="Biological Science">Biological Science</option>
  <option value="Computer Science">Computer Science</option>
  <option value="Physics">Physics</option>
  <option value="Finance">Finance</option>
  <option value="Economics">Economics</option>
</select>
<button class="search-button" type="submit">Search</button>
</form>

</div>
<br/>
<div class="three-components">
<div class="container">

<a class="user-functions post" href="post.htm">Create Post</a><br/>
<a class="user-functions profile" href="myprofile.htm">My Profile</a><br/>
<a class="user-functions messages" href="message.htm">Create Message</a><br/>
<form action="/bookstore">
<button class="logout">Logout</button>
</form>
</div>
<br/>


<div class="post-container">

<c:forEach items="${msg}" var="messg">

	<c:forEach items="${messg}" var="msg">
	<div class="post-container">
	
	<c:if test="${msg.getProfile().getId() == sessionScope.profile.id}">
		
		<td>You: </td>
		<c:out value="${msg.getMsg()}"></c:out></br></br>
	</c:if>
	<c:if test="${msg.getProfile().getId() != sessionScope.profile.id}">
		
		<td>${msg.getProfile().getName()}: </td>
		<c:out value="${msg.getMsg()}"></c:out></br></br>
	</c:if>
	</div>
	</c:forEach>

</c:forEach>
</div>


<div class="container">
<div class="profile-bar">
<form action="search.htm">
<input type="search" name="search"/>
<button>Search Profiles</button>
</form>
</div>
</div>
</div>

</body>
</html>