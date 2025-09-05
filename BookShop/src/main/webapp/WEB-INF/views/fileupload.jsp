<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 추후 다른 곳에서도 파일 업로드가 쓰일 때와 유지보수를 위해 파일 부분 모듈화 시도 -->
	<div>
		<div>이미지 파일 :</div>
		<div><input type="file" name="files" multiple accept="image/*"></div>	<!-- 다중 이미지 파일 업로드 -->
	</div>
</body>
</html>