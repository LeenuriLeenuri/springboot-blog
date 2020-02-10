<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>


<div class="container">
	<h2>목록</h2>
	<hr />
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>No.</th>
				<th>Title</th>
				<th>Author</th>
				<th>CreateDate</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="post" items="${posts}">
				<tr>
					<td>${post.id}</td>
					<td><a href="/post/detail/${post.id}">${post.title}</a></td>
					<td>${post.username}</td>
					<td>${post.createDate}</td>
<%-- 					<td><fmt:formatDate value="${post.createDate}"pattern=" E요일 HH:mm" type="time" /></td> --%>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>


<%@include file="../include/footer.jsp"%>