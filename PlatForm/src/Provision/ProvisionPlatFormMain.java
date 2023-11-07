package Provision;

import java.util.Scanner;

import Model.PlatFormVO;

public class ProvisionPlatFormMain {
	// 플랫폼 목록
	public void PlatFormList() throws Exception {
		ProvisionPlatForm ta = new ProvisionPlatForm();
		System.out.println("티비 플랫폼 전체 리스트");
		ta.getPlatFormTotalList();
		System.out.println();
	}

	// 플랫폼 등록 관리
	public void PlatFormRegistr() throws Exception {
		Scanner input = new Scanner(System.in);

		ProvisionPlatForm sd = new ProvisionPlatForm();
		PlatFormVO svo = new PlatFormVO();
		ProvisionPlatForm sa = new ProvisionPlatForm();

		int no; // 일련번호
		String name; // 티비 플랫폼
		int price; // 가격

		System.out.println("티비 플랫폼 전체 리스트");
		sd.getPlatFormTotalList();
		System.out.println();

		System.out.println("티비 플랫폼 정보 입력");

		System.out.println("티비 플랫폼 명 :");
		name = input.nextLine();
		input.nextLine();
		System.out.println("가격 :");
		price = input.nextInt();

		svo.setName(name);
		svo.setPrice(price);

		sd.setPlatFormRegiste(svo);

		System.out.println();
		System.out.println("티비 플랫폼 전체 리스트");
		sd.getPlatFormTotalList();
		System.out.println();
	}

	// 플랫폼 수정 관리
	public void PlatFormUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);

		ProvisionPlatForm sd = new ProvisionPlatForm();
		PlatFormVO svo = new PlatFormVO();

		int no; // 일련번호
		String name; // 티비 플랫폼
		int price; // 가격

		System.out.println("티비 플랫폼 전체 리스트");
		sd.getPlatFormTotalList();
		System.out.println();

		System.out.println("수정할 티비 플랫폼 일련번호 입력");
		System.out.println("일련번호 :");
		no = input1.nextInt();

		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.println("티비 플랫폼 명 :");
		name = input.nextLine();
		System.out.println("가격 :");
		price = input.nextInt();

		svo.setNo(no);
		svo.setName(name);
		svo.setPrice(price);
		sd.setPlatFormUpdate(svo);
		System.out.println();

		System.out.println("티비 플랫폼 수정 결과");
		sd.getPlatFormTotalList();
		System.out.println();
	}

	// 플랫폼 삭제 관리
	public void PlatFormDelete() throws Exception {
		Scanner input = new Scanner(System.in);

		ProvisionPlatForm sd = new ProvisionPlatForm();
		PlatFormVO svo = new PlatFormVO();
		int no;

		System.out.println("티비 플랫폼 전체 리스트");
		sd.getPlatFormTotalList();
		System.out.println();

		System.out.println("삭제할 티비 플랫폼 일련번호 입력");
		System.out.println("일련번호 :");
		no = input.nextInt();

		sd.setPlatFormDelete(no);

		System.out.println();
		System.out.println("티비 플랫폼 전체 리스트");
		sd.getPlatFormTotalList();
		System.out.println();
	}
}

