package com.yedam.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.board.vo.BoardVO;
import com.yedam.common.DAO;

public class BoardDAO {
	//목록 단건조회 등록 수정 삭제
	
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	String sql;
	
	public void close() {
		try {
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			if(conn != null)
				conn.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardVO> boardList(){
		conn = DAO.getConnect();
		sql = "SELECT * FROM tbl_board order by brd_no desc";
		List<BoardVO> list =new ArrayList<BoardVO>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreatedate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	
	public List<BoardVO> boardListPaging(int page){
		List<BoardVO> list =new ArrayList<BoardVO>();
		conn = DAO.getConnect();
		sql = "SELECT *\r\n"
				+ "FROM (  SELECT rownum rn, a.*\r\n"
				+ "              FROM(   SELECT * FROM tbl_board\r\n"
				+ "                            ORDER BY brd_no DESC\r\n"
				+ "                        ) a\r\n"
				+ "                )b\r\n"
				+ "WHERE b.rn > ((? - 1) * 10)  AND b.rn <= (? * 10)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, page);
			pst.setInt(2, page);
			
			rs = pst.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreatedate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public int getTotalCnt() {
		conn = DAO.getConnect();
		sql = "SELECT COUNT(1) FROM tbl_board";
		try {
			pst = conn.prepareStatement(sql);
			if(pst.executeUpdate() > 0) {
				rs = pst.executeQuery();
				while(rs.next())
					return rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean insertBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql = "INSERT INTO tbl_board(brd_no,brd_title,brd_writer, brd_content)"
				+ " VALUES (board_seq.nextval, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getBrdTitle());
			pst.setString(2, vo.getBrdWriter());
			pst.setString(3, vo.getBrdContent());
			
			if(pst.executeUpdate() > 0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql = "UPDATE tbl_board SET brd_title =?, brd_content=? WHERE brd_no = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getBrdTitle());
			pst.setString(2, vo.getBrdContent());
			pst.setLong(3, vo.getBrdNo());
			
			if(pst.executeUpdate() > 0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBoard(Long vo) {
		conn = DAO.getConnect();
		sql = "DELETE FROM tbl_board WHERE brd_no = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, vo);
			
			if(pst.executeUpdate() > 0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public BoardVO selectBoard(long no) {
		conn = DAO.getConnect();
		sql = "SELECT * FROM tbl_board WHERE brd_no =?";
		List<BoardVO> list =new ArrayList<BoardVO>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, no);
			rs = pst.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreatedate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));
				
				upCount(vo.getBrdNo());
				return vo;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}

	public void upCount(long no) {
		sql = "UPDATE tbl_board set click_cnt = click_cnt +1 WHERE brd_no = ?";
		conn = DAO.getConnect();
		try {
			pst = conn.prepareStatement(sql);
			pst.setLong(1, no);
			int r = pst.executeUpdate();
			if( r > 0)
				System.out.println(r + "건 변경");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
