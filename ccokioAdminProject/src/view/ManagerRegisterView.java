package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Manager;

public class ManagerRegisterView {

	private Scanner keyboard;

	public ManagerRegisterView() {

		keyboard = new Scanner(System.in);

	}
	

	public void managerRegister() {

		Manager newManager = null;

		System.out.println("\n[매니저 등록 모드]");
		System.out.print("아 이 디 : ");
		String managerId = keyboard.next();
		System.out.print("비밀번호 : ");
		String managerPassWord = keyboard.next();
		System.out.print("매니저이름 : ");
		String managerName = keyboard.next();

		newManager = new Manager(managerId, managerPassWord, managerName);

		Controllers.getManagerController().requestReturnRegister(newManager);

	}


}
