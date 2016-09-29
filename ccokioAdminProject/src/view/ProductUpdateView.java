package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Manager;
import domain.Product;

public class ProductUpdateView {

	private Scanner keyboard;

	public ProductUpdateView() {
		keyboard = new Scanner(System.in);
	}

	
	public void getSearchProductNumber() {

		int searchProductNumber = 0;

		System.out.println("\n[제품 수정 모드]");
		System.out.print("수정 할 제품번호 : ");
		searchProductNumber = keyboard.nextInt();

		Controllers.getProductController().requestUpdate(searchProductNumber);
	}


	public void productUpdate(Product searchedProduct) {

		System.out.println("\n[제품정보 수정모드]");
		System.out.println("제품이름\t제품가격\t제품설명\t제조사");
		System.out.print(searchedProduct.getProductName() + "\t");
		System.out.print(searchedProduct.getProductPrice() + "\t");
		System.out.print(searchedProduct.getProductCommant() + "\t");
		System.out.println(searchedProduct.getProductOrigin());

		System.out.println("[1. 제품 이름, 2. 제품 가격, 3. 제품 설명, 4. 제조사, 5. 돌아가기 : ");
		int selectedMenu = keyboard.nextInt();
		Product searchProduct = new Product();
		searchProduct.setProductNumber(searchedProduct.getProductNumber());

		if(selectedMenu == 1) {

			System.out.print("제품 이름 : ");
			String productName = keyboard.next();
			searchProduct.setProductName(productName);
			Controllers.getProductController().requestReturnUpdate(searchProduct, selectedMenu);
		} else if(selectedMenu == 2) {

			System.out.print("제품 가격 : ");
			int productPrice = keyboard.nextInt();
			searchProduct.setProductPrice(productPrice);
			Controllers.getProductController().requestReturnUpdate(searchProduct, selectedMenu);

		} else if(selectedMenu == 3) {

			System.out.print("제품 설명 : ");
			String productCommant = keyboard.next();
			searchProduct.setProductCommant(productCommant);
			Controllers.getProductController().requestReturnUpdate(searchProduct, selectedMenu);

		} else if(selectedMenu == 4) {

			System.out.print("제조사 : ");
			String productOrigin = keyboard.next();
			searchProduct.setProductOrigin(productOrigin);
			Controllers.getProductController().requestReturnUpdate(searchProduct, selectedMenu);

		} else if(selectedMenu == 5) {

			Controllers.getProductController().requestProductSelectList();

		}else {
			System.out.println("메뉴를 다시 입력해주세요.");
	
			Controllers.getProductController().requestReturnSelectOne(selectedMenu);
		}

	}

}