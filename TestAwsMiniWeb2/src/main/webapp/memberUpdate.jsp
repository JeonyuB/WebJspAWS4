<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>

	<title>회원정보</title>
<script type="text/javascript">
 	var delContObj = document.getElementById('delCont');
 	
 	onload.window= function (){
		
	   delContObj.addEventListener('click', function() {
 		sql = "DELETE FROM MEMBERS WHERE MNO=?";
 		
 		pstmt = conn.prepareStatement(sql);
	});
 	};
</script>
</head>
<body>
	
	<h1>회원정보</h1>
	
	<form action='./update' method='post'>
		
		번호: <input type='text' name='mNo' value='곧지울거임' readonly='readonly'><br>
		이름: <input type='text' name='mname' value='곧지울거임'><br>
		이메일: <input type='text' name='email' value='곧지울거임'><br>
		가입일: 날짜지울거임<br>
		
		<input type='submit' value='저장'>
		<input id= 'delCont' type='button' value='삭제'>
		<input type='reset' value='취소'>
	</form>
	
</body>
</html>