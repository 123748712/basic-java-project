package oJackGyuo.service;

import java.util.ArrayList;
import java.util.List;

import oJackGyuo.ScannerUtil;
import oJackGyuo.vo.CustomerVO;
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


	public static int noteSend() {
		List<NoteBoxVO> notes = new ArrayList<>();
		boolean sendRun = false;
		while (true) {
			System.out.print("�޴º��� ���̵� > ");
			String sendId = ScannerUtil.nextLine();
			// ������ ��� üũ

			System.out.println("���� > ");
			String nBTitle = ScannerUtil.nextLine();
			System.out.println("���� >");
			String nBBody = ScannerUtil.nextLine();

			System.out.println("���������� ������ ���½��ϴ�.");

			NoteBoxVO note = new NoteBoxVO();

			notes.add(note);

			return 0;
		}
	}
}