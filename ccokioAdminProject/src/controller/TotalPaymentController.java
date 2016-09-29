package controller;

import java.util.ArrayList;

import dao.TotalPaymentDao;
import domain.TotalPayment;
import view.TotalPaymentSelectListView;

public class TotalPaymentController {

	TotalPaymentDao totalPaymentDao;

	public TotalPaymentController() {

		totalPaymentDao = new TotalPaymentDao(); 

	}

	public void requestSelectList()
	{

		ArrayList<TotalPayment> totalPaymentList = totalPaymentDao.totalPaymentSelectList();

		TotalPaymentSelectListView totalPaymentSelectListView = new TotalPaymentSelectListView();
		totalPaymentSelectListView.totalPaymentSelctList(totalPaymentList);

	}

	public void requestSelectMenuList() {

		TotalPaymentSelectListView totalPaymentSelectListView = new TotalPaymentSelectListView();
		totalPaymentSelectListView.totalPaymentSelectMenuList();

	}

	public void requestSelectPaymentUserList() {

		ArrayList<TotalPayment> totalPaymentList = totalPaymentDao.totalPaymentSelectList();

		TotalPaymentSelectListView totalPaymentSelectListView = new TotalPaymentSelectListView();
		totalPaymentSelectListView.userPaymentSelctList(totalPaymentList);
		
	}
	
	public void requestSelectPaymentUserMenuList() {

		TotalPaymentSelectListView totalPaymentSelectListView = new TotalPaymentSelectListView();
		totalPaymentSelectListView.userPaymentSelectMenuList();

	}

	public void requestSelectPaymentNonUserList() {

		ArrayList<TotalPayment> totalPaymentList = totalPaymentDao.totalPaymentSelectList();

		TotalPaymentSelectListView totalPaymentSelectListView = new TotalPaymentSelectListView();
		totalPaymentSelectListView.nonUserPaymentSelctList(totalPaymentList);
		
	}
	
	public void requestSelectPaymentNonUserMenuList() {

		TotalPaymentSelectListView totalPaymentSelectListView = new TotalPaymentSelectListView();
		totalPaymentSelectListView.nonUserPaymentSelectMenuList();

	}

}





