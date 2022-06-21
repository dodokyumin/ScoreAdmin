package kr.ac.kopo.ctc.kopo44.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxSession.Reset;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;

public class ScoreItemDaoImpl implements ScoreItemDao {

	public ScoreItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패..!");
		}
	}

	// C
	@Override
	public ScoreItem insertOne(ScoreItem scoreItem) {
		// PreparedStatement 동적 쿼리 생성 : Insert, update, delete 여러번 할 때 고속
		String sql = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?)";
		int result = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, scoreItem.getName());
			pstmt.setInt(2, scoreItem.getStudentid());
			pstmt.setInt(3, scoreItem.getKor());
			pstmt.setInt(4, scoreItem.getEng());
			pstmt.setInt(5, scoreItem.getMat());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("insert 실패 " + e.getMessage());
		}
		return scoreItem;
	}

	@Override
	public List<ScoreItem> selectAll(int startIndex, int countPerPage) {
		List<ScoreItem> results = new ArrayList<>();

		String sql = "SELECT * FROM " + TABLE_NAME + " LIMIT ?, ?";
		// TRY RESOURCE CATCH문
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, startIndex - 1);
			pstmt.setInt(2, countPerPage);
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					String name = rs.getString("name");
					int studentid = rs.getInt("studentid");
					int kor = rs.getInt("kor");
					int eng = rs.getInt("eng");
					int mat = rs.getInt("mat");

					ScoreItem scoreitem = new ScoreItem();
					scoreitem.setName(name);
					scoreitem.setStudentid(studentid);
					scoreitem.setKor(kor);
					scoreitem.setEng(eng);
					scoreitem.setMat(mat);

					results.add(scoreitem);
				}
			}
		} catch (SQLException e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		return results;
	}

	// U
	@Override
	public ScoreItem updatetOne(ScoreItem ScoreItem) {
		String sql = "UPDATE " + TABLE_NAME + " SET name= ?, kor=?, eng=?, mat=? WHERE studentid = ?";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			// pstmt.setString(1, TABLE_NAME);
			pstmt.setString(1, ScoreItem.getName());
			pstmt.setInt(2, ScoreItem.getKor());
			pstmt.setInt(3, ScoreItem.getEng());
			pstmt.setInt(4, ScoreItem.getMat());
			pstmt.setInt(5, ScoreItem.getStudentid());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			// throw new IllegalStateException("update 실패 " + e.getMessage());
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ScoreItem;
	}

	// D
	@Override
	public int deleteOne(int studentid) {
		String sql = "delete from examtable where studentid=?";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, studentid);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}

		return result;
	}

	// R
	@Override
	public ScoreItem selectOne(int studentid) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE studentid=" + studentid;
		ScoreItem scoreItem;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery(sql);) {
				rs.next();
				scoreItem = new ScoreItem();
				scoreItem.setName(rs.getString("name"));
				scoreItem.setStudentid(rs.getInt("studentid"));
				scoreItem.setKor(rs.getInt("kor"));
				scoreItem.setEng(rs.getInt("eng"));
				scoreItem.setMat(rs.getInt("mat"));
			}

		} catch (SQLException e) {
			throw new IllegalStateException("selectOne 실패 " + e.getMessage());
		}
		return scoreItem;

	}

	@Override
	public int RowCount() {

		int rowcount = 0;
		try (
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT COUNT(*) FROM " + TABLE_NAME);
			){

			while (rset.next()) {
				rowcount = rset.getInt(1);
			}

		} catch (SQLException e) {
			throw new IllegalStateException("count 실패 " + e.getMessage());
		}
		return rowcount;
	}

}
