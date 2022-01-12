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
		MainService mainService = MainService.getInstance();
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
			case View.SENDNB:
				view = noteBoxService.send(); 
				break;
			case View.NOTEBOX: // ������
				view = noteBoxService.viewNoteBox();
				break;
			case View.SENDNOTEBOX:
				view = noteBoxService.viewSendNoteBox();// ����������
				break;
			case View.RECIVENOTEBOX:
				view = noteBoxService.viewReceiveNoteBox();// ����������
				break;
			case View.LOGOUT:
				view = mainService.logout();
				break;
			case View.EXIT:
				System.out.println("���� ���۱��� �̿����ּż� �����մϴ�!");
				System.out.println("�����Ϸ� �����ñ� �ٶ��ϴ�.");
				return;

			}
		}
	}

	private int home() throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("��ȥ����ȸ�� \"���۱�\" �� ���Ű� ȯ���մϴ� !");
		System.out.println("================================================================");
		System.out.println("1. ȸ������ / 2. �α��� / 3. ID, PW ã�� / 9. ������ / 0. ���α׷� ����");
		System.out.println("================================================================");
		System.out.print("��ȣ�Է� > ");
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