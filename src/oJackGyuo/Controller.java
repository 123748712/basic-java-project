package oJackGyuo;

import java.util.Scanner;

import oJackGyuo.service.MainService;
import oJackGyuo.service.NoteBoxService;
import oJackGyuo.service.UserService;

public class Controller {
	public static void main(String[] args) throws Exception {

		new Controller().start();
	}

	public void start() throws Exception {
		NoteBoxService noteBoxService = NoteBoxService.getInstance();
		UserService userService = UserService.getInstance();
		int view = View.HOME;

		while (true) {
			switch (view) {
			case View.HOME:
				view = home();
				break;
			case View.JOIN:
				view = userService.join();
				break;
			case View.LOGIN:
				view = userService.login();
				break;
			case View.MAIN:
				view = userService.main();
				break;
			case View.SEARCH:
				view = userService.searchId();
				break;
			case View.SERVICE:
				view = userService.service();
				break;
			case View.SERVICE_NUM:
				view = userService.serviceNum();
				break;
			case View.SERVICE_QNA:
				view = userService.serviceQna();
				break;
			case View.NOTICE:
				view = MainService.notice();
				break;
			case View.NOTICE_BOARD:
				view = MainService.notiBoard();
				break;
			case View.NOTEBOX :
				view = NoteBoxService.noteSend();
			
			case View.EXIT:
				System.out.println("저희 오작교를 이용해주셔서 감사합니다!");
				System.out.println("좋은하루 보내시길 바랍니다.");
				return;

			}
		}
	}

	private int home() throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("결혼정보회사 \"오작교\" 에 오신걸 환영합니다 !");
		System.out.println("================================================================");
		System.out.println("1. 회원가입 / 2. 로그인 / 3. ID, PW 찾기 / 9. 고객센터 / 0. 프로그램 종료");
		System.out.println("================================================================");
		System.out.print("번호입력 > ");
		int homeMenu = Integer.parseInt(ScannerUtil.nextLine());

		switch (homeMenu) {
		case 1:
			return View.JOIN;
		case 2:
			return View.LOGIN;
		case 3:
			return View.SEARCH;
		case 9:
			return View.SERVICE;
		case 0:
			return View.EXIT;
		}

		return View.HOME;

	}
}