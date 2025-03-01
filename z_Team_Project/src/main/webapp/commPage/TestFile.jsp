<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>메인 테스트</title>

<script type="text/javascript">

</script>

<style type="text/css">
	#container{
	
		margin: auto;
		width: 1200px;
		height: 1200px;
		background-color: lightgray;
		
	}
</style>

</head>

<body>
	<jsp:include page="./Category_Main.jsp"/>
	
	<div id="container"></div>

	<jsp:include page="./Move_MrgPage.jsp"/>
	<jsp:include page="./Footer.jsp"/>
	

</body>
</html>