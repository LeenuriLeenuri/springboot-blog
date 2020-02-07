<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">

	<div class="container">
		<h2>Form Validation</h2>
		<p>
			In this example, we use
			<code>.was-validated</code>
			to indicate what's missing before submitting the form:
		</p>

		<form>
			<div class="form-group">
				<label for="username">Username:</label> <input type="text" class="form-control" id="username" placeholder="Enter username" maxlength="20" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="password">Password:</label> <input type="password" class="form-control" id="password" placeholder="Enter password" maxlength="20" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Enter email" maxlength="50" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
		</form>

		<button id="join--submit" class="btn btn-danger">회원가입</button>

	</div>

</div>


<script src="/js/join.js"></script>

<%@include file="../include/footer.jsp"%>