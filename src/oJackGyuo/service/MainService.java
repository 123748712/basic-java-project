package oJackGyuo.service;

import java.util.Scanner;

import oJackGyuo.ScannerUtil;
import oJackGyuo.View;

public class MainService {
	Scanner scanner = new Scanner(System.in);
	private UserService us = UserService.getInstance();

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

	public static int notiBoard() {
		return 0;

	}
}