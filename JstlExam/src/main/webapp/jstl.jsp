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
이름: 직책
<%-- 1안
	<br>
	${teamList[0]}: ${nameMap.oul}
	<br>
	${teamList[1]}: ${nameMap.pcj}
	<br>
	${teamList[2]}: ${nameMap.pju}
	<br>
	${teamList[3]}: ${nameMap.jyb}
	<br>
	 --%>
	 
	 <br>
	${teamList[0]}: ${nameMap[teamList[0]]}
	<br>
	${teamList[1]}: ${nameMap[teamList[1]]}
	<br>
	${teamList[2]}: ${nameMap[teamList[2]]}
	<br>
	${teamList[3]}: ${nameMap[teamList[3]]}
	<br>

<%--2안  	 
	${teamList[0]}: ${nameList[0]}
	 <br>
	 ${teamList[1]}: ${nameList[1]}
	 <br>
	 ${teamList[2]}: ${nameList[2]}
	 <br>
	 ${teamList[3]}: ${nameList[3]}
	 <br>
	 --%> 
	 


</body>
</html>