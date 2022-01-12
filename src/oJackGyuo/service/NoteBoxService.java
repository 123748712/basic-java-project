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

	public static NoteBoxService getInstance() { // 쪽지발송
		if (instance == null) {
			instance = new NoteBoxService();
		}
		return instance;
	}

	List<NoteBoxVO> notes = new ArrayList<>();

	public int noteSend() {
		boolean sendRun = false;
		while (true) {
			System.out.print("받는분의 아이디 > ");
			String sendId = ScannerUtil.nextLine();
			// 보내는 사람 체크

			System.out.println("제목 > ");
			String nBTitle = ScannerUtil.nextLine();
			System.out.println("내용 >");
			String nBBody = ScannerUtil.nextLine();

			System.out.println("성공적으로 쪽지를 보냈습니다.");

			NoteBoxVO note = new NoteBoxVO();

			notes.add(note);

			return 0;
		}
	}
}
