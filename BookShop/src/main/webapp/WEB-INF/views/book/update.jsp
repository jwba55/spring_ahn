<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div>도서 정보 수정</div>
	
	<div>
		<form method="post" action="/book/update">
			<input type="hidden" name="bookId" value="${book.bookId}">
			<div>
				<div><label>도서명:</label></div>
				<div><input type="text" name="bookName" value="${book.bookName} "></div>
			</div>
			<div>
				<div><label>출판사:</label></div>
				<div><input type="text" name="publisher" value="${book.publisher} "></div>
			</div>
			<div>
				<div><label>가격:</label></div>
				<div><input type="text" name="bookPrice" value="${book.bookPrice} "></div>
			</div>
			<div>
			
				<fmt:parseDate value="${book.pubDate}" var="pubDate" pattern="yyyy-MM-dd HH:mm:ss"/>
				
				 
				<div><label>출판일:</label></div>
				<div><input type="date" name="pubDate" value="<fmt:formatDate value="${pubDate}" pattern="yyyy-MM-dd"/>"></div>
			</div>
			<div>
				<div><button>변경</button></div>
				<div><a href="..">이전</a></div>
			</div>
		</form>
	</div>

</body>
</html>