<%@page import="spms.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>InsertTitle</title>

<script type="text/javascript">

</script>

<style type="text/css">

</style>

</head>

<body>

<h1>게시판 목록</h1>
	
		
	<jsp:useBean id="boardList"
		scope="request"
		class="java.util.ArrayList"	
		type="java.util.ArrayList<BoardDto>"
	/>
	
	<%
		for(BoardDto boardDto : boardList){
	%>
	
	<%=boardDto.getNo()%>,
	<a href="./boardDetail?no=<%=boardDto.getNo()%>"><%=boardDto.getTitle()%></a>,
	<%=boardDto.getCreatedDate()%>
	<br>
	<%
		}
	%>


</body>
</html>