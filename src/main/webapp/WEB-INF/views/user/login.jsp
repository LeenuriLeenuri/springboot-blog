<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">

	<div class="container">
		<h2>Login</h2>
		<hr />

		<form>
			<div class="form-group">
				<label for="username">Username: </label> <input type="text" class="form-control" id="username" placeholder="Enter username" />
			</div>

			<div class="form-group">
				<label for="password">Password: </label> <input type="password" class="form-control" id="password" placeholder="Enter password" />
			</div>
		</form>

		<button id="login--submit" class="btn btn-danger">로그인</button>

	</div>

</div>

<script src="/js/login.js"></script>

<%@include file="../include/footer.jsp"%>