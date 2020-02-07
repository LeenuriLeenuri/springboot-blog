/**
 * 회원가입 로직 
 */


$('#join--submit').on('click', function() {
		var data = {
			username : $('#username').val(),
			password : $('#password').val(),
			email : $('#email').val()
		};

		$.ajax({
			type : 'POST',
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
					alert('회원가입 실패1');
				}

			}
		}).fail(function(r, XMLHttpRequest, textStatus) {
			alert('회원가입 실패2');
			console.log('XMLHttpRequest: ' + XMLHttpRequest);
			console.log('XMLHttpRequest: ' + XMLHttpRequest.status);
			console.log('textStatus: ' + textStatus);
			console.log('textStatus: ' + textStatus.status);
		});
	});