<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form:form action="update" method="POST" modelAttribute="shipment">
<body>
<h2>Welcome to SHIPMENTTYPE Creation</h2>
SHIPMENT ID  <form:input path="id" readonly="true"/><br>
SHIPMENT MODE <form:select path="mode"><br>
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="AIR">AIR</form:option>
			<form:option value="TRUCK">TRUCK</form:option>
			<form:option value="SHIP">SHIP</form:option>
			<form:option value="TRAIN">TRAIN</form:option>
</form:select><br>					
SHIPMENT CODE <form:input path="code"/><br>
ENABLE SHIPMENT <form:checkbox path="enabled" value="YES"/>YES<br>
ORDER MODE <form:radiobutton path="grade" value="A"/>A<form:radiobutton path="grade" value="B"/>B<form:radiobutton path="grade" value="C"/>C<br>
DESCRIPTION <form:textarea path="dsc" /><br>
<input type="submit" value="Update Shipment">


</body>
${message}
</form:form></html>