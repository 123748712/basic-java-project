package oJackGyuo;

public interface View {
	int HOME = 0; // 메인화면
	int JOIN = 1; // 회원가입
	int LOGIN = 2; // 로그인
	int SEARCH = 4; // 아이디,비밀번호 찾기
	int SERVICE = 9; // 고객센터
	int SERVICE_NUM = 8; // 고객센터 전화번호
	int SERVICE_QNA = 7; // 고객센터 QNA

	int MAIN = 11; // 메인화면
	int SENDNB = 12; // 쪽지보내기
	int NOTEBOX = 13; // 쪽지함
	int PAY = 14; // 결제
	int NOTICE = 15; // 공지사항
	int NOTICE_BOARD = 17; // 공지사항 게시판
	int LOGOUT = 16; // 로그아웃

	// 공지사항 인
	int ARTICLE = 21; // 공지사항 게시판
	int ARTICLE_WRITER = 22; // 글쓰기
	int ARTICLE_MODIFY = 23; // 수정
	int ARTICLE_DELETE = 24; // 삭제

	int EXIT = 99;
}