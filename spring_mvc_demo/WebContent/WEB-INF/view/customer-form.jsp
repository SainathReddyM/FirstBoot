<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>customer-form</title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="customer">
		First Name:<form:input path="firstName"/>
		<br />
		Last Name<form:input path="lastName"/>
		<form:errors path="lastName"/>
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>