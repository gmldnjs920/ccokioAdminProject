package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import controller.MainController;
import domain.Product;

public class ProductSelectListView {

	private Scanner keyboard;

	public ProductSelectListView() {
		keyboard = new Scanner(System.in);
	}

	public void productList(ArrayList<Product> products) {

		System.out.println("\n[제품 등록 모드]");
		System.out.println("제품번호\t제품이름\t\t제품가격\t제품설명\t\t제조사");
		if (products.size() == 0) {
			System.out.println("등록된 제품이 없습니다.");
		} else {
			for (int i = 0; i < products.size(); i++) {
				System.out.print(products.get(i).getProductNumber() + "\t");
				System.out.print(products.get(i).getProductName() + "\t\t");
				System.out.print(products.get(i).getProductPrice() + "\t");
				System.out.print(products.get(i).getProductCommant() + "\t\t");
				System.out.println(products.get(i).getProductOrigin());
			}
		}

		Controllers.getProductController().requestSelectMenuList();

	}

	public void productSelectMenuList() {

		while (true) {
			System.out.println("제품관리모드입니다");
			System.out.println("1. 제품등록 || 2. 제품수정 || 3. 제품삭제 || 4. 제품조회  || 5. 나가기");
			int selectedMenu = keyboard.nextInt();

			if (selectedMenu == 1) {

				Controllers.getProductController().requestProductRegister();

			} else if (selectedMenu == 2) {

				Controllers.getProductController().requestUpdateSearchNumber();

			} else if (selectedMenu == 3) {

				Controllers.getProductController().requestDeleteSearchNumber();

			} else if (selectedMenu == 4) {

				Controllers.getProductController().requestProductSelectOne();

			} else if (selectedMenu == 5) {
				Controllers.getLoginController().requestCheckLogin();
				break;

			} else {

				System.out.println("잘못 입력하셨습니다");

			}
		}
	}

}
