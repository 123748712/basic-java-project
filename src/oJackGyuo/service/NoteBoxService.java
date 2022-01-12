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
}