<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<div>
	
	</div>
	
	<div>
		<h3>회원 관리</h3>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody>
				<!-- 
					jsp개발자들이 자바를 몰라도 되도록 EL을 만듦.
					EL의 한계:
						제어 구조가 EL에 없음
						오직 출력을 쉽게 표현하기 위한 것이다.
					
					jstl:
						 
				-->
				<c:if test="${users.size()<1}">
					<tr>
						<td colspan="5">검색된 회원이 없습니다.</td>
					</tr>
				</c:if>
				
				<c:forEach var="users" items="${users}">
					<tr>
						<td>${users.id}</td>
						<td>${users.password}</td>
						<td>${users.name}</td>
						<td>${users.tel}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</div>

</body>
</html>