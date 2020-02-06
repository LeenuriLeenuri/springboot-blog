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

		<form action="user/profile" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label for="uname">Username:</label> <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" value="ssar" readonly />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" value="1234" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="ssar@gmail.com" readonly />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="profile">프로필 사진</label> <input type="file" class="form-control" id="file" name="profile" value="my.jpg" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<button id="update--submit" class="btn btn-danger">수정</button>
			
		</form>



	</div>

</div>


<%@include file="../include/footer.jsp"%>