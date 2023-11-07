package Model;

public class WatchVO {
	int no; // 일련번호
	String mb_id; // 아이디
	int mNo; // Member 일련번호
	int pNo; // Platform 일련번호

	public WatchVO() {
		super();

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	@Override
	public String toString() {
		return "Watch [no=" + no + ", mb_id=" + mb_id + ", mNo=" + mNo + ", pNo=" + pNo + "]";
	}

}

