package oJackGyuo.service;

import java.util.Scanner;

import oJackGyuo.LoginedCustomer;
import oJackGyuo.ScannerUtil;
import oJackGyuo.View;

public class MainService {
	private static MainService instance = new MainService();

	public static MainService getInstance() {
		if (instance == null) {
			instance = new MainService();
		}
		return instance;
	}

	private MainService() {
	}
	private UserService us = UserService.getInstance();


	Scanner scanner = new Scanner(System.in);

	public static int notice() {
		System.out.println("���۱� �������� �Դϴ�.");
		System.out.println("=============================================");
		System.out.println("1. �������� �Խ��� / 2. Ȩ���� �̵� ");
		System.out.println("=============================================");
		System.out.print("��ȣ �Է� > ");
		int serviceNum = Integer.parseInt(ScannerUtil.nextLine());
		switch (serviceNum) {
		case 1:
			return View.NOTICE_BOARD;
		case 2:
			return View.MAIN;
		}
		return 0;

	}

	public int logout() {
		LoginedCustomer.getInstance().setLoginedCustomer(null);
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		return View.HOME;
	}
}