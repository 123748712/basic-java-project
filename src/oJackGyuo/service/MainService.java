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
		System.out.println("오작교 공지사항 입니다.");
		System.out.println("=============================================");
		System.out.println("1. 공지사항 게시판 / 2. 홈으로 이동 ");
		System.out.println("=============================================");
		System.out.print("번호 입력 > ");
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
		System.out.println("로그아웃 되었습니다.");
		return View.HOME;
	}
}