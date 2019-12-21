<%@page import="lee.myoung.jae.control.BoardController"%>
<%@page import="lee.myoung.jae.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Board board = new Board();
	board.setTitle(title);
	board.setContent(content);
	
	out.print(board.toString());
	
	BoardController control = new BoardController();
	int result = control.insert(board);
	
	out.print("result ="+ result);
%>
<script type="text/javascript">
	alert("작성이 완료되었습니다.");
	window.location.replace("list.jsp");
</script>