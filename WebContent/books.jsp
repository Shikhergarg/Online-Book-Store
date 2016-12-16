<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>

var hidden = false;
  
    function hide()
    {
    	document.getElementById('1').style.visibility = 'hidden';
    	//docuement.getElementById('1').style.visibility = 'visible'
    	
    }
</script>
.hide
{
display:none;
}
.show{
display : block;

}
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");
  	Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/obs3","root", "8233848005");
  	String sql = "select * from book"; 
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(sql);
	  
	 while(rs.next()){
	 
  %>
  <div class="book-<%out.print(rs.getString(1));%>">
<div class="row thumbnail no-padding">
<div class="book-content <%out.print(rs.getString(1));%>">
<div class="p-tag">
</div>
<div class="title">
<%out.print(rs.getString(2));%>
</div>
<div class="price row">
<span class="final-price">
<span class="c-inr">Rs.<%out.print(rs.getString(5));%></span>
</span>
<span class="button">

<input type="button" id="<%=rs.getString(1)%>" onclick="hide()" value="Add to cart">

</span>
</div>
</div>
</div>
</div>

	
  <%} %>
  
 
</body>
</html>
