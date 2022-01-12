package oJackGyuo.service;

import java.util.ArrayList;
import java.util.List;

import oJackGyuo.ScannerUtil;
import oJackGyuo.View;
import oJackGyuo.dao.NoteBoxDAO;
import oJackGyuo.vo.NoteBoxVO;

public class NoteBoxService{
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
		
		System.out.println("제목 > ");
		String nBTitle = ScannerUtil.nextLine();
		System.out.println("내용 > ");
		String nBBody = ScannerUtil.nextLine();
		
		System.out.println("받는 아이디 > ");
		String nBMember = ScannerUtil.nextLine();
		if (noteBoxDAO.selectMemId(nBMember)) {
			noteBoxDAO.insertNoteBox(new NoteBoxVO(nBTitle, nBBody, nBMember));
		} else {
			System.out.println("올바르지 않은 아이디입니다.");
		}
		return View.MAIN;
	}
}