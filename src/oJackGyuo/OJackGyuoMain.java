package oJackGyuo;

import java.util.Scanner;

public class OJackGyuoMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ȥ����ȸ�� \"���۱�\" �� ���Ű� ȯ���մϴ� !");
		System.out.println();

		boolean run = true;
		while (run) {
			System.out.println("================================================================");
			System.out.println("1. ȸ������ / 2. �α��� / 3. ID, PW ã�� / 9. ������ / 0. ���α׷� ����");
			System.out.println("================================================================");
			System.out.println("��ȣ�Է� > ");
			int enterNo = Integer.parseInt(scanner.nextLine());
			switch (enterNo) {
			case 1:
				break;
			case 2:
				System.out.println("�α��� ID > ");
				String LoginId = scanner.nextLine();
				
				System.out.println("�α��� PW > ");
				String loginPw = scanner.nextLine();
				
				
				
				
				break;
			case 3:
				break;
			case 9:
				System.out.println("������ ȭ���Դϴ�.");
				System.out.println("");
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�. �̿����ּż� �����մϴ�.");
				run = false;
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
		}

	}
}
