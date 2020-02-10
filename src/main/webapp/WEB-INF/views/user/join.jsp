<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">

	<div class="container">
		<h2>Join</h2>
		<hr/>

		<form>
			<div class="form-group">
				<label for="username">Username: </label>
				<input type="text" class="form-control" id="username" placeholder="Enter username" maxlength="20" />
			</div>

			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" class="form-control" id="password" placeholder="Enter password" maxlength="20" />
			</div>

			<div class="form-group">
				<label for="email">Email: </label>
				<input type="email" class="form-control" id="email" placeholder="Enter email" maxlength="50" />
			</div>
		</form>

		<button id="join--submit" class="btn btn-danger">회원가입</button>

	</div>

</div>


<script src="/js/join.js"></script>

<%@include file="../include/footer.jsp"%>