<%@page import="spms.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 회원전용화면되게함. 따로 호출하면 열리지 않는다.(로그인 안하면 에러페이지로 이동.) 
 브라우저 종료까지 실행된다(session)-->   
    
    <jsp:useBean id="memberDto"
    	scope="session"
    	class="spms.dto.MemberDto"
    />
    
 <!-- 아래 파란 코드는 위와 같음. -->
<%-- <%
	MemberDto memberDto = (MemberDto)session.getAttribute("memberDto");
%>
 --%>
<div style="background-color: #00008b; color:#ffffff; height:20px; padding:5px;">
	SPMS(Simple Project Management System)
	<span style="float: right">
		<%=memberDto.getName()%>
		<a style="color:white;" href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>
	</span>
</div>

