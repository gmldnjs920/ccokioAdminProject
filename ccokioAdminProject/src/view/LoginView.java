package view;

import java.util.Scanner;

import controller.Controllers;
import domain.Login;

public class LoginView {

	private Scanner keyboard;

	public LoginView() {
		keyboard = new Scanner(System.in);
	}

	public void login() {
		
		Login login = null;
		
		System.out.println("\n[로그인 모드]");
		System.out.print("아 이 디 : ");
		String loginId = keyboard.next();
		System.out.print("비밀번호 : ");
		String loginPassWord = keyboard.next();
		
		login = new Login(loginId, loginPassWord);
		
		Controllers.getLoginController().requestReturnLogin(login);
		
	}

	
}
