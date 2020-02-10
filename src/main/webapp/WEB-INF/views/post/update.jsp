<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">

	<div class="container">
		<h2>글 수정하기</h2>
		<hr/>
		
		<form>
			<div class="form-group">
				<label for="title">제목: </label> <input type="text" class="form-control" id="title" placeholder="Enter title" values="${post.title}" />
			</div>

			<div class="form-group">
				<label for="content">내용: </label>
				<textarea class="form-control" rows="5" id="content">${post.content}</textarea>
			</div>
		</form>

		<button id="update--submit" value="${post.id}" class="btn btn-danger">수정</button>

	</div>

</div>


<script src="/js/update.js"></script>

<%@include file="../include/footer.jsp"%>