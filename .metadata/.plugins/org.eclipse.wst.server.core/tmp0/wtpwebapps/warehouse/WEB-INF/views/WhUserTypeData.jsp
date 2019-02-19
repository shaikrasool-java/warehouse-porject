<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<title>UOM DATA</title>
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

<h2 align="center">WELCOME TO WhUserType DATA PAGES!</h2>

	<!--SEARCHING OPERATIONS -->

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
     <a class="navbar-brand" href="${pageContext.request.contextPath}/whusertype/all">WhUserType List</a>
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
  
  <a href="${pageContext.request.contextPath}/whusertype/reg" class="btn btn-default">Add WhUserType</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="excel"><i class="fa fa-file-excel-o" style="font-size:20px" title="Export to Excel!">Export to Excel</i></a>&nbsp; &nbsp;
<a href="pdf"><i class="fa fa-file-pdf-o" style="font-size:20px"  title="Export to PdF!">Export to PdF</i></a>
  
</form>
</nav>
	

	<div class="row">
	<table class="table table-striped table-hover">
			<tr class="success">
			<th> </th>
			<th>ID</th>
			<th>USER TYPE</th>
			<th>USER CODE</th>
			<th>USER FOR</th>
			<th>USER EMAIL</th>
			<th>USER CONTACT</th>
			<th>USER ID TYPE</th>
			<th>IF OTHERS</th>
			<th>ID NUMBER</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${wuser}" var="w">
			<tr>
				<td><c:out value=" " /> </td>
				<td><c:out value="${w.id}" /> </td>
				<td><c:out value="${w.type}" /> </td>
				<td><c:out value="${w.code}" /> </td>
				<td><c:out value="${w.forType}" /> </td>
				<td><c:out value="${w.email}" /> </td>
				<td><c:out value="${w.contact}" /> </td>
				<td><c:out value="${w.idType}" /> </td>
				<td><c:out value="${w.ifOther}" /></td>
				<td><c:out value="${w.idNum}" /></td>
				<td><a href="edit?id=${w.id}"class="btn btn-primary" role="button"data-toggle="tooltip" title="Edit!"><i class="fa fa-edit">  Edit</a></td>
				<td><a href="delete?id=${w.id}"class="btn btn-danger" role="button" onclick="myFunction()" data-toggle="tooltip" title="Delete!"><i class="fa fa-trash">  Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
<a href="excel">Export to Excel</a>
<a href="pdf">Export to PdF</a>

	${message}
</body>
</html>