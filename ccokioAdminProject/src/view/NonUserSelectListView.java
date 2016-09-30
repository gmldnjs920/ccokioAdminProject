package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.NonUser;

public class NonUserSelectListView {

	private Scanner keyboard;

	public NonUserSelectListView() {
		keyboard = new Scanner(System.in);
	}

	public void nonUserSelctList(ArrayList<NonUser> nonUserList) {

		System.out.println("\n[비회원 목록 보기 모드]");
		System.out.println("비회원번호\t비회원이름\t전화번호\t주소");
		if (nonUserList.size() == 0) {
			System.out.println("주문한 비회원이 없습니다.");
		} else {

			for (int i = 0; i < nonUserList.size(); i++) {
				System.out.print(nonUserList.get(i).getNonUserNumber() + "\t");
				System.out.print(nonUserList.get(i).getNonUserName() + "\t");
				System.out.print(nonUserList.get(i).getNonUserTel() + "\t");
				System.out.println(nonUserList.get(i).getNonUserAddress());
			}
		}

		Controllers.getNonUserController().requestNonUserSelectMenuList();

	}

	public void nonUserSelectMenuList() {

		while (true) {
			System.out.print("[1. 비회원조회, 2. 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {

			case 1:
				Controllers.getNonUserController().requestSelectOne();
				break;
			case 2:
				Controllers.getLoginController().requestCheckLogin();
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}
