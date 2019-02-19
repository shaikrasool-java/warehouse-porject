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
	<form:form action="update" method="POST" modelAttribute="list">
		<h2 center>Welcome to Item Creation</h2>
		<legened>Item:</legened>
		<fieldset>

			<pre> 

ITEM ID <form:input path="id" readonly="true" />
				<br>
ITEM CODE <form:input path="icode" />
				<br>	

ITEM DIMENSSION: W<form:input path="width" size="7px" /> H:<form:input
					path="length" size="7px" /> L:<form:input path="height" size="7px" />
BASE COST <form:input path="cost" />
				<br>	

BASE CURRENCY <form:select path="currency">
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="Rupee">INR</form:option>
			<form:option value="US Doller">USD</form:option>
			<form:option value="British Pound">GBP</form:option>
			<form:option value="Australian Doller">AUD</form:option>
</form:select>
				<br>					
				
ITEM UOM : <form:select path="uom.id">
<form:option value="">-select-</form:option>
<form:options items="${uoms}" itemLabel="model" itemValue="id" />

</form:select>


0Order Method :(Sale Type)
<form:select path="saleType.id">
<form:option value="">-select_</form:option>
<form:options items="${sales}" itemLabel="code" itemValue="id" />
</form:select>

Order Method: (Purchase Type)
<form:select path="purchaseType.id">
<form:option value="">-select-</form:option>
<form:options items="${purchases}" itemLabel="code" itemValue="id" />
</form:select>

Item Vendors:
<form:select path="venUsers" >
	<form:option value="">-SELECT-</form:option>
	<form:options items="${vendors}" itemLabel="code" itemValue="id"/>
</form:select>



 Item Customers:
<form:select path="custUsers">
 	<form:option value="">-SELECT-</form:option>
	<form:options items="${customers}" itemLabel="code" itemValue="id"/>
</form:select>
<input type="submit" value="Update">
	</pre>
	</form:form>
	</fieldset>
	${message}
</body>

</html>