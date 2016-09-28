package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Manager;
import domain.User;

public class ManagerSelectOneView {

	private Scanner keyboard;

	public ManagerSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	public void getSearchManagerNumber() {

		int searchManagerNumber = 0;

		System.out.println("\n[매니저 조회 모드]");
		System.out.print("조회 할 매니저번호 : ");
		searchManagerNumber = keyboard.nextInt();

		Controllers.getManagerController().requestReturnSelectOne(searchManagerNumber);

	}


	public void managerSelectOne(Manager searchManager) {

		System.out.println("매니저번호 : " + searchManager.getManagerNumber());
		System.out.println("아 이 디 : " + searchManager.getManagerId());
		System.out.println("비밀번호 : " + searchManager.getManagerPassWord());
		System.out.println("이      름 : " + searchManager.getManagerName());
		
		Controllers.getManagerController().requestSelectOneMenu(searchManager);

	}

	public void managerSelectOneMenu(Manager searchManager) {

		while(true) {		
			System.out.print("[1. 매니저정보수정, 2. 매니저삭제, 3. 돌아가기] : ");
			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				Controllers.getManagerController().requestSelectList();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");

			}

		}

	}

}
