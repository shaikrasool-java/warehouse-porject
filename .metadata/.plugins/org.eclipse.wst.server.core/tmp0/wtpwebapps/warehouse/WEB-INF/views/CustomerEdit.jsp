<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="cust">
<h2 center>Welcome to Customer</h2>
<legened>Customer:</legened>
<fieldset>	
  
<pre> 
Customer ID: <form:input path="cId" readonly="true"/>
NAME             <form:input path="custName"/>
Code             <form:input path="custCode"/>
CUSTOMER EMAIL:  <form:input path="custEmail"/>
CUSTOMER CONTACT: <form:input path="custContact"/>				   
ADDRESS           <form:textarea path="custAddr"/><br>	
CUSTOMER LOCS <form:select path="custLocs">
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="HYD">HYDERABAD</form:option>
			<form:option value="BAG">BANGALORE</form:option>
			<form:option value="CHA">CHENAI</form:option>
			<form:option value="MUM">MUMBAI</form:option>
</form:select><br>
CUSTOMER ENABLED: YES<form:radiobutton path="custEnabled" value="yes"/>
				   NO<form:radiobutton path="custEnabled" value="no"/>
				   				
<input type="submit" value="Create Record">
	</pre>
</form:form>
</fieldset>	
		${message}
		</body>
		</html>