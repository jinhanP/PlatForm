package Model;

public class MemberVO {
	String name; // 이름
	String phone; // 폰 번호
	String mb_id; // 아이디
	String mb_pw; // 패스워드

	public MemberVO() {
		super();

	}

	public MemberVO(String name, String phone, String mb_id, String mb_pw) {
		super();
		this.name = name;
		this.phone = phone;
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getMb_pw() {
		return mb_pw;
	}

	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}

}
