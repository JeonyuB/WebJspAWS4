<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title> EL 태그 배우기(자바코드를 화면으로 출력)</title>

<style type="text/css">

</style>

<script type="text/javascript">

</script>

</head>

<body>
	문자열
	${"test"}
	${'1234'}
	
	<br>
	숫자
	${1234 + 9999}
	${true}
	${null} 연습용
	<br>
	\${10 div 4} : ${10 div 4}--div는 /
	\${10 mod 4} : ${10 mod 4}--mod는 \
	<br>
	${true && false} : ${true && false}
	${not false} : ${not false}
	${!true} : ${!true}
	<br>
	${100 eq 100}--같은가(equal)
	${10 != 11}-- 다른가
	${10 ne 11}--다른가(negative)
	${10 lt 11}--오른쪽이 더 큰가(<)
	${10 gt 11}--왼쪽이 더 큰가(>)
	${10 le 11}--오른쪽이 더 크거나 같은가(<=)
	
</body>
</html>