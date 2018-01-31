<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
<%-- <script type="javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.min.js"></script> --%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
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
		<div style="margin-left: 20%;width: 80%;">
		<br/>
			<c:if test="${not empty msgAccess}">
				<div class="alert alert-warning" role="alert">${msgAccess}</div>
			</c:if>
			<h5>List of services</h5>
			<table class="table table-striped" style="margin-bottom:6rem">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Url</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="obj" items="${listObjects}">
		    	<tr>
					<td>${obj.object_id}</td>
					<td>${obj.object_name}</td>
					<td>${obj.object_path}</td>
					<td>
						<spring:url value="/accessService?idObject=${obj.object_id}&idAction=1" var="modifySys" /> 
						<spring:url value="/accessService?idObject=${obj.object_id}&idAction=2" var="viewMonitoring" />
	
						<button class="btn btn-primary" onclick="location.href='${modifySys}'">Modify System</button>
						<button class="btn btn-info" onclick="location.href='${viewMonitoring}'">View Monitoring</button>
					</td>
				</tr>
			</c:forEach>
		</table>
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

