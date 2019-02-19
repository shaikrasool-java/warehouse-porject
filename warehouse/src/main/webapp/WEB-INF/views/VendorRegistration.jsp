<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err {
	color: red;
}
</style>

</head>
<body>
	<form:form action="insert" method="POST" modelAttribute="ven">

Vendor Name <form:input path="venName"/>
		<form:errors path="venName" cssClass="err" />
		<br>

Vendor Code<form:select path="venCode">
			<form:option value="">--SELECT--</form:option>
			<form:option value="CAT">CAT</form:option>
			<form:option value="RES">RES</form:option>
			</form:select>
		<form:errors path="venCode" cssClass="err" />
		<br>
Vendor Designation <form:radiobutton path="venDesg" value="sale" />Sale<form:radiobutton
			path="venDesg" value="service" />Service<form:radiobutton
			path="venDesg" value="both" />Both
<form:errors path="venDesg" cssClass="err" />
		<br>
		<br>
Vendor Preserve <form:checkbox path="venPreserve" value="a" />A
<form:checkbox path="venPreserve" value="b" />B
<form:checkbox path="venPreserve" value="c" />C<br>
		<br>
		<form:errors path="venPreserve" cssClass="err" />
		<input type="submit" value="Create Vendor">

	</form:form>

</body>
${message}
</html>