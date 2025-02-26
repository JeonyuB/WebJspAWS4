<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>CoreTest.jsp</title>

<script type="text/javascript">

</script>

<style type="text/css">

</style>

</head>

<!-- jstl 태그
Core 접두사 c
 -->
 <c:set var="num" value="1"/>
 <c:set var="str" value="뭐임"/>
 <c:set var="userNum" value="라르크" scope="session"/>
 <c:set var="userNum" value="빰빠" scope="request"/> 

<body>

  
	1.<c:out value="출력할 값"/><br>
	2.<c:out value="${userName}"/><br>
	3.<c:out value="${tempObj}" default="core jstl 문법"/><br>
	<br>
	4${num}<br>
	5${str}<br>
	6${userNum}<br>
	7${sessionScope.userName}<br>
	8${requestScope.userName}<br>
	
	<%
		String[] modelStr = new String[]{"홍길동", "잭슨", "피의 화요일"};
		pageContext.setAttribute("coreFor", modelStr);
	%>
	<br>
	<c:forEach var="model" items="${coreFor}" varStatus="iii">
		${model}/${iii.index}<br>
	</c:forEach>
	
	<br>
	
	<c:forEach var="model" begin="1" end="6">
		<h${model}>JSTL 예제${model}<</h${model}>
	</c:forEach>

</body>
</html>