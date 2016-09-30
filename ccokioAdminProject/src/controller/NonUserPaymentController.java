package controller;

import java.util.ArrayList;

import dao.NonUserPaymentDao;
import domain.NonUser;
import domain.NonUserPayment;
import view.NonUserPaymentListView;

public class NonUserPaymentController {

	NonUserPaymentDao nonUserPaymentDao;

	public NonUserPaymentController() {

		nonUserPaymentDao = new NonUserPaymentDao();

	}

	public void requestPaymentList(NonUser searchNonUser) {

		ArrayList<NonUserPayment> nonUserPaymentList = nonUserPaymentDao.nonUserPaymentList(searchNonUser);

		NonUserPaymentListView nonUserPaymentListView = new NonUserPaymentListView();
		nonUserPaymentListView.nonUserPaymentList(nonUserPaymentList);

	}

	public void requestPaymentMenuList() {

		NonUserPaymentListView nonUserPaymentListView = new NonUserPaymentListView();
		nonUserPaymentListView.nonUserPaymentMenuList();

	}

}