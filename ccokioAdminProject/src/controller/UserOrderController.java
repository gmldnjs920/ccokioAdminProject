package controller;

import java.util.ArrayList;

import dao.OrderDao;
import domain.Order;
import view.OrderListView;

public class UserOrderController {

	OrderDao orderDao;
	
	public UserOrderController() {
	
		orderDao = new OrderDao();
		
	}
	
	public void requestOrderList() {
		
		ArrayList<Order> orderList = orderDao.orderList();
		
		OrderListView orderListView = new OrderListView();
		orderListView.orderList(orderList);
		
	}
	
}
