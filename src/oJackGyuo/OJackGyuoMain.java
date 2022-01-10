package oJackGyuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OJackGyuoMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("결혼정보회사 \"오작교\" 에 오신걸 환영합니다 !");
		System.out.println();

		boolean run = true;
		while (run) {
			System.out.println("================================================================");
			System.out.println("1. 회원가입 / 2. 로그인 / 3. ID, PW 찾기 / 9. 고객센터 / 0. 프로그램 종료");
			System.out.println("================================================================");
			System.out.print("번호입력 > ");
			int homeMenu = Integer.parseInt(scanner.nextLine());
			switch (homeMenu) {
			case 1:
				System.out.println("오작교 회원가입에 오신걸 환영합니다.");
				break;
			case 2:
				mainView(scanner);
				break;
			case 3:
				break;
			case 9:
				System.out.println("고객센터 화면입니다.");
				System.out.println("=====================================");
				System.out.println("1. 서비스전화번호 / 2. QnA / 3. 홈으로 이동");
				System.out.println("=====================================");
				System.out.print("번호 입력 > ");
				int serviceNum = Integer.parseInt(scanner.nextLine());
				switch (serviceNum) {
				case 1:
					System.out.println("고객센터 서비스 전화번호입니다.");
					System.out.println("전화번호 > 010-8342-7973");
					break;
				case 2:
					System.out.println("오작교 QnA 입니다.");
					break;
				case 3:
					System.out.println("홈화면으로 이동합니다.");
					break;
				}
				break;
			case 0:
				System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
				run = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
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
			System.out.println("1. 쪽지발송 / 2. 쪽지함 / 3. 결제 / 4. 공지사항 / 5. 로그아웃");
			System.out.println("=====================================================");
			System.out.print("번호 입력 > ");
			int mainMenu = Integer.parseInt(scanner.nextLine());

			switch (mainMenu) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("오작교 공지사항 입니다.");
				boolean serviceRun = true;
				while (serviceRun) {
					System.out.println("=============================================");
					System.out.println("1. 공지사항 게시판 / 2. 홈으로 이동 / 0. 공지사항 입력");
					System.out.println("=============================================");
					System.out.print("번호 입력 > ");
					int serviceNum = Integer.parseInt(scanner.nextLine());
					switch (serviceNum) {
					case 1:
						System.out.println("공지사항 게시판입니다.");

						System.out.println("제목");
						for (Article article : articles) {
							System.out.println(article.title);
						}
						break;
					case 2:
						System.out.println("홈으로 이동합니다.");
						serviceRun = false;
						mainView(scanner);
						break;
					case 0:
						System.out.print("제목 > ");
						String title = scanner.nextLine();
						System.out.print("내용 > ");
						String body = scanner.nextLine();

						System.out.println("공지사항이 업로드 되었습니다.");
						Article article = new Article(title, body);
						articles.add(article);
						break;
					default :
						System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
						break;
					}
				}
				break;
			case 5:
				System.out.println("로그아웃 되었습니다.");
				mainRun = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
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
