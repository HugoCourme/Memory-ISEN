<%@page import="edu.isen.jee.memory.Model"%>
<%@ page import = "edu.isen.jee.memory.Servlet" %>
<html>
<body>

<%
  	String number = "sd";
%>

<h1>Guess a number : <%= number %></h1>
<form method="post" actions="/memory">
Your choice : <input name="number" />
<input type="submit"/>
</form>

</body>

</html>