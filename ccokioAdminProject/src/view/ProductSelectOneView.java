package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Product;
import domain.User;

public class ProductSelectOneView {

	private Scanner keyboard;

	public ProductSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	public void getSearchProductNumber() {

		int searchProductNumber = 0;

		System.out.println("\n[제품 조회 모드]");
		System.out.print("조회 할 제품번호 : ");
		searchProductNumber = keyboard.nextInt();

		Controllers.getProductController().requestReturnSelectOne(searchProductNumber);

	}

	public void productSelectOne(Product searchProduct) {

		System.out.println("제품 번호 : " + searchProduct.getProductNumber());
		System.out.println("제품명 : " + searchProduct.getProductName());
		System.out.println("가   격 : " + searchProduct.getProductPrice());
		System.out.println("제품 설명 : " + searchProduct.getProductCommant());
		System.out.println("제 조 사 : " + searchProduct.getProductOrigin());

		Controllers.getProductController().requestSelectOneMenu(searchProduct);

	}

	public void ProductSelectOneMenu(Product searchProduct) {

		while (true) {
			System.out.print("[1. 제품 수정, 2. 제품 삭제, 3. 돌아가기] : ");
			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				Controllers.getProductController().requestUpdate(searchProduct.getProductNumber());
				break;
			case 2:
				Controllers.getProductController().requestDelete(searchProduct.getProductNumber());
				break;
			case 3:
				Controllers.getProductController().requestProductSelectList();
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");

			}

		}

	}

}
