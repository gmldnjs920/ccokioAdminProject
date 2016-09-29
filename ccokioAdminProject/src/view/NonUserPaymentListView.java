package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.NonUserPayment;

public class NonUserPaymentListView {

	private Scanner keyboard;

	public NonUserPaymentListView() {

		this.keyboard = new Scanner(System.in);

	}

	public void nonUserPaymentList(ArrayList<NonUserPayment> nonUserPaymentList) {

		int sumPrice = 0;
		System.out.println("[결제 내역 목록]");
		System.out.println("결제 번호\t주문 번호\t비회원 전화번호\t제품 이름\t제품 가격\t수량\t합계금액");
		if (nonUserPaymentList.size() == 0) {
			System.out.println("결제된 제품이 없습니다.");
		} else {
			for (int i = 0; i < nonUserPaymentList.size(); i++) {

				System.out.print(nonUserPaymentList.get(i).getNonUserPaymentNumber() + "\t");
				System.out.print(nonUserPaymentList.get(i).getNonUserOrderNumber() + "\t");
				System.out.print(nonUserPaymentList.get(i).getNonUserTel() + "\t\t");
				System.out.print(nonUserPaymentList.get(i).getProductName() + "\t");
				System.out.print(nonUserPaymentList.get(i).getProductPrice() + "\t");
				System.out.print(nonUserPaymentList.get(i).getOrderAmount() + "\t");
				System.out.println(nonUserPaymentList.get(i).getTotalPrice());
				sumPrice = sumPrice + nonUserPaymentList.get(i).getTotalPrice();
			}

			System.out.println("총 합계 : " + sumPrice);
		}

		Controllers.getNonUserPaymentController().requestPaymentMenuList();

	}

	public void nonUserPaymentMenuList() {

		while (true) {
			System.out.print("[1. 메인메뉴 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {

			case 1:
				Controllers.getLoginController().requestCheckLogin();
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}
