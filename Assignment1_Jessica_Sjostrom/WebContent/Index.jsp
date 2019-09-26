<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Home Page</title>
<style>
body {background-color: #D2C9D6}
h1   {color: #3e1b6b;}
p    {color: purple;}
button {background-color: #555555; color: white;}
div {align: center; font-family: "Trebuchet MS", Helvetica, sans-serif;}
ul {
  background: purple;
  padding: 20px;
  width: 50%;
}
ul li {
  background: lightgrey;
  margin: 5px;
}

</style>
</head>
<body>

<div align="center">
<h1>Online Voting System</h1>
<br>

<form method="post" action="VoterController">
<input type="hidden" name="loadDummy" value="true"/>
<button type="submit" value="Load">Load dummy voter records</button>
</form> 
<br>

<form method="post" action="VoterController">
<input type="hidden" name="loadDummyVotes" value="true"/>
<button type="submit" value="Load">Load dummy votes</button>
</form>

<ul>
	<li><h2><a href="Register.jsp">Register</a>	</h2></li>
	<li><h2><a href="Vote.jsp">Vote</a>	</h2></li>
	<li><h2><a href="ViewVoters.jsp">View Voters</a></h2></li>
	<li><h2><a href="ViewStats.jsp">View Stats</a></h2></li>
</ul>
</div>
</body>
</html>