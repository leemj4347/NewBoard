<%@page import="lee.myoung.jae.vo.Board"%>
<%@page import="lee.myoung.jae.control.BoardController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strId = request.getParameter("id");
	int id = Integer.parseInt(strId);
	
	Board board = new Board();
	board.setId(id);
	
	BoardController control = new BoardController();
	int result = control.deleteBoard(board);	
%>
<script type="text/javascript">
	alert("삭제 완료되었습니다.");
	window.location.replace("list.jsp");
</script>