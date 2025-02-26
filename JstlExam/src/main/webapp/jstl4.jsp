<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>foreach</title>

<script type="text/javascript">

</script>

<style type="text/css">

</style>

</head>

<body>
	<c:forEach var="i" begin="0" end="3"items=${numArr }>
		${numArr}<br>
	</c:forEach>
	<br>
	<c:forEach var="i" begin="0" end="3">
		${strList[i]}<br>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="9">
		2*${i}=${i}<br>
	</c:forEach>

</body>
</html>