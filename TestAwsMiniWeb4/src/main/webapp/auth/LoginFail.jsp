<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" http-equiv="Refresh" content='10; url=./login'>
<title>시스템 오류</title>

<script type="text/javascript">
	function loginFnc(pathStr) {
		location.herf = pathStr +'/auth/loginForm.jsp';
	}
</script>

<style type="text/css">

</style>

</head>

<body>
	<h1>로그인 실패</h1>
	
	<pre> 
	잘못된 아이디, 혹은 비밀번호 시도. 재시도 바람.
	잠시 후 로그인 페이지로 이동한다.
	</pre>
	
	<button onclick="loginFnc('<%=request.getContextPath() %>');"> 로그인 페이지로 이동</button>

</body>
</html>