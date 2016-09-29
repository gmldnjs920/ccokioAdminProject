package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Product;
import domain.User;

public class UserSelectOneView {

	private Scanner keyboard;

	public UserSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	public void getSearchUserNumber() {

		int searchUserNumber = 0;

		System.out.println("\n[회원 조회 모드]");
		System.out.print("조회 할 회원번호 : ");
		searchUserNumber = keyboard.nextInt();

		Controllers.getUserController().requestReturnSelectOne(searchUserNumber);

	}


	public void userSelectOne(User searchUser) {

		System.out.println("회원번호 : " + searchUser.getUserNumber());
		System.out.println("회원아이디 : " + searchUser.getUserId());
		System.out.println("회원이름 : " + searchUser.getUserName());
		System.out.println("전화번호 : " + searchUser.getUserTel());
		System.out.println("주      소 : " + searchUser.getUserAddress());
		System.out.println("회원등급 : " + searchUser.getUserClass());
		System.out.println("쿠폰갯수 : " + searchUser.getCoupon());
		System.out.println("총구매량 : " + searchUser.getPurchaseQuantity());
		
		Controllers.getUserController().requestSelectOneMenu(searchUser);

	}

	public void userSelectOneMenu(User searchUser) {

		while(true) {		
			System.out.print("[1. 주문내역, 2. 결제내역, 3. 돌아가기] : ");
			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {
			case 1:
				Controllers.getUserOrderController().requestUserOrderList(searchUser);
				break;
			case 2:
				Controllers.getUserPaymentController().requestPaymentList(searchUser);
				break;
			case 3:
				Controllers.getUserController().requestSelectList();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");

			}

		}

	}

}
