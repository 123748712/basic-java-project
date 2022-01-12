package oJackGyuo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	private JoinDAO joinDAO = JoinDAO.getInstance();
	List<CustomerVO> customers = new ArrayList<>();

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

		joinDAO.insertMember(new CustomerVO(customerId, customerPw, name, age, phone, mail, regno, jender, marry, post,
				add, dao, job, hint));
		return View.JOIN;

	}
}
