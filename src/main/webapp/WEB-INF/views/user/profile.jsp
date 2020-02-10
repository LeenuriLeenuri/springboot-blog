<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">

	<div class="container">
		<h2>Profile</h2>
		<hr />

		<form:form action="/user/profile" method="PUT" enctype="multipart/form-data">
		
		<input type="hidden" name="id" value="${sessionScope.principal.id}" />
		
			<div class="form-group">
				<label for="username">Username: </label>
				<input type="text" class="form-control" placeholder="Enter Username" value="${sessionScope.principal.username}" readonly/>
			</div>

			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" class="form-control" placeholder="Enter password" name="password" value=""  required/>
			</div>

			<div class="form-group">
				<label for="email">Email: </label>
				<input type="email" class="form-control" placeholder="Enter email"  value="${sessionScope.principal.email}" readonly/>
			</div>

			<div class="form-group">
				<label for="profile">프로필 사진</label>
				<input type="file" class="form-control" name="profile" />
			<p class="my__profile">${sessionScope.principal.profile}</p>
			</div>

			<button id="update--submit" class="btn btn-danger">수정</button>
			<button id="delete--submit" class="btn btn-warning">회원 탈퇴</button>

		</form:form>

	</div>

</div>


<%@include file="../include/footer.jsp"%>