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

	<h2 align="center">WELCOME TO ITEM DATA PAGES!</h2>


<!--SEARCHING OPERATIONS -->

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
     <a class="navbar-brand" href="${pageContext.request.contextPath}/item/all">Items List</a>
    </div>
</div>

<form class="navbar-form navbar-left" role="search" action="./searchAllHosp">
  <div class="form-group">
    <input name="searchValue" type="text" class="form-control" placeholder="Search">
  </div>
  <select name="searchOption" class="btn btn-default">
    <option>Code</option>
    <option>Vendors</option>
    <option>Customer</option>
  </select>                                           
  <button type="submit" class="btn btn-default">Submit</button>
  
  <a href="${pageContext.request.contextPath}/item/reg" class="btn btn-default">Add Item</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="excel"><i class="fa fa-file-excel-o" style="font-size:20px" title="Export to Excel!">Export to Excel</i></a>&nbsp; &nbsp;
<a href="pdf"><i class="fa fa-file-pdf-o" style="font-size:20px"  title="Export to PdF!">Export to PdF</i></a>
  
</form>
</nav>




	<div class="row">
	<table class="table table-striped table-hover">
			<tr class="success">
			<th> </th>
				<th>ID</th>
				<th>ITEM CODE</th>
				<th>BASE COST</th>
				<th>WIDTH</th>
				<th>HEIGHT</th>
				<th>LENGTH</th>
				<th>UOM MODEL</th>
				<th>SALE TYPE</th>
				<th>PURCHASE TYPE</th>
				<th>VENDORS</th>
				<th>CUSTOMERS</th>
				<th>BASE CURRENCY</th>

				<th colspan="2">OPERATIONS</th>
			</tr>
			<c:forEach items="${list}" var="i">
				<tr>
					<td><c:out value=" " /></td>
					<td><c:out value="${i.id}" /></td>
					<td><c:out value="${i.icode}" /></td>
					<td><c:out value="${i.cost}" /></td>
					<td><c:out value="${i.width}" /></td>
					<td><c:out value="${i.height}" /></td>
					<td><c:out value="${i.length}" /></td>
					<td><c:out value="${i.uom.model}" /></td>
					<td><c:out value="${i.saleType.method}" /></td>
					<td><c:out value="${i.purchaseType.method}" /></td>
					<%-- 	<td><c:out value="${i.venUsers.code}" /></td>
					<td><c:out value="${i.custUsers.code}"/></td>
  --%>



					<td><c:forEach items="${i.venUsers}" var="ven">
							<c:out value="${ven.code}" />,
	</c:forEach></td>
					<td><c:forEach items="${i.custUsers}" var="cust">
							<c:out value="${cust.code}" />,
	</c:forEach></td>

					<td><c:out value="${i.currency}" /></td>
					<td><a href="edit?id=${i.id}" class="btn btn-primary" role="button"data-toggle="tooltip" title="Edit!"><i class="fa fa-edit">  Edit</a></td>
					<td><a href="delete?id=${i.id}"class="btn btn-danger" role="button" onclick="myFunction()" data-toggle="tooltip" title="Delete!"><i class="fa fa-trash">  Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		${message} 
</body>
</fieldset>
</html>