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
				<label for="title">제목:</label> <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" />
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="5" id="content">내용입니다. EL 표현식</textarea>
			</div>
		</form>

		<button id="update--submit" class="btn btn-danger">수정</button>

	</div>

</div>


<%@include file="../include/footer.jsp"%>