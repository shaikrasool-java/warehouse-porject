<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h2>Welcome to OrderMethod Creation</h2>
<form:form action="update" method="POST" modelAttribute="order">
<pre> 
ORDER ID  <form:input path="id" readonly="true"/><br>
ORDER MODE <form:radiobutton path="mode" value="Sale"/>Sale	<form:radiobutton path="mode" value="Purchase"/>purchase<br>
ORDER CODE <form:input path="code"/><br>	
ORDER METHOD <form:select path="method">
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="FIFO">FIFO</form:option>
			<form:option value="LIFO">LIFO</form:option>
			<form:option value="FCFO">FCFO</form:option>
			<form:option value="FEFO">FEFO</form:option>
</form:select><br>					
ORDER ACCEPT <form:checkbox path="accept" value="MutliMode"/>Multi-Mode
			<form:checkbox path="accept" value="Return"/>Accept Return<br>
DESCRIPTION <form:textarea path="dsc" /><br>
<input type="submit" value="Create Order Method">
	</pre>
</form:form>
		${message}
		</body></html>