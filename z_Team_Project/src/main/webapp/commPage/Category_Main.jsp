<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
	#headWrap{
		border-bottom: solid 1px #E1E1E1;
		margin-left: 100px;
		margin-right: 100px;
	}
	#header{
		color:black;
		height:100px; 


/* 		background-color: #d4c0a5; */
	}
	#headWrap #user_page{
		display: flex; 
		flex: 1; 
		gap: 15px;  /* 항목 간격 70px */
		
	}
	
	#top_MenuBar{
		margin: 0 auto;
		width: 1000px;
		height: 80px;
		text-align: center;
		
/* 		background-color: yellow; */
		
	}
	
	#top_MenuBar ul{
		display: flex;  /* 가로 정렬 */
	    justify-content: center;  /* 가운데 정렬 */
	    gap: 65px;  /* 항목 간격 300px */
		margin-top: 0px;
	    list-style: none; /* 불필요한 리스트 스타일 제거 */
		
	}
	
	.top_Menues span{
		display: flex;
		flex: 1;  /* 모든 버튼 크기를 균등하게 */
	
    	width: 200px;  /* 가로 크기 고정 */
	    height: 80px;  /* 세로 크기 고정 */
	    text-align: center;
	    font-size: 23px;
	    font-weight: 500;
	    	    
	    align-items: center;  /* 세로 중앙 정렬 */
	    justify-content: center;  /* 가로 중앙 정렬 */
	    
	    
/* 	    background-color: red; */
	}
	
	#headWrap a{
		text-decoration: none;  /* a태그 밑줄 제거 */
	    color: black;  /* a태그 텍스트 검은색 */
	}

	#logo img{
		 width: 150px;
	}

</style>
<div id="headWrap">
	<div id="header">
		<span id="logo">
			<a href="메인링크"><img src="../imges/logo.png"></a>
		</span>
		<span id="user_page" style="float:right;">
			<a href="마이페이지 링크">'이름'님 페이지</a>
			<a href="장바구니 링크">장바구니</a>
			<a href="로그아웃 링크">로그아웃</a>
		</span>
	</div>
	
	<div id="top_MenuBar">
		<ul>
			<li class='top_Menues'>
				<a href="다과링크"><span>다과 소개</span></a>
			</li>
			<li class='top_Menues'>
				<a href="구매링크"><span>구매</span></a>
			</li>
			<li class='top_Menues'>
				<a href="행사링크"><span>행사</span></a>
			</li>
			<li class='top_Menues'>
				<a href="게시판링크"><span>고객 게시판</span></a>
			</li>
		</ul>
	</div>
</div>
