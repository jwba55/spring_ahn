<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>도서 등록</div>
	
	<div>
		<form method="post">
			<div>
				<div><label>도서명:</label></div>
				<div><input type="text" name="bookName"></div>
			</div>
			<div>
				<div><label>출판사:</label></div>
				<div><input type="text" name="publisher"></div>
			</div>
			<div>
				<div><label>가격:</label></div>
				<div><input type="text" name="price"></div>
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