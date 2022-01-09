package sioon.marryweb.join;

import java.time.LocalDateTime;

public class CustomerVO {
	private String customerid;
	private String password;
	private String name;
	private int age;
	private String phone;
	private String mail;
	private String regno1;
	private String regno2;
	private String jnder;
	private String marry;
	private int post;
	private String address;
	private String accurateaddress;
	private String job;
	private int ntqty;
	private String hint;
	private LocalDateTime informationdate;
	
	
	
	
	public CustomerVO() {}
	
	

	
	public CustomerVO(String customerid, String password, String name, int age, String phone, String mail,
			String regno1, String regno2, String jnder, String marry, int post, String address, String accurateaddress,
			String job, int ntqty, String hint, LocalDateTime informationdate) {
		this.customerid = customerid;
		this.password = password;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.mail = mail;
		this.regno1 = regno1;
		this.regno2 = regno2;
		this.jnder = jnder;
		this.marry = marry;
		this.post = post;
		this.address = address;
		this.accurateaddress = accurateaddress;
		this.job = job;
		this.ntqty = ntqty;
		this.hint = hint;
		this.informationdate = informationdate;
	}




	public String getCustomerid() {
		return customerid;
	}




	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}




	public String getMail() {
		return mail;
	}




	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getRegno1() {
		return regno1;
	}
	public void setRegno1(String regno1) {
		this.regno1 = regno1;
	}
	public String getRegno2() {
		return regno2;
	}
	public void setRegno2(String regno2) {
		this.regno2 = regno2;
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
	public LocalDateTime getInformationdate() {
		return informationdate;
	}
	public void setInformationdate(LocalDateTime informationdate) {
		this.informationdate = informationdate;
	}




	@Override
	public String toString() {
		return "CustomerVO [customerid=" + customerid + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", phone=" + phone + ", mail=" + mail + ", regno1=" + regno1 + ", regno2=" + regno2 + ", jnder="
				+ jnder + ", marry=" + marry + ", post=" + post + ", address=" + address + ", accurateaddress="
				+ accurateaddress + ", job=" + job + ", ntqty=" + ntqty + ", hint=" + hint + ", informationdate="
				+ informationdate + "]";
	}

	
}
