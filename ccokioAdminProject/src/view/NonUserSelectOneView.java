package view;

import java.util.Scanner;

import controller.Controllers;
import domain.NonUser;

public class NonUserSelectOneView {

	private Scanner keyboard;

	public NonUserSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	public void getSearchNonUserNumber() {

		int searchNonUserNumber = 0;

		System.out.println("\n[회원 조회 모드]");
		System.out.print("조회 할 비회원번호 : ");
		searchNonUserNumber = keyboard.nextInt();

		Controllers.getNonUserController().requestReturnNonUserSelectOne(searchNonUserNumber);

	}

	public void nonUserSelectOne(NonUser searchNonUser) {

		System.out.println("비회원번호 : " + searchNonUser.getNonUserNumber());
		System.out.println("비회원이름 : " + searchNonUser.getNonUserName());
		System.out.println("전화번호 : " + searchNonUser.getNonUserTel());
		System.out.println("주      소 : " + searchNonUser.getNonUserAddress());

		Controllers.getNonUserController().requestSelectOneMenu(searchNonUser);

	}

	public void nonUserSelectOneMenu(NonUser searchNonUser) {

		while(true) {		
			System.out.print("[1. 주문내역, 2. 결제내역, 3. 돌아가기] : ");
			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {
			case 1:
				Controllers.getNonUserOrderController().requestNonUserOrderList(searchNonUser);
				break;
			case 2:
				Controllers.getNonUserPaymentController().requestPaymentList(searchNonUser);
				break;
			case 3:
				Controllers.getNonUserController().requestNonUserSelectMenuList();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");

			}

		}

	}
	
}
