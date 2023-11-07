package PlatFormMain;

import Provision.MemberProvisionMain;
import Provision.ProvisionMovieMain;
import Provision.ProvisionPlatFormMain;
import Provision.ProvisionWatchMain;
import View.Member_CHOICE;
import View.MenuViewer;
import View.Menu_CHOICE;
import View.Movie_CHOICE;
import View.Platform_CHOICE;
import View.Watch_CHOICE;

public class PlatForm {

	public static void main(String[] args) {
		mainMenu();
	}

	private static void mainMenu() {
		int choiceNum = 0;
		boolean stopFlag = false;
		while (!stopFlag) {
			try {
				// 메인메뉴를 화면출력
				MenuViewer.Platform();
				// 키보드 입력
				choiceNum = MenuViewer.scan.nextInt();
				// 입력 버퍼 클리어
				MenuViewer.scan.nextLine();

				switch (choiceNum) {
				case Menu_CHOICE.List: // 플랫폼 정보
					tvMenu();
					break;
				case Menu_CHOICE.Movies: // 영화 정보
					MovieMenu();
					break;
				case Menu_CHOICE.User: // 사용자 정보
					MemberMenu();
					break;
				case Menu_CHOICE.WatchList: // 시청 정보
					WatchMenu();
					break;
				case Menu_CHOICE.EXIT: // 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					stopFlag = true;
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				return;
			}
		}
	}

	// 플랫폼 목록
	private static void tvMenu() throws Exception {
		int choice;
		ProvisionPlatFormMain platFormMain = new ProvisionPlatFormMain();
		MenuViewer.TV();
		choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		switch (choice) {
		case Platform_CHOICE.LIST:
			System.out.println();
			platFormMain.PlatFormList();
			break;
		case Platform_CHOICE.INSERT:
			System.out.println();
			platFormMain.PlatFormRegistr();
			break;
		case Platform_CHOICE.UPDATE:
			System.out.println();
			platFormMain.PlatFormUpdate();
			break;
		case Platform_CHOICE.DELETE:
			System.out.println();
			platFormMain.PlatFormDelete();
			break;
		case Platform_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력해주세요.");
		}

	}

	// 영화메뉴
	private static void MovieMenu() throws Exception {
		int choice;
		ProvisionMovieMain movieMain = new ProvisionMovieMain();
		MenuViewer.Movie();
		choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		switch (choice) {
		case Movie_CHOICE.LIST:
			System.out.println("");
			movieMain.MovieList();
			break;
		case Movie_CHOICE.INSERT:
			System.out.println("");
			movieMain.MovieRegistr();
			break;
		case Movie_CHOICE.UPDATE:
			movieMain.MovieUpdate();
			break;
		case Movie_CHOICE.DELETE:
			movieMain.MovieDelete();
			break;
		case Movie_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력해주세요");
		}

	}

	// 사용자
	private static void MemberMenu() throws Exception {
		int choice;
		MemberProvisionMain memberMain = new MemberProvisionMain();
		MenuViewer.MemberMenuView();
		choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		switch (choice) {
		case Member_CHOICE.INSERT:
			System.out.println();
			memberMain.MemberRegistr();
			break;
		case Member_CHOICE.UPDATE:
			System.out.println();
			memberMain.MemberUpdate();
			break;
		case Member_CHOICE.LIST:
			memberMain.MemberTotalList();
			break;
		case Member_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	// 시청 목록
	private static void WatchMenu() throws Exception {
		int choice;
		ProvisionWatchMain Watch = new ProvisionWatchMain();
		MenuViewer.WatchMenu();
		choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();

		switch (choice) {
		case Watch_CHOICE.LIST:
			System.out.println();
			Watch.WatchList();
			break;
		case Watch_CHOICE.DELETE:
			System.out.println();
			Watch.WatchDelete();
			break;
		case Watch_CHOICE.INSERT:
			System.out.println();
			Watch.WatchInsert();
			break;
		case Watch_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력해주세요.");
		}
	}
}
//CREATE TABLE platform( -- 플랫폼
//no NUMBER ,
//name VARCHAR2(50) not null,
//price number not null, --월 가격
//PRIMARY key(no)
//
//);
//drop sequence platform_seq;
//create sequence platform_seq --1+ 증가
//start with 1
//increment by 1;
//
//INSERT into platform VALUES(platform_seq.nextval,'티빙',24000);
//INSERT into platform VALUES(platform_seq.nextval,'쿠팡 플레이',20000);
//INSERT into platform VALUES(platform_seq.nextval,'넷플릭스',21000);
//insert into platform values(platform_seq.nextval,'왓챠','23000');
//SELECT * from platform;
//
//
//
//CREATE table movie( -- 영화,장르,개봉날짜
//no number not null,
//title VARCHAR2(30) not null,
//Genre VARCHAR2(30) not null,
//open VARCHAR2(30)not null,
//PRIMARY key(no)
//);
//drop sequence movie_seq;
//create sequence movie_seq --1+ 증가
//start with 1
//increment by 1;
//
//INSERT into movie VALUES(movie_seq.nextval,'신세계','드라마/액션','2013년');
//INSERT into movie VALUES(movie_seq.nextval,'내부자들','드라마/액션','2015년');
//INSERT into movie VALUES(movie_seq.nextval,'친구','액션/느와르','2013년');
//insert into movie values(movie_seq.nextval,'라이터를 켜라','액션','2018년');
//SELECT * from movie;--23 13
//
//
//CREATE table member( --사용자 정보
//mb_id VARCHAR2(30) not null,
//name VARCHAR2(20) not null,
//phone VARCHAR2(20) not null,
//mb_pw VARCHAR2(30) not null,
//CONSTRAINT user_pk primary key(mb_id)
//);
//
//insert into member (name, phone, mb_id,mb_pw) values ('홍길동','01012342134','admin1234','1234');
//SELECT * from member;
//
//drop sequence member_seq;
//create sequence member_seq --1+ 증가
//start with 1
//increment by 1;
//
//
//create table watch( -- 시청 목록 
//no number not null,
//mb_id VARCHAR2(30),
//m_no number,
//p_no NUMBER ,
//primary key (no),
//CONSTRAINT watch_mno_fk FOREIGN key(m_no) REFERENCES movie (no) on DELETE SET null,
//CONSTRAINT watch_mbid_fk FOREIGN key(mb_id) REFERENCES member(mb_id) on DELETE SET null,
//CONSTRAINT watch_pno_fk FOREIGN key(p_no) REFERENCES platform(no) on DELETE SET null
//);
//
//insert into watch values(watch_seq.nextval,'admin1234',2,3);
//drop sequence watch_seq;
//create sequence watch_seq --1+ 증가
//start with 1
//increment by 1;
//
//SELECT * from watch order by no;
//commit;
//
//drop table platform;
//drop table movie;
//drop table member;
//drop table watch;
