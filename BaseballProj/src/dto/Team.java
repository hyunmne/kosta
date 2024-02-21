package dto;

public class Team {
	private int num;
	private String name;
	private String loc;
	
	public Team() {}
	public Team(int num, String name, String loc) {
		super();
		this.num = num;
		this.name = name;
		this.loc = loc;
	}
	public Team(String name, String loc) {
		super();
		this.name = name;
		this.loc = loc;
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
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	@Override
	public String toString() {
		return String.format("팀 번호 : %d, 팀명 : %s, 연고지 : %s", num,name,loc);
	}

	
}
