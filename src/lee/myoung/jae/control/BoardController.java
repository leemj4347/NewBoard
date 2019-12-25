package lee.myoung.jae.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import lee.myoung.jae.db.DBConn;
import lee.myoung.jae.vo.Board;

public class BoardController {
	
	private final Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	public int insert(Board input) {
		int result = 0;
		
		DBConn db = new DBConn();
		try(Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO new_board (title, writer, content)").append("").append("VALUES (?,?,?)");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, input.getTitle());
			pstmt.setString(2, input.getWriter());
			pstmt.setString(3, input.getContent());
			
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public List<Board> selectList(){
		List<Board> result = new ArrayList<Board>();
		
		DBConn db = new DBConn();
		try(Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, title, writer, content, wdate FROM new_board");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board item = new Board();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setWriter(rs.getString("writer"));
				item.setContent(rs.getString("content"));
				item.setWdate(rs.getString("wdate"));
				
				result.add(item);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Board selectOne(Board board) {
		Board result = new Board();
		
		DBConn db = new DBConn();
		try(Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM new_board WHERE id = ?");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getId());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setTitle(rs.getString("title"));
				result.setContent(rs.getString("content"));
				result.setWriter(rs.getString("writer"));
				result.setWdate(rs.getString("wdate"));
			}
		}catch (SQLException e) {
			e.printStackTrace();               
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateBoard(Board board) {
		logger.info(board.toString());
		int result = 0;
		
		DBConn db = new DBConn();
		
		try(Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE new_board SET title= ?, writer = ?, content = ? WHERE id=?");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getId());
			
			logger.info(pstmt.toString());
			
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public int deleteBoard(Board board) {
		int result = 0;
		
		DBConn db = new DBConn();
		
		try(Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("DElETE FROM new_board WHERE id = ?");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getId());
			
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
