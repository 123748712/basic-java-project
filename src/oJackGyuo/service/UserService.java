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
import oJackGyuo.dao.NoteBoxDAO;
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

	private NoteBoxDAO noteBoxDAO = NoteBoxDAO.getInstance();

	public int join() throws Exception {

		boolean idRun = true;
		String customerId = null;
		while (idRun) {
			System.out.println("���̵� > ");
			customerId = ScannerUtil.nextLine();
			if (noteBoxDAO.getInstance().selectMemId(customerId)) {
				System.out.println("�ߺ��� ���̵�");
				continue;
			} else {
				idRun = false;
			}
		}

		boolean pwRun = true;
		String customerPw = null;
		String checkCustomerPw = null;
		while (pwRun) {
			System.out.println("���");
			customerPw = ScannerUtil.nextLine();

			System.out.println("��� Ȯ��");
			checkCustomerPw = ScannerUtil.nextLine();

			if (!customerPw.equals(checkCustomerPw)) {
				System.out.println("��� Ʋ�� �ٽ���");
				continue;
			} else {
				pwRun = false;
			}

		}
		System.out.println("�̸��� �Է��Ͻÿ�>");
		String name = ScannerUtil.nextLine();

		int age = 0;
		System.out.println("���̸� �Է��Ͻÿ�> ");
		while (true) {
			try {
				age = Integer.parseInt(ScannerUtil.nextLine());
				break;
			} catch (java.lang.NumberFormatException e) {
				System.out.println("���ڸ� �Է°����մϴ�. �ٽ��Է����ּ���>");
				continue;
			}
		}

		System.out.println("�ڵ��� ��ȣ�� �Է��Ͻÿ�(000-0000-0000 ����)>");// ���Խ�
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
				System.out.println("��ȭ��ȣ ������ �߸��Ǿ����ϴ�.");
				System.out.println("�ٽ� �Է��Ͽ� �ֽʽÿ�.");
			}
		}
		System.out.println("������ �Է����ֽÿ�>");
		String mail = ScannerUtil.nextLine();

		System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ��� > (-���� ���� �Է����ּ���.)"); // ���Խ�
		String regno = ScannerUtil.nextLine();

		System.out.println("������ �Է����ֽÿ�>");
		String jender = ScannerUtil.nextLine();

		System.out.println("��ȥ ���θ� �Է����ֽÿ�>");
		String marry = ScannerUtil.nextLine();

		System.out.println("�����ȣ�� �Է����ֽÿ�>");
		int post = Integer.parseInt(ScannerUtil.nextLine());

		System.out.println("�ּҸ� �Է����ֽÿ�>");
		String add = ScannerUtil.nextLine();

		System.out.println("�� �ּҸ� �Է����ֽÿ�>");
		String dao = ScannerUtil.nextLine();

		System.out.println("������ �Է����ּ���>");
		String job = ScannerUtil.nextLine();

		System.out.println("���̵� ã�� ��Ʈ(������ �Է����ֽÿ�)>");
		String hint = ScannerUtil.nextLine();

		joinDAO.insertCustomer(new CustomerVO(customerId, customerPw, name, age, phone, mail, regno, jender, marry,
				post, add, dao, job, hint));

		return View.HOME;

	}

	public int login() throws Exception {
		// �̱�������
		LoginedCustomer loginedCustomer = LoginedCustomer.getInstance();
		String loginId = null;
		String loginPw = null;
		boolean idRun = true;
		CustomerVO foundCustomer = new CustomerVO(loginId, loginPw);
		while (idRun) {
			System.out.println("�α��� ID > ");
			loginId = scanner.nextLine();
			if (noteBoxDAO.getInstance().selectMemId(loginId)) {
				foundCustomer.setCustomerId(loginId);
				System.out.println("loginId : " + loginId);
				idRun = false;
			} else {
				System.out.println("���̵� Ʋ�� �ٽ�");
			}
		}

		boolean pwRun = true;
		while (pwRun) {
			System.out.println("�α��� PW > ");
			loginPw = scanner.nextLine();
			if (loginPw.equals(joinDAO.savePw(loginId))) {
				foundCustomer.setCustomerPw(loginPw);
				pwRun = false;
			} else {
				System.out.println("Ʋ�� �ٽ�.");
			}
		}
		System.out.println("loginPw : " + loginPw);

		LoginedCustomer.getInstance().setLoginedCustomer(foundCustomer);

		LoginedCustomer.getInstance().setLoginedCustomer(foundCustomer);

		List<CustomerVO> customers = joinDAO.selectCustomers(foundCustomer);

		if (customers.size() < 1) {
			System.out.println("���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
		} else {
			System.out.println(customers.get(0).getName() + "�� �α��� �Ǿ����ϴ�.");
//				foundCustomer = loginedCustomer;
			// loginedCustomer ��ü�� �̱��� �������� �����ǰ� ����
			loginedCustomer.setLoginedCustomer(foundCustomer);
		}
		return View.MAIN;

	}// end login()

	public int main() {
		System.out.println("=====================================================");
		System.out.println("1. �����߼� / 2. ������ / 3. ���� / 4. �������� / 5. �α׾ƿ�");
		System.out.println("=====================================================");
		System.out.print("��ȣ �Է� > ");
		int mainMenu = Integer.parseInt(scanner.nextLine());
		switch (mainMenu) {
		case 1:
			return View.SENDNB;
		case 2:
			return View.NOTEBOX;
		case 4:
			return View.NOTICE;
		case 5:
			return View.LOGOUT;
		default:
			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			return View.MAIN;
		}
	}

	public int searchId() {
		System.out.println("ȸ�� ������ �Է����ּ���.");
		System.out.print("�̸� > ");
		String name = scanner.nextLine();
		System.out.print("��Ʈ �Է� > ");
		String hint = scanner.nextLine();
		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");

		return View.HOME;
	}

	public int service() {
		System.out.println("������ ȭ���Դϴ�.");
		System.out.println("=====================================");
		System.out.println("1. ������ȭ��ȣ / 2. QnA�Խ��� / 3. Ȩ���� �̵�");
		System.out.println("=====================================");
		System.out.print("��ȣ �Է� > ");
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
		System.out.println("������ ���� ��ȭ��ȣ�Դϴ�.");
		System.out.println("��ȭ��ȣ > 010-8342-7973");
		System.out.println("-----------------------");
		System.out.println("0.������");
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
		System.out.println("1.���̵� �𸣰ھ��!");
		System.out.println("2.��й�ȣ�� ����� �ȳ��ϴ�!");
		System.out.println("3.������ ��� ��������?");
		System.out.println("4.���� ����� ��� �ǳ���?");
		System.out.println("5.������ ��ȭ��ȣ�� �˰�ͽ��ϴ�.");
		System.out.println("0.������");
		System.out.println("----------------------------- ");
		System.out.println("�Է�>");
		int sc = ScannerUtil.nextint();
		switch (sc) {
		case 1:
			System.out.println("-------------------------");
			System.out.println("����: ���̵� �𸣰ھ��!");
			System.out.println("�亯: ID/PW�������� ���̵� ã���ø�˴ϴ�.");
			System.out.println("0.������");
			System.out.println("--------------------------");
			System.out.println("�Է�>");
			String sc1 = ScannerUtil.nextLine();
			return View.SERVICE_QNA;
		case 2:
			System.out.println("-------------------------");
			System.out.println("����: ��й�ȣ�� ����� �ȳ��ϴ�.");
			System.out.println("�亯: ID/PW�������� ���̵� ã���ø�˴ϴ�.");
			System.out.println("--------------------------");
			System.out.println("�������� �ƹ�Ű�� �����ּ���!");
			sc1 = ScannerUtil.nextLine();
			return View.SERVICE_QNA;
		case 3:
			System.out.println("-------------------------");
			System.out.println("����: ������ ��� ��������?");
			System.out.println("�亯: �α��� �� > ������ > ���� �����⿡ ���ø� �˴ϴ�.");
			System.out.println("--------------------------");
			System.out.println("�������� �ƹ�Ű�� �����ּ���!");
			sc1 = ScannerUtil.nextLine();
			return View.SERVICE_QNA;
		case 0:
			return View.SERVICE;

		}
		return View.SERVICE;
	}

}
