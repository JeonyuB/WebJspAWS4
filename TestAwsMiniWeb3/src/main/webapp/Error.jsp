<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>시스템 오류</title>

<script type="text/javascript">

</script>

<style type="text/css">

</style>

</head>

<body>
	<%
		Exception e = (Exception)request.getAttribute("error");
		String message = (String)request.getAttribute("message");
	%>
	
	<div><%=e.getMessage()%></div>
	<div><%=message.toString()%></div>
	
	<p>
		지금 입력하신 주소의 페이지는 사라졌거나 다른 페이지로 변경되었습니다. 
		만일 이 페이지가 실행되는 것을 보신다면 즉시 돌아가기를 눌러주십시오.
	</p>
	
	<input type="button" value='돌아가기' onclick='location.href="./add"'/>

</body>
</html>