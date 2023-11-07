package Provision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.WatchVO;

public class ProvisionWatch {
	// 영화 시청 목록
	public void getWatchTotalList() throws Exception {
		String sql = "SELECT * from watch";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		WatchVO tVo = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("일련번호|\t\t회원아이디|\t\t플랫폼일련번호|\t\t영화관일련번호");
			while (rs.next()) {
				tVo = new WatchVO();
				tVo.setNo(rs.getInt("no"));
				tVo.setMb_id(rs.getString("mb_id"));
				tVo.setmNo(rs.getInt("m_no"));
				tVo.setpNo(rs.getInt("p_no"));
				System.out.println(tVo.toString());
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	// 시청 목록 삭제
	public void setWatchDelete(int no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from watch where no = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("영화 시청 삭제 완료.");
				System.out.println("영화 시청 삭제 성공!!!");
			} else {
				System.out.println("영화 시청 삭제 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 시청 목록 등록
	public void setInsertWatch(String mb_id, int mNo, int pNo) {
		String sql = "insert into watch values(watch_seq.nextval,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			pstmt.setInt(2, mNo);
			pstmt.setInt(3, pNo);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(mb_id + "시청 목록 등록 완료.");
			} else {
				System.out.println("시청 목록 등록 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}
