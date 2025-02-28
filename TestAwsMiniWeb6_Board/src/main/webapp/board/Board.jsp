<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	

<head>
<meta charset="UTF-8">
<title>게시판 테이블</title>

<script type="text/javascript">
	
</script>

<style type="text/css">

	div{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	.contents{ 
		width: 300px;
		height: 50px;
	}
	table, tr, td {
		border: 1px solid black;
		border-collapse:collapse;

	};
	
</style>

</head>

<jsp:useBean id="boardDto"
	scope="request"
	class="spms.dto.BoardDto"/>

<body>
<div>
	<table border=1 width="800" height="800">
		<tr>
			<td>
				제목
			</td>
			<td class="contents" colspan="3" >
				빈칸
			</td>
		</tr>
		<tr>
			<td>
				작성자명
			</td>
			<td class="contents" >
				빈칸
			</td>
			<td>
				이메일
			</td>
			<td class="contents" >
				빈칸
			</td>
		</tr>
		<tr>
			<td>
				게시판 생성 날짜
			</td>
			<td class="contents" colspan="3">
				빈칸
			</td>
		</tr>
		<tr>
			<td>
				게시판 수정 날짜
			</td>
			<td class="contents" colspan="3">
				빈칸
			</td>
		</tr>
		<tr>
			<td id="container" colspan='4'>
			빈칸
			</td>
		<tr>
	</table>
</div>


</body>
</html>