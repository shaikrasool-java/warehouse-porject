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


<body>
	<form:form action="insert" method="POST" modelAttribute="it">
		<h2 center>Welcome to Item Creation</h2>
		<legened>Item:</legened>
		<fieldset>

			<pre> 
ITEM CODE <form:input path="icode" />
<form:errors path="icode" cssClass="error"/>

				<br>	

ITEM DIMENSSION: W <form:input path="width" />| H <form:input
					path="height" /> | L <form:input path="length" />

			  
BASE COST <form:input path="cost" />
				<br>	

BASE CURRENCY <form:select path="currency">
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="Rupee">INR</form:option>
			<form:option value="US Doller">USD</form:option>
			<form:option value="British Pound">GBP</form:option>
			<form:option value="Australian Doller">AUD</form:option>
</form:select>
<form:errors path="currency" cssClass="error"/>
				<br>			
						
ITEM UOM : <form:select path="uom.id">
<form:option value=" ">-select-</form:option>
<form:options items="${uoms}" itemLabel="model" itemValue="id" />
</form:select>
<%-- <form:errors path="model" cssClass="error"/> --%>
Order Method :(Sale Type)
<form:select path="saleType.id">
<form:option value=" ">-select-</form:option>
<form:options items="${sales}" itemLabel="code" itemValue="id"/>
</form:select>
<form:errors path="saleType" cssClass="error"/>

Order Method: (Purchase Type)
<form:select path="purchaseType.id">
<form:option value=" ">-select-</form:option>
<form:options items="${purchases}" itemLabel="code" itemValue="id"/>
</form:select>
<form:errors path="purchaseType" cssClass="error"/>

Item Vendors:
<form:select path="venUsers" >
	<form:option value="">-SELECT-</form:option>
	<form:options items="${vendors}" itemLabel="code" itemValue="id"/>
</form:select>
<form:errors path="venUsers" cssClass="error"/>


 Item Customers:
<form:select path="custUsers">
 	<form:option value="">-SELECT-</form:option>
	<form:options items="${customers}" itemLabel="code" itemValue="id"/>
</form:select>
<form:errors path="custUsers" cssClass="error"/>
					
<input type="submit" value="Create Item">
	</pre>
	</form:form>
	</fieldset>
	${message}
</body>

</html>