<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript">

</script>

<style type="text/css">

</style>

</head>

<body>

	<h2>사용자 로그인</h2>
	
	<form action="./login" method="post">
		<label>email</label>
		<input type="text" name="email" placeholder="ex:hong@test.com" value="">
		<br> 
		
		<label>암호</label>
		<input type="password" name="password" value="">
		<br>
		<input type="submit" value="로그인">
		<br> 
	</form>

</body>
</html>