package oJackGyuo.service;

import java.util.Scanner;

import oJackGyuo.ScannerUtil;
import oJackGyuo.View;

public class MainService {
	Scanner scanner = new Scanner(System.in);
	private UserService us = UserService.getInstance();

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

	public static int notiBoard() {
		return 0;

	}
}