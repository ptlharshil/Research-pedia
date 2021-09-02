<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Research-pedia</title>
<link href="<c:url value="/resources/css/home-page.css"/>" rel="stylesheet"/>
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
<a class="user-functions allmsgs" href="msg.htm">View all Messages</a>
<form action="/bookstore">
<button class="logout">Logout</button>
</form>
</div>
<br/>
<div >
<c:forEach items="${sessionScope.allposts}" var="allposts">
	<div class="post-container">
	
		<c:out  value="${allposts.nameofuser}"/><br/></br>
		Area of Interest: <c:out  value="${allposts.aoi}"/><br/><br/>
		Article Url: <c:out  value="${allposts.url}"/><br/><br/>
		Description: <c:out  value="${allposts.description}"/><br/>
		
	</div>
</c:forEach>
</div>
<br/>

<div class="profile-container">
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