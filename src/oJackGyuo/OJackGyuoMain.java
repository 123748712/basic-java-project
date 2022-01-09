package oJackGyuo;

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
			System.out.println("번호입력 > ");
			int enterNo = Integer.parseInt(scanner.nextLine());
			switch (enterNo) {
			case 1:
				break;
			case 2:
				System.out.println("로그인 ID > ");
				String LoginId = scanner.nextLine();
				
				System.out.println("로그인 PW > ");
				String loginPw = scanner.nextLine();
				
				
				
				
				break;
			case 3:
				break;
			case 9:
				System.out.println("고객센터 화면입니다.");
				System.out.println("");
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

	}
}
