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
		<li class="nav-item nav-link active">User connected : ${sessionScope.user.subject_name}</li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logOut">Log out</a></li>
	</ul>
	<div class="logoList" style="margin-left: 12%;">
		<img
			src="${pageContext.request.contextPath}/resources/images/logo.png">
	</div>
	<div class="container">
		<h4 class="bleuTitle" style="margin-left: 12%;">Dynamic Coalitions App</h4>
		<div style="margin-left: 34%;width: 50%;">
		<br/>
		<c:if test="${not empty msgUserAdded}">
			<div class="alert alert-success" role="alert">${msgUserAdded}</div>
		</c:if>
			<h5>List of organizations</h5>
			<table class="table table-striped" style="margin-bottom:6rem">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="org" items="${listOrganizations}">
			    <tr>
				<td>
					${org.idOrganization}
				</td>
				<td>${org.nameOrganization}</td>
						<td><spring:url
								value="${pageContext.request.contextPath}/${org.idOrganization}/delete"
								var="deleteUrl" /> <spring:url
								value="${pageContext.request.contextPath}/${org.idOrganization}/update"
								var="updateUrl" /> <spring:url
								value="addUser?idOrg=${org.idOrganization}" var="addUserUrl" />

							<button class="btn btn-primary"
								onclick="location.href='${updateUrl}'">Update</button>
							<button class="btn btn-danger"
								onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
							<button class="btn btn-info" onclick="javascript:addUser('${addUserUrl}');">Add
								User</button></td>
					</tr>
			</c:forEach>
		</table>
		</div>
		<div id="sidebar-wrapper" class="sidebar-toggle">
			<ul class="sidebar-nav">
				<li><a href="#item1">Service Options</a>
					<ul class="sousMenu">
						<li><a href="${pageContext.request.contextPath}/">Register a New Coalition</a></li>
						<li><a href="${pageContext.request.contextPath}/addService">Register Service</a></li>
						<li><a href="${pageContext.request.contextPath}/allServices">Get All Services</a></li>
						<li><a href="${pageContext.request.contextPath}/allOrganizations">Get All Orgnizations</a></li>
					</ul></li>
				<li><a href="#item3">Membership Options</a>
					<ul class="sousMenu">
						<li>Change Password</li>
					</ul></li>
			</ul>
		</div>
	</div>
	<div id="modal" class="modal" tabindex="-1" role="dialog" style="display:none">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Add user</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" onclick="$('#modal').hide()">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<c:url var="addUser" value="/addUser" />
				<form:form id="addUser" method="post" modelAttribute="user" style="width: 72%;margin: 2em auto;">
					<div class="form-group row">
						<label for="staticEmail" class="col-sm-4 col-form-label">Username</label>
						<div class="col-sm-8">
							<form:input path="subject_name" type="text" class="form-control"
								id="inputName" placeholder="Username" />
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">Password</label>
						<div class="col-sm-8">
							<form:input path="subject_password" type="password"
								class="form-control" id="inputPass" placeholder="Password" />
						</div>
					</div>
					<button type="submit" class="btn btn-primary mb-2">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
	<div class="footer">
		<img
			src="${pageContext.request.contextPath}/resources/images/values.gif">
	</div>
	<script type="text/javascript">
		function addUser(url){
			$('#modal').show();
			$("#addUser").attr("action", url);
		}
	</script>
</body>
</html>

