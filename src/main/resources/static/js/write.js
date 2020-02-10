$('#write--submit').on('click', function(e) {
	//e.preventDefault();

	//등록되면 타이틀, 컨텐트 들고온다.
	var data = {
		title : $('#title').val(),
		content : $('#content').val()
	};

	$.ajax({
		type : 'POST',
		url : '/post/write',
		data : JSON.stringify(data),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json'
	}).done(function(r, XMLHttpRequest, textStatus) {

		if (r.statusCode == 200) {
			alert("글 쓰기 성공");
			console.log(r);
			location.href = "/";
		} else {
			alert("글쓰기 실패");
		}

		console.log('XMLHttpRequest: ' + XMLHttpRequest);
		console.log('XMLHttpRequest: ' + XMLHttpRequest.status);
		console.log('textStatus: ' + textStatus);
		console.log('textStatus: ' + textStatus.status);
	}).fail(function(r, XMLHttpRequest, textStatus) {
		alert("글쓰기 실패");
		console.log(r);

		console.log('XMLHttpRequest: ' + XMLHttpRequest);
		console.log('XMLHttpRequest: ' + XMLHttpRequest.status);
		console.log('textStatus: ' + textStatus);
		console.log('textStatus: ' + textStatus.status);
	});
});