<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
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
     <a class="navbar-brand" href="${pageContext.request.contextPath}/#">Customers List</a>
    </div>
</div>

<form class="navbar-form navbar-left" role="search" action="./searchAllHosp">
  <div class="form-group">
    <input name="searchValue" type="text" class="form-control" placeholder="Search">
  </div>
  <select name="searchOption" class="btn btn-default">
    <option>Name</option>
    <option>Email</option>
    <option>Address</option>
  </select>
  <button type="submit" class="btn btn-default">Submit</button>
  
  <a href="${pageContext.request.contextPath}/customer/reg" class="btn btn-default">Add Customer</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="excel"><i class="fa fa-file-excel-o" style="font-size:20px" title="Export to Excel!">Export to Excel</i></a>&nbsp; &nbsp;
<a href="pdf"><i class="fa fa-file-pdf-o" style="font-size:20px"  title="Export to PdF!">Export to PdF</i></a>
  
</form>
</nav>


	<div class="row">
	<table class="table table-striped table-hover">
			<tr class="success">
			<th> </th>
		<th>ID</th>
			<th>Customer Name</th>
			<th>Customer Code</th>
			<th>Customer Email</th>
			<th>Customer Contact</th>
			<th>Address</th>
			<th>Customer Location</th>
			<th>Customer Enabled</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="c">
			<tr>
				<td><c:out value=" " /> </td>
				<td><c:out value="${c.cId}" /> </td>
				<td><c:out value="${c.custName}" /> </td>
				<td><c:out value="${c.custCode}" /> </td>
				<td><c:out value="${c.custEmail}" /> </td>
				<td><c:out value="${c.custContact}" /> </td>
				<td><c:out value="${c.custAddr}" /> </td>
				<td><c:out value="${c.custLocs}" /></td>
				<td><c:out value="${c.custEnabled}" /></td>

				<td><a href="edit?cId=${c.cId}"class="btn btn-primary" role="button"data-toggle="tooltip" title="Edit!"><i class="fa fa-edit">  Edit</a></td>
				<td><a href="delete?cId=${c.cId}"class="btn btn-danger" role="button" onclick="myFunction()" data-toggle="tooltip" title="Delete!"><i class="fa fa-trash">  Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	${message}
</body>
