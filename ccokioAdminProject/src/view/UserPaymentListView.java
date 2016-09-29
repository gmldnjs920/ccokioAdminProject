package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.UserPayment;

public class UserPaymentListView {

	private Scanner keyboard;

	public UserPaymentListView() {

		this.keyboard = new Scanner(System.in);

	}

	public void userPaymentList(ArrayList<UserPayment> userPaymentList) {

		int sumPrice = 0;
		System.out.println("[결제 내역 목록]");
		System.out.println("결제 번호\t주문 번호\t회원 아이디\t제품 이름\t제품 가격\t수량\t합계금액");
		if (userPaymentList.size() == 0) {
			System.out.println("결제된 제품이 없습니다.");
		} else {
			for (int i = 0; i < userPaymentList.size(); i++) {

				System.out.print(userPaymentList.get(i).getUserPaymentNumber() + "\t");
				System.out.print(userPaymentList.get(i).getUserOrderNumber() + "\t");
				System.out.print(userPaymentList.get(i).getUserId() + "\t");
				System.out.print(userPaymentList.get(i).getProductName() + "\t");
				System.out.print(userPaymentList.get(i).getProductPrice() + "\t");
				System.out.print(userPaymentList.get(i).getOrderAmount() + "\t");
				System.out.println(userPaymentList.get(i).getTotalPrice());
				sumPrice = sumPrice + userPaymentList.get(i).getTotalPrice();
			}

			System.out.println("총 합계 : " + sumPrice);
		}

		Controllers.getUserPaymentController().requestPaymentMenuList();

	}

	public void userPaymentMenuList() {

		while(true) {
			System.out.print("[1. 메인메뉴 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1:
				Controllers.getLoginController().requestCheckLogin();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}


}
