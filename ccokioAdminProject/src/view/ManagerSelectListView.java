package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.Manager;

public class ManagerSelectListView {

	private Scanner keyboard;

	public ManagerSelectListView() {
		keyboard = new Scanner(System.in);
	}

	public void managerSelctList(ArrayList<Manager> managerList) {

		System.out.println("\n[매니저 목록 보기 모드]");
		System.out.println("매니저번호\t\t매니저아이디\t매니저이름");
		if(managerList.size() == 0) {
			System.out.println("등록된 매니저가 없습니다.");
		} else {

			for(int i = 0; i < managerList.size(); i++) {
				System.out.print(managerList.get(i).getManagerNumber()+ "\t\t");
				System.out.print(managerList.get(i).getManagerId() + "\t\t");
				System.out.println(managerList.get(i).getManagerName());
			}
		}

		Controllers.getManagerController().requestSelectMenuList();


	}

	public void managerSelectMenuList() {

		while(true) {
			System.out.print("[1. 매니저등록, 2. 매니저조회, 3. 매니저정보수정, 4. 매니저삭제, 5. 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1:
				Controllers.getManagerController().requestRegister();
				break;
			case 2:
				Controllers.getManagerController().requestSelectOne();
				break;
			case 3:
				Controllers.getManagerController().requestUpdateSearchNumber();
				break;
			case 4:
				Controllers.getManagerController().requestDeleteSearchNumber();
				break;
			case 5:
				Controllers.getMainController().requestAdminMainList();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}
