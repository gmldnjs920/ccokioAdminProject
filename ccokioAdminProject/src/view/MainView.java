package view;

import java.util.Scanner;

import controller.Controllers;

public class MainView {

	private Scanner keyboard;

	public MainView() {
		keyboard = new Scanner(System.in);
	}

	public void mainView() {

		while(true) {
			System.out.println("\n[관리자 모드]");
			System.out.println("[1. 로그인, 0. 프로그램 종료] : ");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				Controllers.getLoginController().requestLogin();
			} else if(selectedMenu == 0) {
				Controllers.getProgramController().requestExitProgram();
			} else {
				System.out.println("메뉴를 다시 입력해주세요.");
			}
		}
	}

	public void adminMainView() {

		while(true) {
			System.out.println("\n[관리자 모드]");
			System.out.println("[1. 메뉴 관리]");
			System.out.println("[2. 회원 관리]");
			System.out.println("[3. 비회원 관리]");
			System.out.println("[4. 매니저 관리]");
			System.out.println("[5. 총 결제내역]");
			System.out.println("[6. 로그 아웃]");
			System.out.println("[0. 프로그램종료]");
			

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {

			} else if(selectedMenu == 2) {
				Controllers.getUserController().requestSelectList();
			} else if(selectedMenu == 3) {
				
			} else if(selectedMenu == 4) {
				Controllers.getManagerController().requestSelectList();
			} else if(selectedMenu == 5) {
				Controllers.getTotalPaymentController().requestSelectList();
			} else if(selectedMenu == 6) {
				Controllers.getLoginController().requestLogout();
			} else if(selectedMenu == 0) {
				Controllers.getProgramController().requestExitProgram();
			} else {
				System.out.println("메뉴를 다시 입력해주세요.");
			}

		}

	}

	public void managerMainView() {

		while(true) {
			System.out.println("\n[매니저 모드]");
			System.out.println("[1. 메뉴 관리]");
			System.out.println("[2. 회원 관리]");
			System.out.println("[3. 비회원 관리]");
			System.out.println("[4. 로그 아웃]");
			System.out.println("[0. 프로그램종료]");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {

			} else if(selectedMenu == 2) {
				Controllers.getUserController().requestSelectList();
			} else if(selectedMenu == 3) {

			} else if(selectedMenu == 4) {
				Controllers.getLoginController().requestLogout();
			} else if(selectedMenu == 0) {
				Controllers.getProgramController().requestExitProgram();
			} else {
				System.out.println("메뉴를 다시 입력해주세요.");
			}
		}

	}
}
