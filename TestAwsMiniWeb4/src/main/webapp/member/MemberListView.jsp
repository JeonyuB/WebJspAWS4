<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

	<title>회원목록</title>
</head>
<body>

	<jsp:include page="/Header.jsp"/>

	<h1>회원목록</h1>
	<p>
		<a href="./add">신규회원</a>
	</p>
<!-- request: 서로(자바파일 기타등등)가 공유가 된다는 증거  -->
	<jsp:useBean id="memberList"
		scope="request"
		class="java.util.ArrayList"
		type="java.util.ArrayList<MemberDto>"
	/>
	<%
		for(MemberDto memberDto: memberList){
	%>
	<%=memberDto.getNo()%>,
	<a href="./update?mNo=<%=memberDto.getNo()%>"><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail()%>,
	<%=memberDto.getCreatedDate() %>,
	<a href="./delete?mNo=<%=memberDto.getNo()%>">[삭제]</a>
	<br>
	<%
		}
	%>
	
	
	<jsp:include page="/Tail.jsp"/>
<!-- 	1, <a href="./update?mNo=1">홍길동</a>, ㄴ디11, ㄴㅇㅁ
	
	<a href="./delete?mNo=1">[삭제]</a> -->
</body>
</html>