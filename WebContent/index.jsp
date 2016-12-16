<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./Login" method="post">
<% 
					if(request.getAttribute("Error")!=null){
					out.print("<font size='2' color='red' m>");
					out.print(request.getAttribute("Error"));
					out.print("</font>");
					out.print("<br>");
					}
					
					
%>

USERNAME <input type="text" name="username" placeholder="Enter username"><br>
PASSWORD <input type="password" name="password" placeholder="Enter password"><br>
<input type="submit" name="button1" value="Signin" />
<a href="register.jsp">register</a>

</form>
</body>
</html>