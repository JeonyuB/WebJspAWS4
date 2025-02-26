<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>태그 배우기</title>

<script type="text/javascript">

</script>

<style type="text/css">

</style>

</head>

<body>
	배열
	<br>
	${numArr[0]}
	${numArr[1]}
	${numArr[2]}
	${numArr[3]}
	
	<br>
	${strList[0]}
	${strList[1]}
	${strList[2]}
	${strList[3]}
	<br>
	
	${nameMap.pcj}
	${nameMap.jhs}
	${nameMap.our}
	${nameMap.jyb}
	<br>
	<!-- 값이 비어있거나 null인지를 조사할 떄 사용하는 연산자 -->
	${empty nameMap}, 	${empty tempObj}
	
</body>
</html>