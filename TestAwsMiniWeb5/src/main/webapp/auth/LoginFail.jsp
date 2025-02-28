<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" http-equiv='Refresh' content='10; url=./login'>

<title>로그인 실패</title>

<style type="text/css">

</style>

<script type="text/javascript">
	function loginFnc(pathStr) {
		location.href = pathStr + '/auth/LoginForm.jsp'; 
	}
</script>

</head>

<body>

	<h1>로그인 실패</h1>
	
	<pre>
		아이디 또는 비밀번호가 잘못 되었다.
		다시 시도하거나 아이디, 비번 찾기 ㄱㄱ
		
		잠시 후에 다시 로그인 화면으로 이동함
	</pre>
	
	<button onclick="loginFnc('<%=request.getContextPath()%>');">로그인 페이지로 이동</button>
	
	
</body>
</html>