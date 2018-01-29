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
	${pageContext.request.contextPath}
	<div class="logoList">
		<img
			src="${pageContext.request.contextPath}/resources/images/logo.png">
	</div>
	<div class="container">
		<h4 class="bleuTitle">Dynamic Coalitions App</h4>
		<div style="margin-left: 25%">
		<br/>
			<h5>Create a new organization</h5>

			<c:url var="addOrganization" value="/addOrganization"/>
			<form:form method="post" modelAttribute="organization" action="${addOrganization}">
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-4 col-form-label">Organization Name</label>
					<div class="col-sm-8">
						<form:input path="nameOrganization" type="text" class="form-control" id="inputName"
							placeholder="Name"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">Organization Password</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="inputPassword"
							placeholder="Password">
					</div>
				</div>
				<button type="submit" class="btn btn-primary mb-2">Submit</button>
			</form:form>

		</div>
		<div id="sidebar-wrapper" class="sidebar-toggle">
			<ul class="sidebar-nav">
				<li><a href="#item1">Service Options</a>
					<ul class="sousMenu">
						<li>Register a New Coalition</li>
						<li>Register Service</li>
						<li>Get All Services</li>
					</ul></li>
				<li><a href="#item3">Membership Options</a>
					<ul class="sousMenu">
						<li>Change Password</li>
						<li>Create User</li>
					</ul></li>
			</ul>
		</div>
	</div>
	<div class="footer">
		<img
			src="${pageContext.request.contextPath}/resources/images/values.gif">
	</div>
</body>
</html>
