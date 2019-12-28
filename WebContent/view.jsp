<%@page import="lee.myoung.jae.control.BoardController"%>
<%@page import="lee.myoung.jae.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% int id = Integer.parseInt(request.getParameter("id")); 
    	Board param = new Board();
    	param.setId(id);
    	
    	BoardController control = new BoardController();
    	Board board = control.selectOne(param);
    %>
<html>
<head>
	<meta charset="UTF-8">
	<title>전주코딩학원</title>
	<link rel="stylesheet" href="./css/css.css">
</head>
<body>
	<div id="wrap">
		<div id="headerWrap"></div>
		<div id="containerWrap">
            <div class="contTitle">
                <div>
                    <strong>학원소식</strong>
                    <p>
                        "위대한 일을 해낼 수 없다면 작은 일을 위대하게 행하라."
                        <span>- 마틴 루터 킹</span>
                    </p>
                </div>
            </div>
			<div class="board_view_wrap">
                <div class="board_view">
                    <div class="category">학원소식</div>
                    <div class="etc">
                        <span><%=board.getWriter() %></span>
                        <span><%=board.getWdate() %></span>
                    </div>
                    <div class="title"><a href="#"><%=board.getTitle() %></a></div>
                    <div class="image"><a href="#"><img src="./img/1.jpeg" alt="사진"></a></div>
                    <div class="cont"><%=board.getContent() %></div>
                    <div class="link">
                        <strong>참고링크</strong>
                        <a href="https://www.naver.com" target="_blank">(https://www.naver.com)</a>
                    </div>
                </div>
				<div class="bt_wrap">
					<a href="./list.jsp" class="bt1 on">목록</a>
					<a href="./editForm.jsp?id=<%=board.getId()%>" class="bt1">수정</a>
					<a href="./delete.jsp?id=<%=board.getId()%>" class="bt1">삭제</a>
				</div>
			</div>
		</div>
		<div id="footerWrap"></div>
	</div>
</body>
</html>
    