package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OJackGyuoMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Article> articles = new ArrayList<>();
		List<Customer> customers = new ArrayList<>();
		List<QnA> qnAList = new ArrayList<>();
		ArrayList<NoteBox> noteBoxs = new ArrayList<>();

		Customer loginedCustomer = null;
		System.out.println("결혼정보회사 \"오작교\" 에 오신걸 환영합니다 !");
		System.out.println();

		boolean run = true;
		while (run) {
			System.out.println("================================================================");
			System.out.println("1. 회원가입 / 2. 로그인 / 3. ID, PW 찾기 / 9. 고객센터 / 0. 프로그램 종료");
			System.out.println("================================================================");
			System.out.print("번호입력 > ");
			int homeMenu;
			try {
				homeMenu = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e1) {
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			switch (homeMenu) {
			case 1:
				System.out.println("오작교 회원가입에 오신걸 환영합니다.");

				boolean joinable = false;
				boolean joinRun = true;
				String customerId = null;
				while (joinRun) {
					System.out.print("아이디를 입력하세요 > ");
					customerId = scanner.nextLine();

					for (Customer customer : customers) {
						if (customer.getCustomerId().equals(customerId)) {
							joinable = true;
							break;
						}
					}
					if (joinable) {
						System.out.println("이미 존재하는 아이디입니다.");
						continue;
					}
					break;
				}

				String customerPw = null;
				String checkCustomerPw = null;
				while (true) {
					System.out.print("비밀번호를 입력하세요 > ");
					customerPw = scanner.nextLine();

					System.out.print("비밀번호를 다시 한번 더 입력해주세요 >");
					checkCustomerPw = scanner.nextLine();

					if (!customerPw.equals(checkCustomerPw)) {
						System.out.println("비밀번호가 일치하지 않습니다.");
						continue;
					}
					break;
				}

				System.out.print("이름을 입력하세요 >");
				String name = scanner.nextLine();

				int age;
				try {
					System.out.print("나이를 입력하세요 > ");
					age = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("나이는 숫자만 입력 가능합니다.");
					continue;
				}

				System.out.print("핸드폰 번호를 입력하세요 > ");
				String phone = scanner.nextLine();

				System.out.print("메일을 입력하세요 > ");
				String mail = scanner.nextLine();

				System.out.print("주민등록번호를 입력해주세요 (-까지 같이 입력해주세요.) > ");
				String regno = scanner.nextLine();

				System.out.print("성별을 입력하세요 (남/여) > ");
				String jender = scanner.nextLine();

				System.out.print("결혼 여부를 입력하세요 (초혼/재혼) > ");
				String marry = scanner.nextLine();

				int post;
				try {
					System.out.print("우편번호를 입력하세요 > ");
					post = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("우편번호는 숫자만 입력 가능합니다.");
					continue;
				}

				System.out.print("주소를 입력하세요 > ");
				String add = scanner.nextLine();

				System.out.print("상세 주소를 입력하세요 > ");
				String dao = scanner.nextLine();

				System.out.print("직업을 입력해주세요 > ");
				String job = scanner.nextLine();

				System.out.print("아이디 찾기 힌트(별명을 입력해주시오) > ");
				String hint = scanner.nextLine();

				Customer customer = new Customer(customerId, customerPw, name, age, phone, mail, regno, jender, marry,
						post, add, dao, job, hint);
				customers.add(customer);

				System.out.println(customer.getName() + "님 아이디를 생성하였습니다.");

				break;
			case 2:
				System.out.println("로그인 ID > ");
				String loginId = scanner.nextLine();

				Customer foundCustomer = null;

				for (Customer customer1 : customers) {
					if (customer1.getCustomerId().equals(loginId)) {
						foundCustomer = customer1;
					}
				}
				if(foundCustomer == null) {
					System.out.println("존재하지 않는 아이디입니다.");
					continue;
				}
				System.out.println("로그인 PW > ");
				String loginPw = scanner.nextLine();

				if (!foundCustomer.getCustomerPw().equals(loginPw)) {
					System.out.println("비밀번호를 확인해주세요.");
					continue;
				}

				System.out.println(foundCustomer.getName() + "님 로그인 되었습니다.");
				foundCustomer = loginedCustomer;

				boolean mainRun = true; // 메인화면
				while (mainRun) {
					System.out.println("=====================================================");
					System.out.println("1. 쪽지발송 / 2. 쪽지함 / 3. 결제 / 4. 공지사항 / 5. 로그아웃");
					System.out.println("=====================================================");
					System.out.print("번호 입력 > ");
					int mainMenu = Integer.parseInt(scanner.nextLine());

					switch (mainMenu) {
					case 1:
						boolean sendRun = false;
						System.out.print("받는분의 아이디 > ");
						String sendId = scanner.nextLine();

						for (Customer customer1 : customers) {
							if (!customer1.getCustomerId().equals(sendId)) {
								sendRun = true;
								break;
							}
						}
						if (sendRun) {
							System.out.println("아이디가 존재하지 않습니다.");
							continue;
						}

						System.out.println("제목 > ");
						String nBTitle = scanner.nextLine();
						System.out.println("내용 >");
						String nBBody = scanner.nextLine();

						System.out.println("성공적으로 쪽지를 보냈습니다.");

						NoteBox noteBox = new NoteBox(null, sendId, nBTitle, nBBody);

						noteBoxs.add(noteBox);
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
									System.out.println(article.getTitle());
								}

								break;
							case 2:
								System.out.println("홈으로 이동합니다.");
								serviceRun = false;
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
							default:
								System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
								break;
							}
						}
						break;
					case 5:
						loginedCustomer = null;
						System.out.println("로그아웃 되었습니다.");
						mainRun = false;
						break;
					default:
						System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
						break;
					}
				}
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
					System.out.println("오작교 QnA 입니다. 제목을 보고 번호를 입력해주세요.");
					boolean qnaRun = true;
					while (qnaRun) {
						System.out.print("번호 입력 > ");
						int qnaNum = Integer.parseInt(scanner.nextLine());

					}
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
}

class Article {
	String title;
	String body;
	int id;

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

class QnA {
	String qnaTitle;
	String qnaBody;
	int qnAId;

	public QnA(String qnaTitle, String qnaBody, int qnAId) {
		this.qnaTitle = qnaTitle;
		this.qnaBody = qnaBody;
	}
}

class Customer {
	private String customerId;
	private String customerPw;
	private String name;
	private int age;
	private String phone;
	private String mail;
	private String regno;
	private String jnder;
	private String marry;
	private int post;
	private String address;
	private String accurateaddress;
	private String job;
	private int ntqty;
	private String hint;
	private LocalDateTime informationDate;

	public Customer(String customerId, String customerPw, String name, int age, String phone, String mail, String regno,
			String jnder, String marry, int post, String address, String accurateaddress, String job, String hint) {
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.mail = mail;
		this.regno = regno;
		this.jnder = jnder;
		this.marry = marry;
		this.post = post;
		this.address = address;
		this.accurateaddress = accurateaddress;
		this.job = job;
		this.hint = hint;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getJnder() {
		return jnder;
	}

	public void setJnder(String jnder) {
		this.jnder = jnder;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccurateaddress() {
		return accurateaddress;
	}

	public void setAccurateaddress(String accurateaddress) {
		this.accurateaddress = accurateaddress;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getNtqty() {
		return ntqty;
	}

	public void setNtqty(int ntqty) {
		this.ntqty = ntqty;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public LocalDateTime getInformationDate() {
		return informationDate;
	}

	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accurateaddress, address, age, customerId, customerPw, hint, informationDate, jnder, job,
				mail, marry, name, ntqty, phone, post, regno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accurateaddress, other.accurateaddress) && Objects.equals(address, other.address)
				&& age == other.age && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerPw, other.customerPw) && Objects.equals(hint, other.hint)
				&& Objects.equals(informationDate, other.informationDate) && Objects.equals(jnder, other.jnder)
				&& Objects.equals(job, other.job) && Objects.equals(mail, other.mail)
				&& Objects.equals(marry, other.marry) && Objects.equals(name, other.name) && ntqty == other.ntqty
				&& Objects.equals(phone, other.phone) && post == other.post && Objects.equals(regno, other.regno);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPw=" + customerPw + ", name=" + name + ", age=" + age
				+ ", phone=" + phone + ", mail=" + mail + ", regno=" + regno + ", jnder=" + jnder + ", marry=" + marry
				+ ", post=" + post + ", address=" + address + ", accurateaddress=" + accurateaddress + ", job=" + job
				+ ", ntqty=" + ntqty + ", hint=" + hint + ", informationDate=" + informationDate + "]";
	}
}

class NoteBox {
	String sendId;
	String reciveId;
	String nBTitle;
	String nBBody;

	public NoteBox(String sendId, String reciveId, String nBTitle, String nBBody) {
		this.sendId = sendId;
		this.reciveId = reciveId;
		this.nBTitle = nBTitle;
		this.nBBody = nBBody;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getReciveId() {
		return reciveId;
	}

	public void setReciveId(String reciveId) {
		this.reciveId = reciveId;
	}

	public String getnBTitle() {
		return nBTitle;
	}

	public void setnBTitle(String nBTitle) {
		this.nBTitle = nBTitle;
	}

	public String getnBBody() {
		return nBBody;
	}

	public void setnBBody(String nBBody) {
		this.nBBody = nBBody;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nBBody, nBTitle, reciveId, sendId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteBox other = (NoteBox) obj;
		return Objects.equals(nBBody, other.nBBody) && Objects.equals(nBTitle, other.nBTitle)
				&& Objects.equals(reciveId, other.reciveId) && Objects.equals(sendId, other.sendId);
	}

	@Override
	public String toString() {
		return "NoteBox [sendId=" + sendId + ", reciveId=" + reciveId + ", nBTitle=" + nBTitle + ", nBBody=" + nBBody
				+ "]";
	}

}