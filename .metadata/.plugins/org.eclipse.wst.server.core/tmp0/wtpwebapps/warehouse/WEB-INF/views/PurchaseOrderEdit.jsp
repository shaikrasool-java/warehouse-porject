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
<form:form action="update" method="post" modelAttribute="po">

<h2 center>Welcome to Purchase Order</h2>
			<legened>Purchase Order:</legened>
			<fieldset>
			
		Order Id			<form:input path="id" readonly="true"/>
		Order Code: 		 <form:input path="code"/><br>
		
		Shipment Code:			<form:select path="shipment.id">
								<form:option value="">-select-</form:option>
								<form:options items="${shipment}" itemLabel="code" itemValue="id"/>
								</form:select>
								<form:errors path="shipment"  cssClass="er"/>
								
		 Vendors:
					<form:select path="ven.id" >
					<form:option value="">-SELECT-</form:option>
					<form:options items="${vendors}" itemLabel="code" itemValue="id"/>
					</form:select>
								<form:errors path="ven"  cssClass="er"/>
						

		
		
		Reference Number	 <form:input path="refNum"/><br>
		Quality Check		 <form:radiobutton path="qa" value="required"/> Required <form:radiobutton path="qa" value="required"/> Not Required<br>
		Default Status		 <form:input path="status" value="open" readonly="true"/><br>
		Description 		  <form:textarea path="dsc"/><br>
			
			<input type="submit" value="Submit">
			</fieldset>


</form:form>
	

${message}
</body>
</html>