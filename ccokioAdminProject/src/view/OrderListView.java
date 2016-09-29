package view;


import java.util.ArrayList;
import java.util.Scanner;

import controller.Controllers;
import domain.Order;

public class OrderListView {

	private Scanner keyboard;

	public OrderListView() {

		this.keyboard = new Scanner(System.in);

	}

	public void orderList(ArrayList<Order> orders) {

		System.out.println("주문 내역 목록");
		System.out.println("주문 번호\t회원 아이디\t회원 이름\t제품 번호\t 주문량");
		if (orders.size() == 0) {
			System.out.println("등록된 제품이 없습니다.");
		} else {
			for (int i = 0; i < orders.size(); i++) {
				System.out.print(orders.get(i).getUserOrderNumber() + "\t");
				System.out.print(orders.get(i).getUserId() + "\t");
				System.out.print(orders.get(i).getUserName() + "\t");
				System.out.print(orders.get(i).getProductName() + "\t");
				System.out.println(orders.get(i).getOrderAmount());
			}
		}

	}

}

