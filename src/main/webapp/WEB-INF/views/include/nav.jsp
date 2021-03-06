<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링으로 블로그 만들기 연습</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

	<nav class="navbar navbar-expand-md navbar-dark" style="background: #6600FF">
		<!-- Brand -->
		<a class="navbar-brand" href="/">💎</a>

		<!-- Toggler/collaps Button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- Navbar links -->
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">

				<!-- 둘다 GET 방식, JOIN은 Proc 만들기 싫으면 POST로 보내기  -->

				<c:choose>
					<c:when test="${not empty sessionScope.principal}">
						<li class="nav-item"><a class="nav-link" href="/post/write">글 쓰기</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/profile/${sessionScope.principal.id}">회원정보 수정</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/logout">로그아웃</a></li>

					</c:when>

					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="/user/join">회원가입</a></li>

						<li class="nav-item"><a class="nav-link" href="/user/login">로그인</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
			
			<!-- 에러가 나서 사진에 엑박 뜨는 것을 방지하려고 onerror 타입 넣어줬다 -->
			<img src="/media/${sessionScope.principal.profile}"  class="rounded-circle my__img ml-auto" 
			     width="30px" height="30px" onerror="javascript:this.src = '/images/unknown.jpg' " />
			
		</div>
	</nav>
	<br>