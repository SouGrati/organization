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
	<ul class="nav justify-content-end">
		<li class="nav-item nav-link active">User connected : ${sessionScope.user.subject_name}, 
			Organization n°${sessionScope.user.organization_id}</li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logOut">Log out</a></li>
	</ul>
	<div class="logoList" style="margin-left: 12%;">
		<img
			src="${pageContext.request.contextPath}/resources/images/logo.png">
	</div>
	<div class="container">
		<h4 class="bleuTitle" style="margin-left: 12%;">Dynamic Coalitions App</h4>
		<div style="margin-left: 25%">
		<br/>
			<c:if test="${not empty msgObjAdded}">
				<div class="alert alert-success" role="alert">${msgObjAdded}</div>
			</c:if>
			<h5>Create a new service</h5>
			<c:url var="addService" value="/addService"/>
			<form:form method="post" modelAttribute="object" action="${addService}">
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-4 col-form-label">Service Name</label>
					<div class="col-sm-8">
						<form:input path="object_name" type="text" class="form-control" id="inputName"
							placeholder="Service Name"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">Service url</label>
					<div class="col-sm-8">
						<form:input path="object_path" type="text" class="form-control" id="inputCoalName"
							placeholder="Service Url"/>
					</div>
				</div>
				<button type="submit" class="btn btn-primary mb-2">Submit</button>
			</form:form>

		</div>
		<div id="sidebar-wrapper" class="sidebar-toggle">
			<ul class="sidebar-nav">
				<li><a href="#item1">Service Options</a>
					<ul class="sousMenu">
						<c:if test="${sessionScope.user.admin}"><li><a href="${pageContext.request.contextPath}/">Register a New Organization</a></li></c:if>
						<c:if test="${sessionScope.user.admin}"><li><a href="${pageContext.request.contextPath}/addService">Register Service</a></li></c:if>
						<li><a href="${pageContext.request.contextPath}/allServices">Get All Services</a></li>
						<c:if test="${sessionScope.user.admin}"><li><a href="${pageContext.request.contextPath}/allOrganizations">Get All Orgnizations</a></li></c:if>
					</ul></li>
				<li><a href="#item3">Membership Options</a>
					<ul class="sousMenu">
						<li>Change Password</li>
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
