<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${root}/js/add.js"></script>
</head>
<body>
	<!-- 추후 다른 곳에서도 파일 업로드가 쓰일 때와 유지보수를 위해 파일 부분 모듈화 시도 -->
	<div class="row mb-2">
		<div>
			<div class="col-2"><label>이미지 파일 : </label></div>
			<div class="col"><div class="btn btn-primary btn-sm" id="file_add">추가</div></div>
		</div>
		<div>
			<ul class="col" id="files">
				<li>
					<input type="file" name="files" multiple accept="image/*" class="form-control form-control-sm mb-2">
				</li>
			</ul>
		</div>	<!-- 다중 이미지 파일 업로드 -->
	</div>
</body>
</html>