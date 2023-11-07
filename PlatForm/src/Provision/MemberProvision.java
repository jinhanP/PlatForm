package Provision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.MemberVO;

public class MemberProvision {
	// 사용자 등록
			public void setMemberRegiste(Model.MemberVO svo) throws Exception {

				String sql = "insert into member (name, phone, mb_id,mb_pw) values (?,?,?,?)";
				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, svo.getName());
					pstmt.setString(2, svo.getPhone());
					pstmt.setString(3, svo.getMb_id());
					pstmt.setString(4, svo.getMb_pw());
					
					int i = pstmt.executeUpdate();
					
					if (i == 1) {
						System.out.println(svo.getName() + "사용자 등록 완료.");
					} else {
						System.out.println("사용자 등록 실패하셨습니다.");
					}
				} catch (SQLException e) {
					System.out.println("e=[" + e + "]");
				} catch (Exception e) {
					System.out.println("e=[" + e + "]");
				} finally {
					try {
						// 데이터베이스와의 연결에 사용되었던 오브젝트 해제
						if (pstmt != null)
							pstmt.close();
						if (con != null)
							con.close();
					} catch (SQLException e) {

					}
				}
			}

			// 사용자 정보 수정
			public boolean setMemberUpdate(MemberVO svo) throws Exception {

				String sql = "update member set name= ?, phon= ?, mb_id=?, mb_pw=?";
				Connection con = null;
				PreparedStatement pstmt = null;
				boolean MemberUpdate = false;
				try {

					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, svo.getName());
					pstmt.setString(2, svo.getPhone());
					pstmt.setString(3, svo.getMb_id());
					pstmt.setString(4, svo.getMb_pw());	

					int i = pstmt.executeUpdate();

					if (i == 1) {
						System.out.println(svo.getName() + "사용자 정보 수정 완료.");
						System.out.println("사용자 등록 성공하셨습니다.");
					} else {
						System.out.println("사용자 등록 실패하셨습니다.");
					}
				} catch (SQLException e) {
					System.out.println("e=[" + e + "]");
				} catch (Exception e) {
					System.out.println("e=[" + e + "]");
				} finally {
					try {
						// 데이터베이스와의 연결에 사용되었던 오브젝트 해제
						if (pstmt != null)
							pstmt.close();
						if (con != null)
							con.close();
					} catch (SQLException e) {

					}
					
				}
				return MemberUpdate;
			}

			// 사용자 로그인
			public boolean getMemberLogin(String mb_id, String mb_pw) throws Exception {

				String sql = "select * from member where mb_id = ? and mb_pw = ?";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				boolean login = false;

				try {
					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mb_id);
					pstmt.setString(2, mb_pw);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						login = true; // 로그인 성공
					}
				} catch (SQLException e) {
					System.out.println("e=[" + e + "]");
				} catch (Exception e) {
					System.out.println("e=[" + e + "]");
				} finally {
					try {
						// 데이터베이스와의 연결에 사용되었던 오브젝트 해제
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (con != null)
							con.close();
					} catch (SQLException e) {

					}
				}
				return login;
			}

			
			//사용자 전체 목록
			public void getMemberTotalList() throws Exception {

				String sql = "SELECT * from member";

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				MemberVO sv = null;

				try {

					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
				

					while (rs.next()) {
						sv = new MemberVO();
						sv.setMb_id(rs.getString("mb_id"));
						sv.setName(rs.getString("name"));
						sv.setPhone(rs.getString("phone"));
						sv.setMb_pw(rs.getString("mb_pw"));

						System.out.println( sv.getName() + "\t" + sv.getPhone() + "\t" + sv.getMb_id() + "\t" + sv.getMb_pw());
					}

				} catch (SQLException se) {
					System.out.println(se);
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					try {
						// 데이터베이스와의 연결에 사용되었던 오브젝트 해제
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
		}

