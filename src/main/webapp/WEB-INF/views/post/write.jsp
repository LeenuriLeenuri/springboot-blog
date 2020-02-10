<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">

	<div class="container">
		<h2>글 쓰기</h2>
		<hr />

		<form>
			<div class="form-group">
				<label for="title">제목: </label>
				<input type="text" class="form-control" id="title" placeholder="Enter title"/>
			</div>

			<div class="form-group">
				<label for="content">내용: </label>
				<textarea class="form-control" rows="5" id="content"></textarea>
			</div>
		</form>

		<button id="write--submit" class="btn btn-danger">등록</button>

	</div>

</div>

<script src="/js/write.js"></script>

<%@include file="../include/footer.jsp"%>