<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>

<title>회원 목록</title>

</head>
<body>

	<jsp:include page="/Header.jsp"/>
	<h1>회원목록</h1>

	<p>
		<a href="./add">신규 회원</a>
	</p>

	<jsp:useBean id="memberList"
		scope="request"
		class="java.util.ArrayList"	
		type="java.util.ArrayList<MemberDto>"
	/>
	

	
	<%
		for(MemberDto memberDto : memberList){
	%>
	
	<%=memberDto.getNo()%>,
	<a href="./update?no=<%=memberDto.getNo()%>"><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail()%>,
	<%=memberDto.getCreatedDate()%>,
	<a href="./delete?no=<%=memberDto.getNo()%>">[삭제]</a>
	<br>
	<%
		}
	%>
	
	<button onclick="BoardFnc('<%=request.getContextPath()%>');">게시판으로</button>
	
	
	<jsp:include page="/Tail.jsp"/>

</body>

<script type="text/javascript">
	function BoardFnc(pathStr) {
	//	location.href = pathStr + '/board/BoardList.jsp'; 
		location.href = '../board/BoardList';
	}
</script>
</html>