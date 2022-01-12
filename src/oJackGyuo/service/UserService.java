package oJackGyuo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oJackGyuo.LoginedCustomer;
import oJackGyuo.ScannerUtil;
import oJackGyuo.View;
import oJackGyuo.dao.JoinDAO;
import oJackGyuo.vo.CustomerVO;

public class UserService {
	private UserService() {
	}

	private static UserService instance;

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	Scanner scanner = new Scanner(System.in);
	List<CustomerVO> customers = new ArrayList<>();
	private JoinDAO joinDAO = JoinDAO.getInstance();

	public int join() throws Exception {

		boolean joinRun = false;
		System.out.print("아이디를 입력하세요 (영어,숫자 사용하여 3~16자 입력)> ");
		String customerId = "^$";
		String idre = "^[a-zA-Z0-9]{3,16}$";
		Pattern re1 = Pattern.compile(idre);
		Matcher re2 = re1.matcher(customerId);

		while (re2.matches() == false) {
			customerId = ScannerUtil.nextLine();
			idre = "^[a-zA-Z0-9]{3,16}$";
			re1 = Pattern.compile(idre);
			re2 = re1.matcher(customerId);
			if (re2.matches() == false) {
				System.out.println("중복된 아이디가 있거나 올바른 형식이 아닙니다.\t");
				System.out.print("아이디를 재입력해주시오>");
			}

			for (CustomerVO customer : customers) {
				if (customer.getCustomerId().equals(customerId)) {
					joinRun = true;
					break;
				}
			}
			if (joinRun) {
				System.out.println("이미 존재하는 아이디입니다.");
				continue;
			}
		}

		System.out.println();
		System.out.println("비밀번호는 영문자+숫자+특수문자를 포함하여 8~20자리로 작성하여주세요.");
		System.out.print("비밀번호를 입력하세요 > ");
		String customerPw = "";
		String pwnc = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";

		Pattern pwnc1 = Pattern.compile(pwnc);
		Matcher pwnc2 = pwnc1.matcher(customerPw);

		while (pwnc2.matches() == false) {
			customerPw = ScannerUtil.nextLine();
			pwnc = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
			pwnc1 = Pattern.compile(pwnc);
			pwnc2 = pwnc1.matcher(customerPw);
			if (pwnc2.matches() == false) {
				System.out.println("올바른 비밀번호 형식이 아닙니다.");
				System.out.println("다시 입력하여 주십시오.");
			}
		}
		while (true) {
			System.out.println("비밀번호를 다시 한번 더 입력해주세요 >");
			String customerPwConform = ScannerUtil.nextLine();
			if (!customerPw.equals(customerPwConform)) {
				System.out.println("올바른 비밀번호 형식이 아닙니다.");
				System.out.println("다시 입력하여 주십시오.");
			} else {
				break;
			}
		}

		System.out.println("이름을 입력하시오>");
		String name = ScannerUtil.nextLine();

		int age = 0;
		System.out.println("나이를 입력하시오> ");
		while (true) {
			try {
				age = Integer.parseInt(ScannerUtil.nextLine());
				break;
			} catch (java.lang.NumberFormatException e) {
				System.out.println("숫자만 입력가능합니다. 다시입력해주세요>");
				continue;
			}
		}

		System.out.println("핸드폰 번호를 입력하시오(000-0000-0000 형식)>");// 정규식
		String phone = " ";
		String phonenc = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
		Pattern phonenc1 = Pattern.compile(phonenc);
		Matcher phonenc2 = phonenc1.matcher(phone);
		while (phonenc2.matches() == false) {
			phone = ScannerUtil.nextLine();
			phonenc = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
			phonenc1 = Pattern.compile(phonenc);
			phonenc2 = phonenc1.matcher(phone);
			if (phonenc2.matches() == false) {
				System.out.println("전화번호 형식이 잘못되었습니다.");
				System.out.println("다시 입력하여 주십시오.");
			}
		}
		System.out.println("메일을 입력해주시오>");
		String mail = ScannerUtil.nextLine();

		System.out.println("주민등록번호를 입력해주세요 > (-까지 같이 입력해주세요.)"); // 정규식
		String regno = ScannerUtil.nextLine();

		System.out.println("성별을 입력해주시오>");
		String jender = ScannerUtil.nextLine();

		System.out.println("결혼 여부를 입력해주시오>");
		String marry = ScannerUtil.nextLine();

		System.out.println("우편번호를 입력해주시오>");
		int post = Integer.parseInt(ScannerUtil.nextLine());

		System.out.println("주소를 입력해주시오>");
		String add = ScannerUtil.nextLine();

		System.out.println("상세 주소를 입력해주시오>");
		String dao = ScannerUtil.nextLine();

		System.out.println("직업을 입력해주세요>");
		String job = ScannerUtil.nextLine();

		System.out.println("아이디 찾기 힌트(별명을 입력해주시오)>");
		String hint = ScannerUtil.nextLine();

		joinDAO.insertCustomer(new CustomerVO(customerId, customerPw, name, age, phone, mail, regno, jender, marry,
				post, add, dao, job, hint));
		return View.HOME;

	}

	public int login() throws Exception {
		System.out.println("로그인 ID > ");
		String loginId = scanner.nextLine();
		System.out.println("loginId : " + loginId);
		//싱글톤패턴
		LoginedCustomer loginedCustomer = LoginedCustomer.getInstance();
		CustomerVO foundCustomer = new CustomerVO();

//			for (CustomerVO customer1 : customers) {
//				if (customer1.getCustomerId().equals(loginId)) {
//					foundCustomer = customer1;
//				}
//			}
//			if(foundCustomer == null) {
//				System.out.println("존재하지 않는 아이디입니다.");
//				continue;
//			}

		System.out.println("로그인 PW > ");
		String loginPw = scanner.nextLine();
		
		System.out.println("loginPw : " + loginPw);
		
		foundCustomer.setCustomerId(loginId);
		foundCustomer.setCustomerPw(loginPw);

		List<CustomerVO> customers = joinDAO.selectCustomers(foundCustomer);

		if (customers.size() < 1) {
			System.out.println("아이디 또는 비밀번호를 확인해주세요.");
		} else {
			System.out.println(customers.get(0).getName() + "님 로그인 되었습니다.");
//				foundCustomer = loginedCustomer;
			//loginedCustomer 객체는 싱글톤 패턴으로 공유되고 있음
			loginedCustomer.setLoginedCustomer(foundCustomer);
		}

		return View.MAIN;
	}// end login()

	public int main() {
		System.out.println("=====================================================");
		System.out.println("1. 쪽지발송 / 2. 쪽지함 / 3. 결제 / 4. 공지사항 / 5. 로그아웃");
		System.out.println("=====================================================");
		System.out.print("번호 입력 > ");
		int mainMenu = Integer.parseInt(scanner.nextLine());
		switch (mainMenu) {
		case 1:
			return View.NOTEBOX;
		case 4:
			return View.NOTICE;
		default:
			System.out.println("번호를 잘못 입력하셨습니다.");
			return View.MAIN;
		}
	}

	public int searchId() {
		System.out.println("회원 정보를 입력해주세요.");
		System.out.print("이름 > ");
		String name = scanner.nextLine();
		System.out.print("힌트 입력 > ");
		String hint = scanner.nextLine();
		System.out.println("본인 인증이 완료되었습니다.");

		return View.HOME;
	}

	public int service() {
		System.out.println("고객센터 화면입니다.");
		System.out.println("=====================================");
		System.out.println("1. 서비스전화번호 / 2. QnA게시판 / 3. 홈으로 이동");
		System.out.println("=====================================");
		System.out.print("번호 입력 > ");
		int homeMenu = Integer.parseInt(ScannerUtil.nextLine());
		switch (homeMenu) {
		case 1:
			return View.SERVICE_NUM;
		case 2:
			return View.SERVICE_QNA;
		case 3:
			return View.HOME;
		}
		return View.HOME;
	}

	public int serviceNum() {
		System.out.println("고객센터 서비스 전화번호입니다.");
		System.out.println("전화번호 > 010-8342-7973");
		System.out.println("-----------------------");
		System.out.println("0.나가기");
		int noteNum = Integer.parseInt(ScannerUtil.nextLine());
		switch (noteNum) {
		case 0:
			return View.SERVICE;

		default:
			return View.SERVICE;

		}
	}

	public int serviceQna() {
		System.out.println("----------------------------- ");
		System.out.println("1.아이디를 모르겠어요!");
		System.out.println("2.비밀번호가 기억이 안납니다!");
		System.out.println("3.쪽지는 어떻게 보내나요?");
		System.out.println("4.결제 방법은 어떻게 되나여?");
		System.out.println("5.고객센터 전화번호를 알고싶습니다.");
		System.out.println("0.나가기");
		System.out.println("----------------------------- ");
		System.out.println("입력>");
		int sc = ScannerUtil.nextint();
		switch (sc) {
		case 1:
			System.out.println("-------------------------");
			System.out.println("제목: 아이디를 모르겠어요!");
			System.out.println("답변: ID/PW란에가서 아이디를 찾으시면됩니다.");
			System.out.println("0.나가기");
			System.out.println("--------------------------");
			System.out.println("입력>");
			String sc1 = ScannerUtil.nextLine();
			return View.SERVICE_QNA;
		case 2:
			System.out.println("-------------------------");
			System.out.println("제목: 비밀번호가 기억이 안납니다.");
			System.out.println("답변: ID/PW란에가서 아이디를 찾으시면됩니다.");
			System.out.println("--------------------------");
			System.out.println("나가려면 아무키나 눌러주세요!");
			sc1 = ScannerUtil.nextLine();
			return View.SERVICE_QNA;
		case 3:
			System.out.println("-------------------------");
			System.out.println("제목: 쪽지는 어떻게 보내나요?");
			System.out.println("답변: 로그인 후 > 쪽지함 > 쪽지 보내기에 들어가시면 됩니다.");
			System.out.println("--------------------------");
			System.out.println("나가려면 아무키나 눌러주세요!");
			sc1 = ScannerUtil.nextLine();
			return View.SERVICE_QNA;
		case 0:
			return View.SERVICE;

		}
		return View.SERVICE;
	}
}
