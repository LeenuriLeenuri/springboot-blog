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
				<label for="uname">Username:</label> <input type="text" class="form-control" id="username" placeholder="Enter username" name="uname" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="pswd" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
		</form>
		
		<button id="login--submit" class="btn btn-danger">로그인</button>
		
	</div>

</div>


<%@include file="../include/footer.jsp"%>