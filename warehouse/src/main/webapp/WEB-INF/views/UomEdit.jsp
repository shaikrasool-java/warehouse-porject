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
<h2>WELCOME TO UOM OF WAREHOUSE UPDATE FORM</h2>
<form:form action="update" method="POST" modelAttribute="uom">
<pre>
ID:		<form:input path="id" readonly="true"/><br>
UOM TYPE	<form:select path="type">

		<form:option value=" ">-SELECT-</form:option>
		<form:option value="packing">PACKING</form:option>
		<form:option value="nopacking">NO PACKING</form:option>
		<form:option value="non">-NA-</form:option>
			</form:select><br>
UOM MODEL	<form:input path="model"/><br>
DESCRIPTION     <form:textarea path="dsc"/><br>
			<input type="submit" value="Update">
</pre>

</form:form>
${message}
</body>
</html>