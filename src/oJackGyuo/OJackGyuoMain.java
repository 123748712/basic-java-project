package oJackGyuo;

import java.util.ArrayList;
import java.util.List;
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
			System.out.print("��ȣ�Է� > ");
			int homeMenu = Integer.parseInt(scanner.nextLine());
			switch (homeMenu) {
			case 1:
				System.out.println("���۱� ȸ�����Կ� ���Ű� ȯ���մϴ�.");
				break;
			case 2:
				mainView(scanner);
				break;
			case 3:
				break;
			case 9:
				System.out.println("������ ȭ���Դϴ�.");
				System.out.println("=====================================");
				System.out.println("1. ������ȭ��ȣ / 2. QnA / 3. Ȩ���� �̵�");
				System.out.println("=====================================");
				System.out.print("��ȣ �Է� > ");
				int serviceNum = Integer.parseInt(scanner.nextLine());
				switch (serviceNum) {
				case 1:
					System.out.println("������ ���� ��ȭ��ȣ�Դϴ�.");
					System.out.println("��ȭ��ȣ > 010-8342-7973");
					break;
				case 2:
					System.out.println("���۱� QnA �Դϴ�.");
					break;
				case 3:
					System.out.println("Ȩȭ������ �̵��մϴ�.");
					break;
				}
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
		scanner.close();
	}

	public static void mainView(Scanner scanner) {
		List<Article> articles = new ArrayList<>();
		boolean mainRun = true;
		while (mainRun) {
			System.out.println("=====================================================");
			System.out.println("1. �����߼� / 2. ������ / 3. ���� / 4. �������� / 5. �α׾ƿ�");
			System.out.println("=====================================================");
			System.out.print("��ȣ �Է� > ");
			int mainMenu = Integer.parseInt(scanner.nextLine());

			switch (mainMenu) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("���۱� �������� �Դϴ�.");
				boolean serviceRun = true;
				while (serviceRun) {
					System.out.println("=============================================");
					System.out.println("1. �������� �Խ��� / 2. Ȩ���� �̵� / 0. �������� �Է�");
					System.out.println("=============================================");
					System.out.print("��ȣ �Է� > ");
					int serviceNum = Integer.parseInt(scanner.nextLine());
					switch (serviceNum) {
					case 1:
						System.out.println("�������� �Խ����Դϴ�.");

						System.out.println("����");
						for (Article article : articles) {
							System.out.println(article.title);
						}
						break;
					case 2:
						System.out.println("Ȩ���� �̵��մϴ�.");
						serviceRun = false;
						mainView(scanner);
						break;
					case 0:
						System.out.print("���� > ");
						String title = scanner.nextLine();
						System.out.print("���� > ");
						String body = scanner.nextLine();

						System.out.println("���������� ���ε� �Ǿ����ϴ�.");
						Article article = new Article(title, body);
						articles.add(article);
						break;
					default :
						System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						break;
					}
				}
				break;
			case 5:
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				mainRun = false;
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
		}
	}
}

class Article {
	String title;
	String body;

	public Article(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
