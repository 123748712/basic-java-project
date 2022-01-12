package oJackGyuo;

import oJackGyuo.vo.CustomerVO;

public class LoginedCustomer {
	//ΩÃ±€≈Ê∆–≈œ
	private static LoginedCustomer instance = new LoginedCustomer();
	public static LoginedCustomer getInstance() {
		return instance;
	}
	private LoginedCustomer() {}
	
	private CustomerVO loginedCustomer;
	
	public CustomerVO getLoginedCustomer() {
		return loginedCustomer;
	}
	public void setLoginedCustomer(CustomerVO loginedCustomer) {
		this.loginedCustomer = loginedCustomer;
	}
	@Override
	public String toString() {
		return "LoginedCustomer [loginedCustomer=" + loginedCustomer + "]";
	}
	
	
}
