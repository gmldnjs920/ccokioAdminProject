package view;

import java.util.ArrayList;
import java.util.Scanner;

import domain.Payment;

public class PaymentListView {

	private Scanner keyboard;

	public PaymentListView() {

		this.keyboard = new Scanner(System.in);

	}

	public void paymentList(ArrayList<Payment> payments) {

		System.out.println("결제 내역 목록");
		System.out.println("주문 번호\t회원 아이디\t회원 이름\t제품 이름");
		if (payments.size() == 0) {
			System.out.println("등록된 제품이 없습니다.");
		} else {
			for (int i = 0; i < payments.size(); i++) {
				System.out.print(payments.get(i).getUserPaymentNumber() + "\t");
				System.out.print(payments.get(i).getUserId() + "\t");
				System.out.print(payments.get(i).getUserName() + "\t");
				System.out.println(payments.get(i).getProductName());

			}
		}

	}

	
}
