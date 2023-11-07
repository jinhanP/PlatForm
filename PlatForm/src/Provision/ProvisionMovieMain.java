package Provision;

import java.util.Scanner;

import Model.MovieVO;

public class ProvisionMovieMain {
	// 영화 목록
			public void MovieList() throws Exception {
				ProvisionMovie sd = new ProvisionMovie();
				System.out.println("영화 전체 리스트");
				sd.getMovieList();
				System.out.println();
			}

			// 영화 등록 관리
			public void MovieRegistr() throws Exception {
				Scanner input = new Scanner(System.in);

				ProvisionMovie sd = new ProvisionMovie();
				MovieVO svo = new MovieVO();
				ProvisionMovie sa = new ProvisionMovie();

				String title; // 영화
				String genre;// 장르
				String open;// 개봉일

				System.out.println("영화 전체 리스트");
				sd.getMovieList();
				System.out.println();

				System.out.println("영화 정보 입력");

				System.out.println("영화명 :");
				title = input.nextLine();
				System.out.println("장르 :");
				genre = input.nextLine();
				System.out.println("개봉일 :");
				open = input.nextLine();

				svo.setTitle(title);
				svo.setGenre(genre);
				svo.setOpen(open);
				
				sd.setMovieRegiste(svo);
				
				System.out.println();
				System.out.println("영화 정보 전체 리스트");
				sd.setMovieRegiste(svo);

				System.out.println();
				System.out.println("영화 전체 리스트");
				sd.getMovieList();
				System.out.println();
			}

			// 영화 수정 관리
			public void MovieUpdate() throws Exception {
				Scanner input = new Scanner(System.in);
				Scanner input1 = new Scanner(System.in);

				ProvisionMovie sd = new ProvisionMovie();
				MovieVO svo = new MovieVO();

				int no; // 일련번호
				String title; // 영화
				String genre;// 장르
				String open;// 개봉일

				System.out.println("영화 전체 리스트");
				sd.getMovieList();
				System.out.println();

				System.out.println("수정할 영화 일련번호 입력");
				System.out.println("일련번호 :");
				no = input1.nextInt();

				System.out.println();
				System.out.println("새로운 정보 모두 입력");
				System.out.println("영화 :");
				title = input.nextLine();
				System.out.println("장르 :");
				genre = input.nextLine();
				System.out.println("개봉일 :");
				open = input.nextLine();

				svo.setNo(no);
				svo.setTitle(title);
				svo.setGenre(genre);
				svo.setOpen(open);
				sd.setMovieUpdate(svo);
				
				System.out.println();
				System.out.println("영화 수정 결과");
				sd.getMovieList();
				System.out.println();
			}

			// 영화 삭제 관리
			public void MovieDelete() throws Exception {
				Scanner input = new Scanner(System.in);
				ProvisionMovie sd = new ProvisionMovie();
				MovieVO svo = new MovieVO();

				int no;

				System.out.println("영화 전체 리스트");
				sd.getMovieList();
				System.out.println();

				System.out.println("삭제할 영화 일련번호 입력");
				System.out.println("일련번호 :");
				no = input.nextInt();

				sd.setMovieDelete(no);

				System.out.println();
				System.out.println("영화 전체 리스트");
				sd.getMovieList();
				System.out.println();
			}
		}

