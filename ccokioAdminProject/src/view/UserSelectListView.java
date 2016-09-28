package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.User;

public class UserSelectListView {

	private Scanner keyboard;

	public UserSelectListView() {
		keyboard = new Scanner(System.in);
	}

	public void userSelctList(ArrayList<User> userList) {

		System.out.println("\n[회원 목록 보기 모드]");
		System.out.println("회번번호\t회원아이디\t회원이름\t전화번호\t회원등급");
		if(userList.size() == 0) {
			System.out.println("등록된 회원이 없습니다.");
		} else {

			for(int i = 0; i < userList.size(); i++) {
				System.out.print(userList.get(i).getUserNumber() + "\t");
				System.out.print(userList.get(i).getUserId() + "\t");
				System.out.print(userList.get(i).getUserName() + "\t");
				System.out.print(userList.get(i).getUserTel() + "\t");
				System.out.println(userList.get(i).getUserClass());
			}
		}
		
		Controllers.getUserController().requestSelectMenuList();
		

	}

	public void userSelectMenuList() {

		while(true) {
			System.out.print("[1. 회원조회, 2. 회원삭제, 3. 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1:
				Controllers.getUserController().requestSelectOne();
				break;
			case 2:
				Controllers.getUserController().requestDeleteSearchNumber();
				break;
			case 3:
				Controllers.getLoginController().requestCheckLogin();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}
