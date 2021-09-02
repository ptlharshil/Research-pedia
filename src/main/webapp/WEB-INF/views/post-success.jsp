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
<br/>
<div style="text-align:center;">
Post has been created
</div>
</body>
</html>