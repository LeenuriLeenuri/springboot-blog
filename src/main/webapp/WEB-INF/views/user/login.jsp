<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">

	<div class="container">
		<h2>Login</h2>
		<hr/>

		<form>
			<div class="form-group">
				<label for="username">Username: </label>
				<input type="text" class="form-control" id="username" placeholder="Enter username" />
			</div>

			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" class="form-control" id="password" placeholder="Enter password" />
			</div>
		</form>

		<button id="login--submit" class="btn btn-danger">로그인</button>

	</div>

</div>

<script>
	$('#login--submit').on('click', function(e) {
		//e.preventDefault();
		var data = {
			username : $('#username').val(),
			password : $('#password').val(),
		};

		$.ajax({
			type : 'POST',
			url : '/user/login',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(r, XMLHttpRequest, textStatus) {
			alert("로그인 성공");
			console.log(r);
			location.href = "/";

			console.log('XMLHttpRequest: ' + XMLHttpRequest);
			console.log('XMLHttpRequest: ' + XMLHttpRequest.status);
			console.log('textStatus: ' + textStatus);
			console.log('textStatus: ' + textStatus.status);
		}).fail(function(r, XMLHttpRequest, textStatus) {
			alert("로그인 실패");
			console.log(r);

			console.log('XMLHttpRequest: ' + XMLHttpRequest);
			console.log('XMLHttpRequest: ' + XMLHttpRequest.status);
			console.log('textStatus: ' + textStatus);
			console.log('textStatus: ' + textStatus.status);
		});
	});
</script>

<%@include file="../include/footer.jsp"%>