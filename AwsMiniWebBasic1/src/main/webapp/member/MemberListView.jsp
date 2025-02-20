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
	<h1>회원목록</h1>
	<p>
		<a href="./member/add">신규회원</a>
	</p>
	<%
		ArrayList<MemberDto> memberList =
			(ArrayList<MemberDto>)request.getAttribute("memberList");
		for(MemberDto memberDto : memberList){

	%>
	<%=memberDto.getNo()%>,
	<a href="./update?mNo=<%=memberDto.getNo()%>"><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail()%>,
	<%=memberDto.getCreatedDate() %>,
	<a href="./delete?<%=memberDto.getNo()%>">삭제</a>,
	<br>
	<%
		}
	%>
<!-- 	1, <a href="./update?mNo=1">홍길동</a>, ㄴ디11, ㄴㅇㅁ
	
	<a href="./delete?mNo=1">[삭제]</a> -->
</body>
</html>