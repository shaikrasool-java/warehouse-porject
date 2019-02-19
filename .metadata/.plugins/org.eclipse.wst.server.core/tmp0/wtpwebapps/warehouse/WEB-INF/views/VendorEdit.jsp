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
<form:form action="update" method="POST" modelAttribute="ven">
Vendor Id<form:input path="id" readonly="true"/><br><br>
Vendor Name <form:input path="venName"/><br><br>
Vendor Code<form:select path="venCode">
	<form:option value="CAT">CAT</form:option>
	<form:option value="RES">RES</form:option>

</form:select><br><br>
Vendor Designation <form:radiobutton path="venDesg" value="sale"/>Sale<form:radiobutton path="venDesg" value="service"/>Service<form:radiobutton path="venDesg" value="both"/>Both<br><br>
Vendor Preserve <form:checkbox path="venPreserve" value="a"/>A
<form:checkbox path="venPreserve" value="b"/>B
<form:checkbox path="venPreserve" value="c"/>C<br><br>
<input type="submit" value="Update">

</form:form>

</body>
${message}
</html>