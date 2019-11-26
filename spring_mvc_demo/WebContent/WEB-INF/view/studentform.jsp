<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>
<title>Student-form</title>
</head>
<body>
	<form:form action="processform" modelAttribute="student">
		First Name: <form:input path="firstName"/>
		<br />
		Last Name: <form:input path="lastName" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>