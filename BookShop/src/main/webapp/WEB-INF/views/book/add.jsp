<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>도서 등록</div>
	
	<!-- 
		multipart:
			여러 개의 조각을 보내는 것
			웹에서 나온 것이 아니라 메일에서 나온 것이다.
				메일의 내용과 파일을 한번에 보내줘야 함.
				[메일 내용 + 파일] 하나의 박스로 만듦
				어떻게 한 박스에 담을 것인가?
					경계를 만듦. ex)	[{메일 내용}, {파일}]
					수신자는 두 개의 파트를 나눠야 함.
					파트를 나누는 딜리미터를 정해두지는 않음.
					딜리미터를 특정하게 정해줘서 사용.
			
		시리헐:
			[1], [2], [3], [4], [5]
			
		패러럴:
			[1,2,3,4,5]
			
		binary 데이터도 텍스트로 변환해서 보냄
	 -->
	<div>
		<form method="post" enctype="multipart/form-data">
			<div>
				<div><label>도서명:</label></div>
				<div><input type="text" name="bookName"></div>
			</div>
			<div>
				<c:import url="../fileupload.jsp"></c:import>
			</div>
			<div>
				<div><label>출판사:</label></div>
				<div><input type="text" name="publisher"></div>
			</div>
			<div>
				<div><label>가격:</label></div>
				<div><input type="text" name="bookPrice"></div>
			</div>
			<div>
				<div><label>출판일:</label></div>
				<div><input type="date" name="pubDate"></div>
			</div>
			<div>
				<div><button>등록</button></div>
				<div><a href="..">이전</a></div>
			</div>
		</form>
	</div>

</body>
</html>