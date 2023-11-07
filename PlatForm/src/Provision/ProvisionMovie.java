package Provision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.MovieVO;

public class ProvisionMovie {
	// 영화 목록
			public void getMovieList() throws Exception {
				String sql = "SELECT * from movie order by no";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				MovieVO mo = null;
				try {
					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					System.out.println("일련번호/영화/장르/개봉일");
					while (rs.next()) {
						mo = new MovieVO();
						mo.setNo(rs.getInt("no"));
						mo.setTitle(rs.getString("title"));
						mo.setGenre(rs.getString("genre"));
						mo.setOpen(rs.getString("open"));
						System.out.println(mo.getNo() + "\t" + mo.getTitle() + "\t" + mo.getGenre() + "\t" + mo.getOpen());
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

			// 영화 등록
			public void setMovieRegiste(Model.MovieVO lvo) throws Exception {
				String sql = "insert into movie (no, title, Genre,open) values (platform_seq.nextval, ?, ?, ?)";
				Connection con = null;
				PreparedStatement pstmt = null;
				try {
					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, lvo.getTitle());
					pstmt.setString(2, lvo.getGenre());
					pstmt.setString(3, lvo.getOpen());
					int i = pstmt.executeUpdate();
					if (i == 1) {
						System.out.println(lvo.getTitle() + " 영화 등록 완료.");
						System.out.println("영화 등록 성공!!!");
					} else {
						System.out.println("영화 등록 실패!!!");
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

			// 영화 수정
			public boolean setMovieUpdate(Model.MovieVO lvo) throws Exception {
				String sql = "update movie set title=?, genre=? , open=? where no =?";
				Connection con = null;
				PreparedStatement pstmt = null;
				boolean lessonUpdateSucess = false;
				try {
					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, lvo.getTitle());
					pstmt.setString(2, lvo.getGenre());
					pstmt.setString(3, lvo.getOpen());
					pstmt.setInt(4, lvo.getNo());
					int i = pstmt.executeUpdate();
					if (i == 1) {
						System.out.println(lvo.getTitle() + " 영화 수정 완료.");
						System.out.println("영화 수정 성공!!!");
					} else {
						System.out.println("영화 수정 실패!!!");
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
				return lessonUpdateSucess;
			}

			// 영화 삭제
			public void setMovieDelete(int no) throws Exception {
				StringBuffer sql = new StringBuffer();
				sql.append("delete from movie where no = ?");
				Connection con = null;
				PreparedStatement pstmt = null;
				try {
					con = DBUtil.makeConnection();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setInt(1, no);
					int i = pstmt.executeUpdate();
					if (i == 1) {
						System.out.println("영화 삭제 완료.");
						System.out.println("영화 삭제 성공!!!");
					} else {
						System.out.println("영화 삭제 실패!!!");
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
			
