<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>사용자 등록</div>
	
	<div>
		<form method="post">
			<div>
				<div><label>${user.id}</label></div>
			</div>
			<div>
				<div><label>비밀번호:</label></div>
				<div><input type="text" name="password" value="${user.password}"></div>
			</div>
			<div>
				<div><label>성명:</label></div>
				<div><input type="text" name="name" value="${user.name}"></div>
			</div>
			<div>
				<div><label>전화번호:</label></div>
				<div><input type="text" name="tel" value="${user.tel}"></div>
			</div>
			<div>
				<div><button>변경</button></div>
				<div><a href="..">이전</a></div>
			</div>
		</form>
	</div>

</body>
</html>