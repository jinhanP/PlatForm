package Provision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.PlatFormVO;

public class ProvisionPlatForm {
	// 플랫폼 목록
	public void getPlatFormTotalList() throws Exception {
		String sql = "SELECT * from platform";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PlatFormVO pf = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("일련번호\t플랫폼\t가격");
			while (rs.next()) {
				pf = new PlatFormVO();
				pf.setNo(rs.getInt("no"));
				pf.setName(rs.getString("name"));
				pf.setPrice(rs.getInt("price"));
				System.out.println(pf.getNo() + "\t" + pf.getName() + "\t" + pf.getPrice());
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

	// 플랫폼 등록
	public void setPlatFormRegiste(Model.PlatFormVO pf) throws Exception {
		String sql = "insert into platform (no, name, price) values (platform_seq.nextval, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pf.getName());
			pstmt.setInt(2, pf.getPrice());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(pf.getName() + " TV플랫폼 등록 완료.");
				System.out.println("TV플랫폼 등록 성공!!!");
			} else {
				System.out.println("TV플랫폼 등록 실패!!!");
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

	// 플랫폼 수정
	public boolean setPlatFormUpdate(Model.PlatFormVO lvo) throws Exception {
		String sql = "update platform set name=?, price=? where no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean PlatFormUpdateSucess = false;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lvo.getName());
			pstmt.setInt(2, lvo.getPrice());
			pstmt.setInt(3, lvo.getNo());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(lvo.getName() + " TV플랫폼 수정 완료.");
				System.out.println("TV플랫폼 수정 성공!!!");
			} else {
				System.out.println("TV플랫폼 수정 실패!!!");
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
		return PlatFormUpdateSucess;
	}

	// 플랫폼 삭제
	public void setPlatFormDelete(int no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from platform where no = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("TV플랫폼 삭제 완료.");
				System.out.println("TV플랫폼 삭제 성공!!!");
			} else {
				System.out.println("TV플랫폼 삭제 실패!!!");
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

