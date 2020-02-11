$('#login--submit').on('click', function(e) {
	//e.preventDefault();
	var data = {
		username : $('#username').val(),
		password : $('#password').val(),
	};

	$.ajax({
		type : 'POST',
		url : '/user/loginProc',
		data : data, // username=ssar&password=1234 이런식으로 나옴
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		dataType : 'json'
	}).done(function(r, XMLHttpRequest, textStatus) {
		alert("로그인 성공");
		console.log(r);
		console.log(r.statusCode);
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