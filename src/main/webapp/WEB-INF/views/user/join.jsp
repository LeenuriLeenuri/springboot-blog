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
				<label for="uname">Username:</label> <input type="text" class="form-control" id="username" placeholder="Enter username" name="uname" maxlength="20" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="pswd" maxlength="20" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Enter email" name="uname" maxlength="50" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
		</form>

		<button id="join--submit" class="btn btn-danger">회원가입</button>

	</div>

</div>


<script>
	$('#join--submit').on('click', function() {
		let data = {
			username : $('#username').val(),
			password : $('#password').val(),
			email : $('#email').val()
		};

		$.ajax({
			tyep : 'POST',
			url : '/user/join',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'

		}).done(function(r) {
			if (r.statusCode == 200) {
				alert('회원가입 성공');
				location.href = '/user/login';
			} else {
				if (r.msg == '아이디중복') {
					alert('아이디가 중복 되었습니다.');
				} else {
					alert('회원가입 실패');
				}

			}
		}).fail(function(r, XMLHttpRequest, textStatus) {
			alert('회원가입 실패');
			console.log('XMLHttpRequest: ' + XMLHttpRequest);
			console.log('XMLHttpRequest: ' + XMLHttpRequest.status);
			console.log('textStatus: ' + textStatus);
			console.log('textStatus: ' + textStatus.status);
		});
	});
</script>


<%@include file="../include/footer.jsp"%>