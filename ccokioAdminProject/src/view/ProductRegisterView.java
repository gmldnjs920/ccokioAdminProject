package view;


import java.util.Scanner;

import controller.Controllers;
import domain.Product;

public class ProductRegisterView {
	
		private Scanner keyboard;
		
		public ProductRegisterView() {
			
			this.keyboard = new Scanner(System.in);
			
		}
		
		public void productRegisterView() {
			
			System.out.println("제품등록 모드입니다");
			System.out.println("등록할 제품 정보를 입력해 주십시오");
			
			System.out.println("제품 이름 : ");
			String productName = keyboard.next();
			
			System.out.println("제품 설명 : ");
			String productCommant = keyboard.next();
			
			System.out.println("제품 가격 : ");
			int productPrice = keyboard.nextInt();
			
			System.out.println("제조사 : ");
			String productOrigin = keyboard.next();
			
			Product newProduct = new Product(productName, productCommant, productPrice, productOrigin);
			Controllers.getProductController().requestReturnProductRegister(newProduct);
			
		}

	
}
