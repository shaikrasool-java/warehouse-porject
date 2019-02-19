<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
<style type="text/css">
.error {
	color: #ff0000;
}
</style>

</head>
<body>

	<form:form action="insert" method="post" modelAttribute="cust">
		<h2 center>Welcome to Customer</h2>
		<legened>Customer:</legened>
		<fieldset>

			<pre> 
NAME             <form:input path="custName" />
<form:errors path="custName" cssClass="error"/>		

code				<form:input path="custCode" />
<form:errors path="custCode" cssClass="error"/>
		
CUSTOMER EMAIL:  <form:input path="custEmail" />
<form:errors path="custEmail" cssClass="error"/>		

CUSTOMER CONTACT: <form:input path="custContact" />				   
<form:errors path="custContact" cssClass="error"/>		

ADDRESS           <form:textarea path="custAddr" />
<form:errors path="custAddr" cssClass="error"/>		
				<br>	

CUSTOMER LOCS <form:select path="custLocs">
			<form:option value="">-SELECT-</form:option>
			<form:option value="HYD">HYDERABAD</form:option>
			<form:option value="BAG">BANGALORE</form:option>
			<form:option value="CHA">CHENAI</form:option>
			<form:option value="MUM">MUMBAI</form:option>
</form:select>
<form:errors path="custLocs" cssClass="error"/>		
				<br>

CUSTOMER ENABLED: YES<form:radiobutton path="custEnabled" value="yes" />
				   NO<form:radiobutton path="custEnabled" value="no" />
<form:errors path="custEnabled" cssClass="error"/>				   				
				   				
<input type="submit" value="Create Record">
	</pre>
	</form:form>
	</fieldset>
	${message}
</body>
</html>