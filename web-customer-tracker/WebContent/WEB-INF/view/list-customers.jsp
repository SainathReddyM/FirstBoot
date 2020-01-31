<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
	<title>List Customers</title>
	<link type="text/css" 
		  rel="stylesheet" 
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		
		<div id="container">
			<div id="content">
			
			<input type="button" value="Add Customer" 
				   onClick="window.location.href='addCustomerForm'; return false;"
			/>
			
			
				<!-- add html table header here -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="temp" items="${customers}">
						<c:url var="updateLink" value="updateCustomer">
							<c:param name="customerId" value="${temp.id}"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="deleteCustomer">
							<c:param name="customerId" value="${temp.id}"></c:param>
						</c:url>
						
						<tr>
							<td>${temp.firstName}</td>
							<td>${temp.lastName}</td>
							<td>${temp.email}</td>
							<td> <a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>