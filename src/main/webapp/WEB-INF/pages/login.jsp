<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
<script type="javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="logoList">
		<img
			src="${pageContext.request.contextPath}/resources/images/logo.png">
	</div>
	<div class="container">
		<h4 class="bleuTitle">Dynamic Coalitions App</h4>
		<div style="width: 50%;margin: 0 auto;">
		<br/>
		<c:if test="${not empty msgLoginFailed}">
			<div class="alert alert-danger" role="alert">${msgLoginFailed}</div>
		</c:if>
			<h5>Log in</h5>

			<c:url var="login" value="/login"/>
			<form:form method="post" modelAttribute="user" action="${login}">
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-4 col-form-label">Username</label>
					<div class="col-sm-8">
						<form:input path="subject_name" type="text" class="form-control" id="inputName"
							placeholder="Name"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">Password</label>
					<div class="col-sm-8">
						<form:input type="password" path="subject_password" class="form-control" id="inputPassword"
							placeholder="Password"/>
					</div>
				</div>
				<button type="submit" class="btn btn-primary mb-2">Submit</button>
			</form:form>

		</div>
	</div>
	<div class="footer">
		<img
			src="${pageContext.request.contextPath}/resources/images/values.gif">
	</div>
</body>
</html>
