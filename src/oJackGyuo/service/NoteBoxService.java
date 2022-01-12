package oJackGyuo.service;

import java.util.ArrayList;
import java.util.List;

import oJackGyuo.LoginedCustomer;
import oJackGyuo.ScannerUtil;
import oJackGyuo.View;
import oJackGyuo.dao.NoteBoxDAO;
import oJackGyuo.vo.NoteBoxVO;

public class NoteBoxService {
	private NoteBoxService() {

	}

	private static NoteBoxService instance;

	public static NoteBoxService getInstance() {
		if (instance == null) {
			instance = new NoteBoxService();
		}
		return instance;
	}

	List<NoteBoxVO> notes = new ArrayList<>();
	private NoteBoxDAO noteBoxDAO = NoteBoxDAO.getInstance();

	public int send() throws Exception {

		System.out.println("���� > ");
		String nBTitle = ScannerUtil.nextLine();
		System.out.println("���� > ");
		String nBBody = ScannerUtil.nextLine();

		System.out.println("�޴� ���̵� > ");
		String nBMember = ScannerUtil.nextLine();
		if (noteBoxDAO.selectMemId(nBMember)) {
			noteBoxDAO.insertNoteBox(new NoteBoxVO(nBTitle, nBBody, nBMember));
		} else {
			System.out.println("�ùٸ��� ���� ���̵��Դϴ�.");
		}
		return View.MAIN;
	}

	public int viewNoteBox() {

		System.out.println("=====================================");
		System.out.println("1. ���� ���� / 2. ���� ���� / 3. Ȩ���� �̵�");
		System.out.println("======================================");
		System.out.print("��ȣ �Է� >");
		int noteBoxNum = Integer.parseInt(ScannerUtil.nextLine());

		switch (noteBoxNum) {
		case 1:
			return View.RECIVENOTEBOX;
		case 2:
			return View.SENDNOTEBOX;
		case 3:
			return View.MAIN;
		default:
			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			return View.NOTEBOX;
		}
	}

	public int viewSendNoteBox() throws Exception {
		System.out.println("====================");
		noteBoxDAO.selectSendNoteBox(LoginedCustomer.getInstance().getLoginedCustomer().getCustomerId());
		System.out.println("====================");

		return View.NOTEBOX;
	}

	public int viewReceiveNoteBox() throws Exception {
		System.out.println("====================");
		noteBoxDAO.selectReceiveNoteBox(LoginedCustomer.getInstance().getLoginedCustomer().getCustomerId());
		System.out.println("====================");
		return View.NOTEBOX;
	}
}