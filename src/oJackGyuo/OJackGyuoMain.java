package oJackGyuo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OJackGyuoMain {
	public static void main(String[] args) {

		List<Article> articles = new ArrayList<>();
		List<Customer> customers = new ArrayList<>();
		List<QnA> qnAList = new ArrayList<>();
		ArrayList<NoteBox> noteBoxs = new ArrayList<>();

		Customer loginedCustomer = null;
		System.out.println("��ȥ����ȸ�� \"���۱�\" �� ���Ű� ȯ���մϴ� !");
		System.out.println();

		boolean run = true;
		while (run) {
			System.out.println("================================================================");
			System.out.println("1. ȸ������ / 2. �α��� / 3. ID, PW ã�� / 9. ������ / 0. ���α׷� ����");
			System.out.println("================================================================");
			System.out.print("��ȣ�Է� > ");
			int homeMenu;
			try {
				homeMenu = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e1) {
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			switch (homeMenu) {
			case 1:
				String customerId = null;
				boolean joinRun = false;
				boolean homeRun = true;
				while (homeRun) {
					System.out.print("ȸ������ ID (����+���� 3~16�ڸ�) > ");
					customerId = "^$";
					String idre = "^[a-zA-Z0-9]{3,16}$";
					Pattern re1 = Pattern.compile(idre);
					Matcher re2 = re1.matcher(customerId);

					while (re2.matches() == false) {
						customerId = scanner.nextLine();
						idre = "^[a-zA-Z0-9]{3,16}$";
						re1 = Pattern.compile(idre);
						re2 = re1.matcher(customerId);
						if (re2.matches() == false) {
							System.out.println("�߸��� �����Դϴ�.");
							System.out.print("ȸ������ ID (����+���� 3~16�ڸ�) > ");
						}

						for (Customer customer : customers) {
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
					System.out.print("ȸ������ PW (����+����+Ư������ 8~20�ڸ�) > ");
					String customerPw = "";
					String pwnc = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";

					Pattern pwnc1 = Pattern.compile(pwnc);
					Matcher pwnc2 = pwnc1.matcher(customerPw);

					while (pwnc2.matches() == false) {
						customerPw = scanner.nextLine();
						pwnc = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
						pwnc1 = Pattern.compile(pwnc);
						pwnc2 = pwnc1.matcher(customerPw);
						if (pwnc2.matches() == false) {
							System.out.println("�߸��� �����Դϴ�.");
							System.out.print("ȸ������ PW (����+����+Ư������ 8~20�ڸ�) > ");
						}
					}
					while (true) {
						System.out.println("ȸ������ PW Ȯ�� >");
						String customerPwConform = scanner.nextLine();
						if (!customerPw.equals(customerPwConform)) {
							System.out.println("�߸��� �����Դϴ�.");
							System.out.print("ȸ������ PW Ȯ�� (����+����+Ư������ 8~20�ڸ�) > ");
						} else {
							break;
						}
					}

					System.out.println("�̸� >");
					String name = scanner.nextLine();

					int age;
					try {
						System.out.println("���� > ");
						age = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("���̴� ���ڸ� �Է� �����մϴ�.");
						continue;
					}

					System.out.println("�ڵ��� ��ȣ (- ����) >");
					String phone = " ";
					String phonenc = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
					Pattern phonenc1 = Pattern.compile(phonenc);
					Matcher phonenc2 = phonenc1.matcher(phone);
					while (phonenc2.matches() == false) {
						phone = scanner.nextLine();
						phonenc = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
						phonenc1 = Pattern.compile(phonenc);
						phonenc2 = phonenc1.matcher(phone);
						if (phonenc2.matches() == false) {
							System.out.println("�߸��� �����Դϴ�.");
							System.out.print("�ڵ��� ��ȣ (- ����) >");
						}
					}
					System.out.println("���� >");
					String mail = scanner.nextLine();

					System.out.println("�ֹε�Ϲ�ȣ > ");
					String regno = scanner.nextLine();
					System.out.println("���� (��/��) >");
					String jender = scanner.nextLine();

					System.out.println("��ȥ ���� (��ȥ/��ȥ) >");
					String marry = scanner.nextLine();

					System.out.println("�����ȣ >");
					int post = Integer.parseInt(scanner.nextLine());

					System.out.print("�ּ� >");
					String add = scanner.nextLine();

					System.out.print("���ּ� >");
					String dao = scanner.nextLine();

					System.out.print("���� >");
					String job = scanner.nextLine();

					System.out.print("���� (ȸ������ã�� ��Ʈ) > ");
					String hint = scanner.nextLine();

					Customer customer = new Customer(customerId, customerPw, name, age, phone, mail, regno, jender,
							marry, post, add, dao, job, hint);

					customers.add(customer);

					System.out.println("");
					break;
				}
				break;
			case 2:
				System.out.println("�α��� ID > ");
				String loginId = scanner.nextLine();

				Customer foundCustomer = null;

				for (Customer customer1 : customers) {
					if (customer1.getCustomerId().equals(loginId)) {
						foundCustomer = customer1;
					}
				}
				if (foundCustomer == null) {
					System.out.println("�������� �ʴ� ���̵��Դϴ�.");
					continue;
				}
				System.out.println("�α��� PW > ");
				String loginPw = scanner.nextLine();

				if (!foundCustomer.getCustomerPw().equals(loginPw)) {
					System.out.println("��й�ȣ�� Ȯ�����ּ���.");
					continue;
				}

				System.out.println(foundCustomer.getName() + "�� �α��� �Ǿ����ϴ�.");
				foundCustomer = loginedCustomer;

				boolean mainRun = true; // ����ȭ��
				while (mainRun) {
					System.out.println("=====================================================");
					System.out.println("1. �����߼� / 2. ������ / 3. ���� / 4. �������� / 5. �α׾ƿ�");
					System.out.println("=====================================================");
					System.out.print("��ȣ �Է� > ");
					int mainMenu = Integer.parseInt(scanner.nextLine());

					switch (mainMenu) {
					case 1:
						boolean sendRun = false;
						System.out.print("�޴º��� ���̵� > ");
						String sendId = scanner.nextLine();

						for (Customer customer1 : customers) {
							if (!customer1.getCustomerId().equals(sendId)) {
								sendRun = true;
								break;
							}
						}
						if (sendRun) {
							System.out.println("���̵� �������� �ʽ��ϴ�.");
							continue;
						}

						System.out.println("���� > ");
						String nBTitle = scanner.nextLine();
						System.out.println("���� >");
						String nBBody = scanner.nextLine();

						System.out.println("���������� ������ ���½��ϴ�.");

						NoteBox noteBox = new NoteBox(loginedCustomer.getCustomerId(), sendId, nBTitle, nBBody);

						noteBoxs.add(noteBox);

						break;
					case 2:
						System.out.println("=======================");
						System.out.println("1. ���� ���� / 2. ���� ���� / 3. Ȩ���� �̵�");
						System.out.println("=======================");
						System.out.print("��ȣ �Է� > ");
						int nTNum = Integer.parseInt(scanner.nextLine());
						switch (nTNum) {
						case 1:
							for (NoteBox noteBox1 : noteBoxs) {
								if (noteBox1.getReciveId().equals(loginedCustomer.getCustomerId())) {
									System.out.println(noteBox1.getnBTitle());
								}
							}
							break;
						case 2:
							break;
						}
					case 3:
						break;
					case 4:
						System.out.println("���۱� �������� �Դϴ�.");
						boolean serviceRun = true;
						while (serviceRun) {
							System.out.println("========================");
							System.out.println("1. �������� / 2. Ȩ���� �̵�");
							System.out.println("========================");
							System.out.print("��ȣ �Է� > ");
							int serviceNum = Integer.parseInt(scanner.nextLine());
							switch (serviceNum) {
							case 1:
								System.out.println("===============================================================");
								System.out.println("1. �������� �Խ��� / 2. �������� ��� / 3. �������� ���� / 4. �������� ����");
								System.out.println("===============================================================");
								System.out.print("��ȣ �Է� > ");
								int articleNum = Integer.parseInt(scanner.nextLine());
								switch (articleNum) {
								case 1:
									System.out.println("����");
									for (Article article : articles) {
										System.out.println(article.getTitle());
									}
									break;
								case 2:
									System.out.print("���� > ");
									String title = scanner.nextLine();
									System.out.print("���� > ");
									String body = scanner.nextLine();

									System.out.println("���������� ���ε� �Ǿ����ϴ�.");
									Article article = new Article(title, body);
									articles.add(article);
									break;
								case 3:
									System.out.println("������ �Խñ��� ��ȣ�� �Է����ּ���.");
									System.out.print("��ȣ�Է� > ");
									int foundId = Integer.parseInt(scanner.nextLine());
									Article foundArticle = null;

									for (Article article1 : articles) {
										if (article1.id == foundId) {
											foundArticle = article1;
										}
									}
									if (foundArticle == null) {
										System.out.println("�˻��� �Խñ��� �������� �ʽ��ϴ�.");
										continue;
									}

									System.out.print("���� > ");
									title = scanner.nextLine();
									System.out.print("���� > ");
									body = scanner.nextLine();

									foundArticle.setTitle(title);
									foundArticle.setBody(body);

									System.out.println("���������� ���� �Ǿ����ϴ�.");
									break;
								case 4:
									System.out.println("������ �Խñ��� ��ȣ�� �Է����ּ���.");
									System.out.print("��ȣ �Է� > ");
									foundId = Integer.parseInt(scanner.nextLine());

									foundArticle = null;

									for (Article article1 : articles) {
										if (article1.id == foundId) {
											foundArticle = article1;
										}
									}
									if (foundArticle == null) {
										System.out.println("�˻��� �Խñ��� �������� �ʽ��ϴ�.");
										continue;
									}
									articles.remove(foundArticle);
									System.out.println("���������� �����Ǿ����ϴ�.");
									break;
								default:
									System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
									break;
								}
							case 2:
								System.out.println("Ȩ���� �̵��մϴ�.");
								serviceRun = false;
								break;
							default:
								System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
								break;
							}
						}
						break;
					case 5:
						loginedCustomer = null;
						System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
						mainRun = false;
						break;
					default:
						System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						break;
					}
				}
				break;
			case 3:
				foundCustomer = null;
				System.out.println("ȸ�� ������ �Է����ּ���.");
				System.out.print("�̸� > ");
				String name = scanner.nextLine();

				for (Customer customer1 : customers) {
					if (customer1.getName().equals(name)) {
						foundCustomer = customer1;
					}
				}
				if (foundCustomer == null) {
					System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
					continue;
				}
				System.out.println("ȸ�����Խ� �Է��� ������ �Է����ּ���.");
				System.out.print("��Ʈ �Է� > ");
				String hint = scanner.nextLine();

				if (foundCustomer.getHint().equals(hint)) {
					System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
					System.out.println("���̵� > " + foundCustomer.getCustomerId());
					System.out.println("��й�ȣ > " + foundCustomer.getCustomerPw());
				}
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
					System.out.println("���۱� QnA �Դϴ�. ������ ���� ��ȣ�� �Է����ּ���.");
					boolean qnaRun = true;
					while (qnaRun) {
						System.out.print("��ȣ �Է� > ");
						int qnaNum = Integer.parseInt(scanner.nextLine());

					}
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
}

class Article {
	static int index;
	String title;
	String body;
	int id;

	public Article(String title, String body) {
		index++;
		this.title = title;
		this.body = body;
		this.id = index;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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