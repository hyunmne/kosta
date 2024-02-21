package dto;

public class Player {
	private int num;
	private String name;
	private int backnum;
	private int tnum;
	private String tname;
	
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBacknum() {
		return backnum;
	}
	public void setBacknum(int backnum) {
		this.backnum = backnum;
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public Player(int num, String name, int backnum, int tnum, String tname) {
		super();
		this.num = num;
		this.name = name;
		this.backnum = backnum;
		this.tnum = tnum;
		this.tname=tname;
	}
	public Player(String name, int backnum, int tnum) {
		super();
		this.name = name;
		this.backnum = backnum;
		this.tnum = tnum;
	}
	
	@Override
	public String toString() {
		return String.format("번호 : %d, 이름 : %s, 등번호 : %d, 소속팀 번호 : %d, 소속팀명 : %s", 
							num, name, backnum, tnum, tname);
	}
	
}
