package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static LoginController loginController;
	private static ProductController productController;
	private static UserController userController;
	private static ManagerController managerController;
	private static TotalPaymentController totalPaymentController;
	
	

<<<<<<< HEAD
	private static NonUserController nonUserController;
	private static OrderController2 orderController;
=======
	private static UserOrderController userOrderController;
	private static UserPaymentController   userPaymentController;

	
	
	
>>>>>>> refs/remotes/comstory11/master
	public Controllers() {

		programController = new ProgramController();
		mainController = new MainController();
		loginController = new LoginController();
		productController = new ProductController();
		userController = new UserController();
		managerController = new ManagerController();
		totalPaymentController = new TotalPaymentController();
		
		
		
<<<<<<< HEAD
		orderController = new OrderController2();
		nonUserController = new NonUserController();
=======
		

		userOrderController = new UserOrderController();
		userPaymentController = new UserPaymentController();
>>>>>>> refs/remotes/comstory11/master
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

	public static UserOrderController getUserOrderController() {
		return userOrderController;
	}

	public static UserPaymentController getUserPaymentController() {
		return userPaymentController;
	}
	public static TotalPaymentController getTotalPaymentController() {
		return totalPaymentController;
	}
<<<<<<< HEAD

	
	
	
	
	
	

	
	
	
	
	public static NonUserController getNonUserController() {
		return nonUserController;
	}
=======
>>>>>>> refs/remotes/comstory11/master

	public static OrderController2 getOrderController() {
		return orderController;
	}

	public static void setOrderController(OrderController2 orderController) {
		Controllers.orderController = orderController;
	}
	
}


