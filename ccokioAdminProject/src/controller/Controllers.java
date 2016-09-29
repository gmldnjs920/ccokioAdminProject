package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static LoginController loginController;
	private static ProductController productController;
	private static UserController userController;
	private static ManagerController managerController;
	private static TotalPaymentController totalPaymentController;
	
	
	
	

	private static UserOrderController userOrderController;
	private static UserPaymentController   userPaymentController;

	
	
	
	public Controllers() {

		programController = new ProgramController();
		mainController = new MainController();
		loginController = new LoginController();
		productController = new ProductController();
		userController = new UserController();
		managerController = new ManagerController();
		totalPaymentController = new TotalPaymentController();
		
		
		
		

		userOrderController = new UserOrderController();
		userPaymentController = new UserPaymentController();
	}

	
	
	
	public static ProgramController getProgramController() {
		return programController;
		
	}

	public static MainController getMainController() {
		return mainController;
	}

	public static LoginController getLoginController() {
		return loginController;
	}

	public static ProductController getProductController() {
		return productController;
	}

	public static UserController getUserController() {
		return userController;
	}

	public static ManagerController getManagerController() {
		return managerController;
	}

<<<<<<< HEAD



	public static UserOrderController getUserOrderController() {
		return userOrderController;
	}

	public static UserPaymentController getUserPaymentController() {
		return userPaymentController;
	}
=======
	public static TotalPaymentController getTotalPaymentController() {
		return totalPaymentController;
	}
	
	
	
	
>>>>>>> refs/remotes/origin/master
	

}


