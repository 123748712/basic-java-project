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
		System.out.print("���̵� �Է��ϼ��� (����,���� ����Ͽ� 3~16�� �Է�)> ");
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
				System.out.println("�ߺ��� ���̵� �ְų� �ùٸ� ������ �ƴմϴ�.\t");
				System.out.print("���̵� ���Է����ֽÿ�>");
			}

			for (CustomerVO customer : customers) {
				if (customer.getCustomerId().equals(customerId)) {
					joinRun = true;
					break;
				}
			}
			if (joinRun) {
				System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
				continue;
			}
		}

		System.out.println();
		System.out.println("��й�ȣ�� ������+����+Ư�����ڸ� �����Ͽ� 8~20�ڸ��� �ۼ��Ͽ��ּ���.");
		System.out.print("��й�ȣ�� �Է��ϼ��� > ");
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
				System.out.println("�ùٸ� ��й�ȣ ������ �ƴմϴ�.");
				System.out.println("�ٽ� �Է��Ͽ� �ֽʽÿ�.");
			}
		}
		while (true) {
			System.out.println("��й�ȣ�� �ٽ� �ѹ� �� �Է����ּ��� >");
			String customerPwConform = ScannerUtil.nextLine();
			if (!customerPw.equals(customerPwConform)) {
				System.out.println("�ùٸ� ��й�ȣ ������ �ƴմϴ�.");
				System.out.println("�ٽ� �Է��Ͽ� �ֽʽÿ�.");
			} else {
				break;
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
		System.out.println("�α��� ID > ");
		String loginId = scanner.nextLine();
		System.out.println("loginId : " + loginId);
		//�̱�������
		LoginedCustomer loginedCustomer = LoginedCustomer.getInstance();
		CustomerVO foundCustomer = new CustomerVO();

//			for (CustomerVO customer1 : customers) {
//				if (customer1.getCustomerId().equals(loginId)) {
//					foundCustomer = customer1;
//				}
//			}
//			if(foundCustomer == null) {
//				System.out.println("�������� �ʴ� ���̵��Դϴ�.");
//				continue;
//			}

		System.out.println("�α��� PW > ");
		String loginPw = scanner.nextLine();
		
		System.out.println("loginPw : " + loginPw);
		
		foundCustomer.setCustomerId(loginId);
		foundCustomer.setCustomerPw(loginPw);

		List<CustomerVO> customers = joinDAO.selectCustomers(foundCustomer);

		if (customers.size() < 1) {
			System.out.println("���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
		} else {
			System.out.println(customers.get(0).getName() + "�� �α��� �Ǿ����ϴ�.");
//				foundCustomer = loginedCustomer;
			//loginedCustomer ��ü�� �̱��� �������� �����ǰ� ����
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
			return View.NOTEBOX;
		case 4:
			return View.NOTICE;
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
