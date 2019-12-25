<%@page import="lee.myoung.jae.control.BoardController"%>
<%@page import="lee.myoung.jae.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	int id = Integer.parseInt(request.getParameter("id"));
	
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setId(id);
	
	out.print(board.toString());
	
	BoardController control = new BoardController();
	int result = control.updateBoard(board);
	
	out.print("result ="+result);
%>
<script type="text/javascript">
	alert("수정이 완료되었습니다.");
	window.location.replace("list.jsp");
</script>