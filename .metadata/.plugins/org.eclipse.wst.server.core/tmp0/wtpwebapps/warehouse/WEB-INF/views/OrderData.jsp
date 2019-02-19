<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<title>ORDER DATA</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<script>
	function myFunction() {
		var c = confirm("Are you Really want to delete! ");

		if (c == true) {
			return;
		} else {
			event.preventDefault();
		}
	}
</script>
<body>
	<h2 align="center">WELCOME TO ORDER DATA PAGES!</h2>
		<!--SEARCHING OPERATIONS -->

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
     <a class="navbar-brand" href="${pageContext.request.contextPath}/ordermethod/all">OrderData List</a>
    </div>
</div>

<form class="navbar-form navbar-left" role="search" action="./searchAllHosp">
  <div class="form-group">
    <input name="searchValue" type="text" class="form-control" placeholder="Search">
  </div>
  <select name="searchOption" class="btn btn-default">
    <option>Code</option>
    <option>Mode</option>
  </select>
  <button type="submit" class="btn btn-default">Submit</button>
  
  <a href="${pageContext.request.contextPath}/ordermethod/reg" class="btn btn-default">Add Order</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="excel"><i class="fa fa-file-excel-o" style="font-size:20px" title="Export to Excel!">Export to Excel</i></a>&nbsp; &nbsp;
<a href="pdf"><i class="fa fa-file-pdf-o" style="font-size:20px"  title="Export to PdF!">Export to PdF</i></a>
  
</form>
</nav>
	

	<div class="row">
	<table class="table table-striped table-hover">
			<tr class="success">
			<th> </th>
			<th>ID</th>
			<th>ORDER MODE</th>
			<th>ORDER CODE</th>
			<th>ORDER METHOD</th>
			<th>ORDER ACCEPT</th>
			<th>DESCRIPTION</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="o">
			<tr>
				<td><c:out value=" " /> </td>
				<td><c:out value="${o.id}" /> </td>
				<td><c:out value="${o.mode}" /> </td>
				<td><c:out value="${o.code}" /> </td>
				<td><c:out value="${o.method}" /> </td>
				<td><c:out value="${o.accept}" /> </td>
				<td><c:out value="${o.dsc}" /></td>
				<td><a href="edit?id=${o.id}" class="btn btn-primary" role="button"data-toggle="tooltip" title="Edit!"><i class="fa fa-edit">  Edit</a></td>
				<td><a href="delete?id=${o.id}" class="btn btn-danger" role="button" onclick="myFunction()" data-toggle="tooltip" title="Delete!"><i class="fa fa-trash">  Delete</a></td>
			</tr>
		</c:forEach>

	
	</table>
	</div>
	${message}
</body>
</fieldset>
</html>