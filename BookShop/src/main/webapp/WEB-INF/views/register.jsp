<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}" /> <!-- 프로젝트 내의 절대 경로를 잡기 위해서 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${root}/js/signup.js"></script>
<script src="${root}/js/inputCheck.js"></script>
</head>
<body>
	<div>사용자 등록</div>
	
	<!-- 2025.08.26 -->
	<!-- validation
		프론트에서:
			JS를 이용해서 서버의 부하를 최소화 시킴
			클라이언트에서 수정할 수 있다는 단점이 있음
		백엔드에서:
			서버에서 받아서 검증을 함.
			request를 받았다가 다시 돌아가야하는 단점이 있음. -->
			
	<!--
		head에 있는거는 한번만 읽고 끝.
		body는 dom에 올라가서 다시 처리할 수도 있음.
		dom이 아직 안만들어졌다면 eventHandler를 걸 수가 없음.
		
		loadEvent
			js를 읽어서 html로 만들어서 보내주면 html을 parsing 함.
			body안에 있는 태그들을 메모리에 dom이라는 구조로 만듦.
			dom이 완성되고 lenderer가 돌게됨.
			
			loadEvent는 dom이 완성되고 파싱이 끝났을 때 실행됨.
				dom이 아직 안만들어졌을 경우 생기는 문제를 방지하기 위해서 loadEvent를 사용함.
		
		동적으로 변할 필요가 있는 경우 body에 작성.
			그렇지 않을 경우 head에 작성.
	 -->
	<div>
		<form method="post">
			<div>
				<div><label>아이디:</label></div>
				<div><input type="text" name="id"></div>
			</div>
			<div>
				<div><label>비밀번호:</label></div>
				<div><input type="text" name="password"></div>
			</div>
			<div>
				<div><label>성명:</label></div>
				<div><input type="text" name="name"></div>
			</div>
			<div>
				<div><label>전화번호:</label></div>
				<div><input type="text" name="tel"></div>
			</div>
			<div>
				<div><button type="button" id="submit">등록</button></div>
				<div><a href=".."><button type="button">취소</button></a></div>
			</div>
		</form>
	</div>	
</body>
</html>