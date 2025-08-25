<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		BOOKSHOP
	</div>
	
	<!-- 2025.08.25 -->
	<!-- session을 불러 session에 있는 객체의 값이 비어있으면 로그인 버튼을 보임 -->
	<c:if test="${sessionScope.users==null}">	<!-- 세션에 로그인한 유저의 정보가 없다면 -->
		<div>
			<div>
				<a href="login">로그인</a>
			</div>
		</div>
	</c:if>
	
	<!-- 로그인한 유저일 경우 환영 텍스트와 로그아웃 버튼 보이게 함. -->
	<c:if test="${sessionScope.users!=null}">	<!-- 세션에 로그인 유저의 정보가 비어있지 않다면 -->
		<div>
			<div>${sessionScope.users.name}${sessionScope.users.id}님 환영합니다.</div>
			<div><a href="logout">로그아웃</a></div>
		</div>
	</c:if>
	
	<!-- 2025.08.22 -->
	<div>
		<div>
			<a href="users/list">사용자 관리</a>
			<a href="book/list">도서 관리</a>		
			<a href="orders/list">주문 관리</a>
		</div>
	</div>


</body>
</html>