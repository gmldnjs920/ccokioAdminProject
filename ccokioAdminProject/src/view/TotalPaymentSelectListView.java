package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.TotalPayment;

public class TotalPaymentSelectListView {

	private Scanner keyboard;

	public TotalPaymentSelectListView() {
		keyboard = new Scanner(System.in);
	}

	public void totalPaymentSelctList(ArrayList<TotalPayment> totalPaymentList) {

		int sumPrice = 0;
		System.out.println("\n[총 결제내역 목록 보기 모드]");
		System.out.println("아이디\t이름\t전화번호\t상품이름\t상품가격\t수량\t합계금액");
		if(totalPaymentList.size() == 0) {
			System.out.println("결제내역이 없습니다.");
		} else {

			for(int i = 0; i < totalPaymentList.size(); i++) {
				System.out.print(totalPaymentList.get(i).getUserId() + "\t");
				System.out.print(totalPaymentList.get(i).getUserName() + "\t");
				System.out.print(totalPaymentList.get(i).getUserTel() + "\t");
				System.out.print(totalPaymentList.get(i).getProductName() + "\t");
				System.out.print(totalPaymentList.get(i).getProductPrice() + "\t");
				System.out.print(totalPaymentList.get(i).getOrderAmount() + "\t");
				System.out.println(totalPaymentList.get(i).getTotalPrice());
				sumPrice = sumPrice + totalPaymentList.get(i).getTotalPrice();
			}
			System.out.println("총 합계 : " + sumPrice);
		}

		Controllers.getTotalPaymentController().requestSelectMenuList();


	}

	public void totalPaymentSelectMenuList() {

		while(true) {
			System.out.print("[1. 회원결제내역, 2. 비회원결제내역, 3. 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1:
				Controllers.getTotalPaymentController().requestSelectPaymentUserList();
				break;
			case 2:
				Controllers.getTotalPaymentController().requestSelectPaymentNonUserList();
				break;
			case 3:
				Controllers.getMainController().requestAdminMainList();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

	public void userPaymentSelctList(ArrayList<TotalPayment> totalPaymentList) {

		int sumPrice = 0;
		System.out.println("\n[회원 결제내역 목록 보기 모드]");
		System.out.println("아이디\t이름\t전화번호\t상품이름\t상품가격\t수량\t합계금액");
		if(totalPaymentList.size() == 0) {
			System.out.println("결제내역이 없습니다.");
		} else {

			for(int i = 0; i < totalPaymentList.size(); i++) {
				if(!totalPaymentList.get(i).getUserId().equals("비회원")) {
					System.out.print(totalPaymentList.get(i).getUserId() + "\t");
					System.out.print(totalPaymentList.get(i).getUserName() + "\t");
					System.out.print(totalPaymentList.get(i).getUserTel() + "\t");
					System.out.print(totalPaymentList.get(i).getProductName() + "\t");
					System.out.print(totalPaymentList.get(i).getProductPrice() + "\t");
					System.out.print(totalPaymentList.get(i).getOrderAmount() + "\t");
					System.out.println(totalPaymentList.get(i).getTotalPrice());
					sumPrice = sumPrice + totalPaymentList.get(i).getTotalPrice();
				}
			}
			System.out.println("총 합계 : " + sumPrice);
		}

		Controllers.getTotalPaymentController().requestSelectPaymentUserMenuList();

	}
	
	public void userPaymentSelectMenuList() {

		while(true) {
			System.out.print("[1. 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1:
				Controllers.getTotalPaymentController().requestSelectList();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}
	
	public void nonUserPaymentSelctList(ArrayList<TotalPayment> totalPaymentList) {

		int sumPrice = 0;
		System.out.println("\n[비회원 결제내역 목록 보기 모드]");
		System.out.println("이름\t전화번호\t상품이름\t상품가격\t수량\t합계금액");
		if(totalPaymentList.size() == 0) {
			System.out.println("결제내역이 없습니다.");
		} else {

			for(int i = 0; i < totalPaymentList.size(); i++) {
				if(totalPaymentList.get(i).getUserId().equals("비회원")) {
					System.out.print(totalPaymentList.get(i).getUserName() + "\t");
					System.out.print(totalPaymentList.get(i).getUserTel() + "\t");
					System.out.print(totalPaymentList.get(i).getProductName() + "\t");
					System.out.print(totalPaymentList.get(i).getProductPrice() + "\t");
					System.out.print(totalPaymentList.get(i).getOrderAmount() + "\t");
					System.out.println(totalPaymentList.get(i).getTotalPrice());
					sumPrice = sumPrice + totalPaymentList.get(i).getTotalPrice();
				}
			}
			System.out.println("총 합계 : " + sumPrice);
		}

		Controllers.getTotalPaymentController().requestSelectPaymentNonUserMenuList();

	}
	
	public void nonUserPaymentSelectMenuList() {

		while(true) {
			System.out.print("[1. 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu) {

			case 1:
				Controllers.getTotalPaymentController().requestSelectList();
				break;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

}
