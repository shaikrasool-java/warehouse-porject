<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>UOM</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.err{
	color: red;
}
</style>

</head>
<body>
<form:form action="insert" method="POST" modelAttribute="uom">

<h2>WELCOME TO UNIT OF MEASURMENT REGISTRATION PAGE</h2>
<pre>
<form:errors path="type" cssClass="err"/>
UOM TYPE	<form:select path="type">
		<form:option value="">-SELECT-</form:option>
		<form:option value="packing">PACKING</form:option>
		<form:option value="nopacking">NO PACKING</form:option>
		<form:option value="non">-NA-</form:option>
</form:select>

<br>
UOM MODEL	<form:input path="model"/><br>
<form:errors path="model" cssClass="err"/>


DESCRIPTION     <form:textarea path="dsc"/><br>
<form:errors path="dsc" cssClass="err"/>
			<input type="submit" value="Register">
</pre>


</form:form>
${message}
</body>

</html>