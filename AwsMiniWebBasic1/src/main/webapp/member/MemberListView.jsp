
<%@page import="jakarta.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<title>회원목록</title>
</head>
<body>

	<jsp:include page="/Header.jsp"/>

	<h1>회원목록</h1>
	<p>
		<a href="./add">신규회원</a>
	</p>
<!-- request: 서로(자바파일 기타등등)가 공유가 된다는 증거  -->
	
	<c:forEach var="memberDto" items="${memberList}"> 
		${memberDto.getNo()},
		<a href="./update?mNo=${memberDto.getNo() }">${memberDto.getName() }</a>,
		${memberDto.getEmail() },
		${memberDto.getCreatedDate() }
		<a href="./delete?mNo=${memberDto.getNo() }">[삭제]</a>
		<br>
	</c:forEach>

	
	
	<jsp:include page="/Tail.jsp"/>
<!-- 	1, <a href="./update?mNo=1">홍길동</a>, ㄴ디11, ㄴㅇㅁ
	
	<a href="./delete?mNo=1">[삭제]</a> -->
</body>
</html>