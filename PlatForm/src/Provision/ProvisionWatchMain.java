package Provision;

import java.util.Scanner;

import Model.WatchVO;

public class ProvisionWatchMain {
	// 영화 시청 리스트
	public void WatchList() throws Exception {
		Scanner input = new Scanner(System.in);

		String mainMenu; // 메인 메뉴
		boolean success = false;
		ProvisionWatch td = new ProvisionWatch();
		ProvisionMovie sdao = new ProvisionMovie();

		int no; // 일련번호
		String name; // 플랫폼
		String title; // 영화

		System.out.println("영화 시청한 리스트");
		td.getWatchTotalList();
		System.out.println();

	}

	// 영화 삭제 관리
	public void WatchDelete() throws Exception {
		Scanner input = new Scanner(System.in);

		ProvisionWatch td = new ProvisionWatch();
		WatchVO sdao = new WatchVO();

		int no; // 일련번호

		System.out.println("영화 시청한 리스트");
		td.getWatchTotalList();
		System.out.println();

		System.out.println("삭제할 일련번호 입력");
		System.out.print("일련번호 : ");
		no = input.nextInt();

		td.setWatchDelete(no);

		System.out.println();
		System.out.println("영화 시청 삭제 후 리스트");
		td.getWatchTotalList();
		System.out.println();
	}

	// 영화 등록
	public void WatchInsert() throws Exception {
		Scanner ip = new Scanner(System.in);
		boolean flag = false;
		MemberProvision sd = new MemberProvision();
		String mb_id;// 아이디
		String mb_pw = null; // 비밀번호
		// 1. 회원가입 정보
		System.out.println("사용자 정보 입력");
		System.out.println("아이디 :");
		mb_id = ip.nextLine();
		System.out.print("비밀번호 : ");
		mb_pw = ip.nextLine();

		flag = sd.getMemberLogin(mb_id, mb_pw);
		if (flag == false) {
			return;
		}

		// 2. 영화관 정보
		ProvisionMovie mo = new ProvisionMovie();

		int mNo = 0;
		mo.getMovieList();
		System.out.println("영화관 정보 입력 일련번호>>");
		mNo = ip.nextInt();
		ip.nextLine();
		if (mNo == 0) {
			return;
		}

		// 3. 상영관 입력 정보
		ProvisionPlatForm pt = new ProvisionPlatForm();

		int pNo = 0;
		pt.getPlatFormTotalList();
		System.out.println("상영관 정보 입력 일련번호>>");
		pNo = ip.nextInt();
		ip.nextLine();
		if (pNo == 0) {
			return;
		}
		// 4. 등록
		ProvisionWatch wt = new ProvisionWatch();

		wt.setInsertWatch(mb_id, mNo, pNo);

	}
}

