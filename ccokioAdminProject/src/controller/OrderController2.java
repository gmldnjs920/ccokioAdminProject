package controller;

import dao.OrderDao2;
import domain.NonUser;

public class OrderController2 {

	private OrderDao2 orderDao;
	
	public OrderController2() {
		
		orderDao = new OrderDao2();
	}
	//주문내역 요청 메서드
	public void requestOrderSelectList(NonUser searchNonUser){
		
		//dao
		boolean success = OrderDao2.orderSelectList(searchNonUser);
		//view
		
		
	}
	
}
