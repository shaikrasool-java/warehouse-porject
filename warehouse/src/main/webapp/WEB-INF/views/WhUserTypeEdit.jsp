<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form:form action="update" method="POST" modelAttribute="wuser">

	<body>
		<h2>Welcome to WhUserType Registration</h2>
		<pre>
USER ID <form:input path="id" readonly="true"/><br>		 
USER TYPE <form:radiobutton path="type" value="vendor" />Vendor	<form:radiobutton
				path="type" value="Customer" />Customer<br>
USER CODE <form:input path="code" />
			<br>
USER FOR <form:input path="forType" />
			<br>	
USER EMAIL <form:input path="email" />
			<br>
USER CONTACT <form:input path="contact" />
			<br>
USER TYPE <form:select path="idType">
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="PAN CARD">PAN CARD</form:option>
			<form:option value="AADHAR">AADHAR</form:option>
			<form:option value="VOTER">VOTER</form:option>
			<form:option value="OTHER">OTHER</form:option>
</form:select>
			<br>					

IF OTHER <form:input path="ifOther" />
			<br>
ID NUMBER <form:input path="idNum" />
			<br>	


<input type="submit" value="Update User">
	</pre>
</form:form>
</body>
${message}
</html>