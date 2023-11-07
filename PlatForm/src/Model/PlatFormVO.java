package Model;

public class PlatFormVO {
	int no; // 일련번호
	String name; // 플랫폼 이름
	int price; // 가격

	public PlatFormVO() {
		super();
	}

	public PlatFormVO(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

