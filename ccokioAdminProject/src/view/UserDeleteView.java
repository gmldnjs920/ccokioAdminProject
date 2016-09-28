package view;

import java.util.Scanner;

import controller.Controllers;

public class UserDeleteView {

	private Scanner keyboard;

	public UserDeleteView() {
		keyboard = new Scanner(System.in);
	}
	
	
	public void getSearchUserNumber() {
		
		int searchUserNumber = 0;

		System.out.println("\n[회원 삭제 모드]");
		System.out.print("삭제 할 회원번호 : ");
		searchUserNumber = keyboard.nextInt();

		Controllers.getUserController().requestDelete(searchUserNumber);
		
	}
	
	public void userDelete(int searchUserNumer) {
		System.out.println("회원을 탈퇴시키겠습니까? (Y / anyKey press)");
		char selectChar = keyboard.next().charAt(0);
		
		if(selectChar == 'Y' || selectChar == 'y') {
			Controllers.getUserController().requestReturnDelete(searchUserNumer);
		} else {
			System.out.println("회원탈퇴를 취소했습니다.");
			Controllers.getUserController().requestSelectList();
		}
	}
	
}
