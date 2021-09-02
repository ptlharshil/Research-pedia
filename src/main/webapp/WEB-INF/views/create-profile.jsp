<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="<c:url value="/resources/css/create-profile.css"/>" rel="stylesheet"/>
<title>Research-pedia</title>
</head>

<script type="text/javascript">
var i=0;
function add(){
	var a=document.createElement('div');
	a.innerHTML = "<input class='name' type='url' name='articlelink' placeholder='Article Link'/>";
	document.getElementById("articles").appendChild(a);
	
	return false;
}
</script>
<body>

<label class="profile">Create Profile</label>
<br/>
<form action="success.htm" method="post">
<input class="name" type="text" name="name" placeholder="Name"/><br/>
<input class="name" type="text" name="uname" placeholder="Username"/><br/>
<input class="name" type="password" name="pass" placeholder="Password"/><br/>
<input class="name" type="text" name="email" placeholder="Email"/><br/>
<input class="name" type="text" name="occupation" placeholder="Occupation"/><br/>
<select class="name" name="areaofinterest">
  <option value="Select One" >Select One</option>
  <option value="Applied Science">Applied Science</option>
  <option value="Biological Science">Biological Science</option>
  <option value="Computer Science">Computer Science</option>
  <option value="Physics">Physics</option>
  <option value="Finance">Finance</option>
  <option value="Economics">Economics</option>
</select><br/>
<input class="name" type="text" name="institution" placeholder="Institution"/><br/>
<input class="name" id="article" type="text" name="articlelink" placeholder="Article Link"/><br/>
<div id="articles"></div>
<button class="add" type="button" onclick="add()">Add Article</button><br/>

<input class="create" type="submit" value="Create Profile"/>
</form>
<a class="log" href="../">Back to Login Page</a>
</body>
</html>