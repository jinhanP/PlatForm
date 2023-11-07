package View;

import java.util.Scanner;

public class MenuViewer {
	public static Scanner scan = new Scanner(System.in);

	// 메인메뉴
	public static void Platform() {
		System.out.println();
		System.out.println("티비 시청 프로그램");
		System.out.println("해당 번호를 입려하세요.");
		System.out.printf("1.티비 플랫폼\t");
		System.out.printf("2.영화 정보 보기\t");
		System.out.printf("3.사용자 정보\t");
		System.out.printf("4.사용자 시청 목록\t");
		System.out.printf("\t5.프로그램 종료");
		System.out.printf("\n번호 선택 : ");
	}

	// 플랫폼 티비 메뉴
	public static void TV() {
		System.out.println();
		System.out.println("1.티비 플랫폼 목록");
		System.out.println("2.티비 플랫폼 등록");
		System.out.println("3.티비 플랫폼 수정");
		System.out.println("4.티비 플랫폼 삭제");
		System.out.printf("5.메인 메뉴");
		System.out.print("\n번호 선택:");
	}

	// 영화메뉴
	public static void Movie() {
		System.out.println();
		System.out.println("영화,장르 번호 선택");
		System.out.printf("1.영화,장르 정보 목록\t");
		System.out.printf("2.영화,장르 정보 등록\t");
		System.out.printf("3.영화,장르 정보 수정\t");
		System.out.printf("4.영화,장르 정보 삭제\t");
		System.out.printf("5.메인 메뉴");
		System.out.printf("\n번호 선택 : ");
	}

	// 사용자 메뉴
	public static void MemberMenuView() {
		System.out.println();
		System.out.println("사용자 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 사용자 정보 등록\t");
		System.out.println("2. 사용자 정보 수정\t");
		System.out.println("3. 사용자 전체 목록\t");
		System.out.println("4. 메인 메뉴");
		System.out.print("번호 선택 :");
	}

	// 시청 목록
	public static void WatchMenu() {
		System.out.println();
		System.out.println("사용자 시청 정보 번호 선택");
		System.out.println("해당 번호를 입려하세요.");
		System.out.printf("1.시청 정보 목록\t");
		System.out.printf("2.시청 정보 삭제\t");
		System.out.printf("3.시청 정보 등록\t");
		System.out.printf("4.메인 메뉴");
		System.out.printf("\n번호 선택 : ");
	}

}
