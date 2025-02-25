<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원정보</title>

<script type="text/javascript">

</script>

<style type="text/css">
</style>

</head>

<body>

<!-- request: 서로(자바파일 기타등등)가 공유가 된다는 증거  -->
	<jsp:useBean id="memberList"
		scope="request"
		class="java.util.ArrayList"
		type="java.util.ArrayList<MemberDto>"
	/>
	<%
		for(MemberDto memberDto: memberList){
	%>
	<h1>회원정보 조회</h1>
	<form action='./update' method='post'>
		번호: <input type='text' name='mNo' value='<%=memberDto.getNo()%>' readonly='readonly'><br>
		이름: <input type='text' name='mname' value='<%=memberDto.getName()%>'><br>
		이메일: <input type='text' name='email'><br>
		가입일: <%=memberDto.getCreatedDate()%><br>
		<input type='submit' value='수정'>
		<input type='button' value='삭제' onclick='location.href="./delete?no="<%=memberDto.getNo()%>"'>
		<input type='button' value='취소' onclick='location.href="./list"'>
		
	</form>
	<%
		}
	%>

</body>
</html>