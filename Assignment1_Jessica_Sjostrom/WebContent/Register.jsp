<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
body {background-color: #D2C9D6}
h1   {color: #3e1b6b;}
button,input {background-color: #555555; color: white;}
div {align: center; font-family: "Trebuchet MS", Helvetica, sans-serif;}
</style>
</head>
<body>

<div align="center">
<h1>Register to Vote</h1>
<br>

<form method="post" action="RegisterController">
<table>
<tr>
	<td>SIN: </td>
	<td><input type="text" name="sin" /></td>
</tr>
<tr>
	<td>First name: </td>
	<td><input type="text" name="fName" /></td>
</tr>
<tr>
	<td>Last name: </td>
	<td><input type="text" name="lName" /></td>
</tr>
<tr>
	<td>Birthday: </td>
	<td><input type="text" name="birthyear" placeholder="YYYY" maxlength="4" style="width:50px"/>
	<input type="text" name="birthmon" placeholder="MM" maxlength="2" style="width:25px"/>
	<input type="text" name="birthdate" placeholder="DD"  maxlength="2" style="width:25px"/></td>
</tr>
<tr>
<td>Address: </td>
<td><input type="text" name="address" /></td>
</tr>
<tr>
	<td colspan="2">
	<input type="hidden" name="register" value="true"/>
	<input type="submit" value="Register" /> </td>
</tr>
</table>
</form>
</table>
<br>

<h2>${registerResult }</h2>

<br>
<a href="Index.jsp"><h2>Home</h2></a>

</div>
</body>
</html>