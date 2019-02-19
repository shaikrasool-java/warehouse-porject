<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: #ff0000;
}
</style>

</head>
<form:form action="insert" method="POST" modelAttribute="shipment">
<body>
<h2>Welcome to SHIPMENTTYPE Creation</h2>
SHIPMENT MODE <form:select path="mode"><br>
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="AIR">AIR</form:option>
			<form:option value="TRUCK">TRUCK</form:option>
			<form:option value="SHIP">SHIP</form:option>
			<form:option value="TRAIN">TRAIN</form:option>
</form:select>
<form:errors path="mode" cssClass="error"/>
<br>					
SHIPMENT CODE <form:input path="code"/>
<form:errors path="code" cssClass="error"/>
<br>
ENABLE SHIPMENT <form:checkbox path="enabled" value="YES"/>YES
<form:errors path="enabled" cssClass="error"/> 
<br>
ORDER MODE <form:radiobutton path="grade" value="A"/>A<form:radiobutton path="grade" value="B"/>B<form:radiobutton path="grade" value="C"/>C
<form:errors path="grade" cssClass="error"/>
<br>
DESCRIPTION <form:textarea path="dsc" />
<form:errors path="dsc" cssClass="error"/>
<br>
<input type="submit" value="Create Shipment">
</body>
${message}
</form:form>
</html>