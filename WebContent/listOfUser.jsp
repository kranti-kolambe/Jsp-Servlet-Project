
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<!--=============================================================================================  -->
<link rel="stylesheet" type="text / css"
	href="onlineCss/dataTables.bootstrap4.min.css">
<!--=============================================================================================  -->
<link rel="stylesheet" type="text / css" href="onlineCss/cloudflare.css">
<!--=============================================================================================  -->
<link rel="stylesheet" type="text / css"
	href="onlineCss/bootstrap.min.css">
<!--=============================================================================================  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!--=============================================================================================  -->
<script type="text/javascript" src="onlineJs/bootstrap.min.js"></script>
<!--=============================================================================================  -->
<script type="text/javascript"
	src="onlineJs/dataTables.bootstrap4.min.js"></script>
<!--=============================================================================================  -->
<script type="text/javascript" src="onlineJs/jquery.dataTables.js"></script>
<!--=============================================================================================  -->
<script type="text/javascript" src="onlineJs/jquery-3.3.1.js"></script>
<!--=============================================================================================  -->
<script type="text/javascript" src="onlineJs/jquery.min.js"></script>
<!--=============================================================================================  -->
<script type="text/javascript" src="onlineJs/jquery.dataTables.min.js"></script>
<!--=============================================================================================  -->
</head>
<body>
	<div style="background-color: rgb(224, 195, 231)">
		<div class="container">

			<table id="mytable" class="table" style="background-color: white"
				border=1px>
				<thead class="thead-dark">

					<tr>
						<th class="align-top">
							<div
								class="custom-control custom-control-inline custom-checkbox custom-control-nameless m-0">
								<input type="checkbox" class="custom-control-input"
									id="all-items"> <label class="custom-control-label"
									for="all-items"></label>
							</div>
						</th>
						<th>Photo</th>
						<th>UID</th>
						<th>User Name</th>
						<th>Email</th>
						<th>password</th>
						<th>City</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${userslist}">
						<tr>
							<td class="align-middle">

								<div
									class="custom-control custom-control-inline custom-checkbox custom-control-nameless m-0 align-top">
									<input type="checkbox" class="custom-control-input" id="item-1">
									<label class="custom-control-label" for="item-1"></label>
								</div>
							</td>
							<td class="align-middle text-center">
								<div
									class="bg-light d-inline-flex justify-content-center align-items-center align-top"
									style="width: 35px; height: 35px; border-radius: 3px;">
									<i class="fa fa-fw fa-photo" style="opacity: 0.8;"></i>
								</div>
							</td>

							<td><c:out value="${user.uid}"/></td>
							<td><c:out value="${user.userName}"/></td>
							<td><c:out value="${user.email}"/></td>
							<td><c:out value="${user.psw}"/></td>
							<td><c:out value="${user.city}"/></td>
							
                                   
							
                     <!--    <td><c:out value="${user.status}"/></td> <td><a	href="edit?uid=<c:out value='${user.uid}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?uid=<c:out value='${user.uid}' />">Delete</a></td> -->
                               
                           
						<td class="text-center align-middle"><i
								class="fa fa-fw text-secondary cursor-pointer fa-toggle-on"></i></td>
						<td class="text-center align-middle">
							<div class="btn-group align-top">
								<button class="btn btn-sm btn-outline-secondary badge"
										type="button" data-toggle="modal"
										data-target="#user-form-modal">Edit</button>
								<button class="btn btn-sm btn-outline-secondary badge"
										type="button">
									<i class="fa fa-trash"></i>
								</button>
							</div>
						</td>
					</tr>
					 </c:forEach>
                            <!-- } -->

				</tbody>


			</table>

		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#mytable').DataTable({
				"pagingType" : "full_numbers",

			});
		});
	</script>
</body>
</html>
