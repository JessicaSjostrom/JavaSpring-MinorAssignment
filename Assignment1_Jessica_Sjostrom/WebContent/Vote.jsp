<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check SIN</title>
<style>
body {background-color: #D2C9D6}
h1   {color: #3e1b6b;}
button,input {background-color: #555555; color: white;}
div {align: center; font-family: "Trebuchet MS", Helvetica, sans-serif;}
</style>
</head>
<body>

<div align="center">
<h1>Check Your SIN</h1>
<br>

<form method="post" action="VoteController">
SIN: <input type="text" name="sin" /><br />
	<br>
<input type="hidden" name="vote" value="true"/>
<input type="submit" value="Check" />
</form>

<br>

<h2>Status: ${voteResult}</h2>

<br>
<a href="Index.jsp"><h2>Home</h2></a>
</div>
</body>
</html>