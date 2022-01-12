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

		joinDAO.insertMember(new CustomerVO(customerId, customerPw, name, age, phone, mail, regno, jender, marry, post,
				add, dao, job, hint));
		return View.JOIN;

	}
}
