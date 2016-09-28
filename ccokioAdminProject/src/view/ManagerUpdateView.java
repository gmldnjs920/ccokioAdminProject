package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Manager;
import domain.User;

public class ManagerUpdateView {

	private Scanner keyboard;

	public ManagerUpdateView() {
		keyboard = new Scanner(System.in);
	}

	
	public void getSearchManagerNumber() {

		int searchManagerNumber = 0;

		System.out.println("\n[매니저 수정 모드]");
		System.out.print("수정 할 매니저번호 : ");
		searchManagerNumber = keyboard.nextInt();

		Controllers.getManagerController().requestUpdate(searchManagerNumber);

	}


	public void managerUpdate(Manager searchedManager) {

		System.out.println("\n[매니저정보 수정모드]");
		System.out.println("아이디\t비밀번호\t이름");
		System.out.print(searchedManager.getManagerId() + "\t");
		System.out.print(searchedManager.getManagerPassWord() + "\t");
		System.out.println(searchedManager.getManagerName());

		System.out.println("[1. 비밀번호, 2. 이름, 3.돌아가기 : ");
		int selectedMenu = keyboard.nextInt();
		Manager searchManager = new Manager();
		searchManager.setManagerNumber(searchedManager.getManagerNumber());

		if(selectedMenu == 1) {

			System.out.print("비밀번호 : ");
			String managerPassWord = keyboard.next();
			searchManager.setManagerPassWord(managerPassWord);
			Controllers.getManagerController().requestReturnUpdate(searchManager, selectedMenu);

		} else if(selectedMenu == 2) {

			System.out.print("이름 : ");
			String managerName = keyboard.next();
			searchManager.setManagerName(managerName);
			Controllers.getManagerController().requestReturnUpdate(searchManager, selectedMenu);

		} else if(selectedMenu == 3) {

			Controllers.getManagerController().requestSelectList();
		} else {
			System.out.println("메뉴를 다시 입력해주세요.");
			Controllers.getManagerController().requestReturnSelectOne(searchedManager.getManagerNumber());
		}

	}

}
