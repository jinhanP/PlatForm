package Provision;

import java.util.Scanner;

import Model.MemberVO;

public class MemberProvisionMain {
	//사용자 정보 등록
		public void	MemberRegistr() throws Exception {
			Scanner ip = new Scanner(System.in);
			
			MemberProvision sdao = new MemberProvision();
			MemberVO svo = new MemberVO();
			MemberProvision sd = new MemberProvision();
			
			
			String name;//이름
			String phon; //번호
			String mb_id;//아이디
			String mb_pw = null; //비밀번호
			
			
			
			
			System.out.println("사용자 정보 입력");
			System.out.println("이름 :");
			name = ip.nextLine();
			System.out.println("폰 번호 :");
			phon = ip.nextLine();
			System.out.println("아이디 :");
			mb_id = ip.nextLine();
			ip.nextLine();
			System.out.print("비밀번호 : ");
			mb_pw = ip.nextLine();
			svo.setName(name);
			svo.setPhone(phon);
			svo.setMb_pw(mb_pw);
			svo.setMb_id(mb_id);
			sdao.setMemberRegiste(svo);
			
			System.out.println();
			System.out.println("등록 사용자 정보");
			sd.getMemberLogin(mb_id, mb_pw);
			System.out.println();
			
		}
		
		//사용자 정보 수정
		public void MemberUpdate() throws Exception {
			Scanner ip = new Scanner(System.in);
			
			MemberProvision sdao = new MemberProvision();
			MemberVO svo = new MemberVO();
			
			String name; //이름
			String mb_id;//아이디
			String mb_pw;//입력 비밀번호
			int phone; //폰 번호
			
			boolean success = false;
			
			System.out.println("사용자 정보 수정");
			do {
					System.out.print("아이디 : ");
					mb_id = ip.nextLine();
					System.out.print("비밀번호 : ");
					mb_pw = ip.nextLine();
					success = sdao.getMemberLogin(mb_id, mb_pw);;
					
					if(!success) {
						System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
					}
				
			}while(!success);
			
			success = sdao.getMemberLogin(mb_id, mb_pw);
			System.out.println();
			System.out.println("수정할 사용자");

			System.out.println("아이디 : ");
			mb_id = ip.nextLine();
			ip.nextLine();
			System.out.print("비밀번호 : ");
			mb_pw = ip.nextLine();
			

			svo.setMb_id(mb_id);
			svo.setMb_pw(mb_pw);
		
			
			sdao.setMemberRegiste(svo);
			
			System.out.println();
			System.out.println("사용자 정보 수정 결과");
			sdao.getMemberLogin(mb_id, mb_pw);
			System.out.println();
			
		}
		//사용자 관리자 전체 목록
		public void MemberTotalList() throws Exception {
			Scanner ip = new Scanner(System.in);
			
			MemberProvision sdao = new MemberProvision();
			
			String pw;
			
			System.out.println("영화 정보 전체 목록");
			System.out.println("관리자 비밀번호 : ");
			pw = ip.nextLine();
			
			if(pw.equals("1234")) {
					sdao.getMemberTotalList();
			}else {
				System.out.println("관리자 비밀번호가 틀립니다.");
			}
		
		}
	}
