package oJackGyuo;

public interface View {
	int HOME = 0; // ����ȭ��
	int JOIN = 1; // ȸ������
	int LOGIN = 2; // �α���
	int SEARCH = 4; // ���̵�,��й�ȣ ã��
	int SERVICE = 9; // ������
	int SERVICE_NUM = 8; // ������ ��ȭ��ȣ
	int SERVICE_QNA = 7; // ������ QNA

	int MAIN = 11; // ����ȭ��
	int SENDNB = 12; // ����������
	int NOTEBOX = 13; // ������
	int PAY = 14; // ����
	int NOTICE = 15; // ��������
	int NOTICE_BOARD = 17; // �������� �Խ���
	int LOGOUT = 16; // �α׾ƿ�

	// �������� ��
	int ARTICLE = 21; // �������� �Խ���
	int ARTICLE_WRITER = 22; // �۾���
	int ARTICLE_MODIFY = 23; // ����
	int ARTICLE_DELETE = 24; // ����

	int EXIT = 99;
}