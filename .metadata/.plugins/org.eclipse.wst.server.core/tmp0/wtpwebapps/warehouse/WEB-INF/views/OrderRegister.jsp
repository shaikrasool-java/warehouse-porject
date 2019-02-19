<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.err{
	color: red;
}
</style>

</head>
		

<body>
<form:form action="insert" method="POST" modelAttribute="order">
<h2 center>Welcome to OrderMethod Creation</h2>
<legened>OrderMethod:</legened>
<fieldset>	
  
<pre> 
ORDER MODE <form:radiobutton path="mode" value="Sale"/>Sale	<form:radiobutton path="mode" value="Purchase"/>purchase<br>
<form:errors path="mode" cssClass="err"/>		
ORDER CODE <form:input path="code"/><br>
<form:errors path="code" cssClass="err"/>			
ORDER METHOD <form:select path="method">
			<form:option value=" ">-SELECT-</form:option>
			<form:option value="FIFO">FIFO</form:option>
			<form:option value="LIFO">LIFO</form:option>
			<form:option value="FCFO">FCFO</form:option>
			<form:option value="FEFO">FEFO</form:option>
</form:select>
<form:errors path="method" cssClass="err"/>		
<br>					
ORDER ACCEPT <form:checkbox path="accept" value="MutliMode"/>Multi-Mode
			<form:checkbox path="accept" value="Return"/>Accept Return<br>
			<form:errors path="accept" cssClass="err"/>
DESCRIPTION <form:textarea path="dsc" /><br>
<form:errors path="dsc" cssClass="err"/>		
<input type="submit" value="Create Order Method">
	</pre>
</form:form>
</fieldset>	
		${message}
		</body>
		
</html>