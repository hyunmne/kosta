package test;

class Member {
	int num;
	String name;
	String phone;
	String email;
	String address;
	
	Member(){} // 생성자를 하나라도 만들면 기본생성자는 자동으로 만들어지지 않기 때문에 작성해줘야 한다.
	
	Member(int num, String name) {
		this.num = num; // this.num은 인스턴스 객체를 의미한다.
		this.name = name;
	}
	
	Member(int anum, String aname, String aphone, String aemail) {
		this(anum, aname); // 생성자에서 다른 생성자 호출
		phone = aphone;
		email = aemail;
	}
	
	Member(int anum, String aname, String aphone, String aemail, String aaddress) {
		this(anum, aname, aphone, aemail);
		address = aaddress;
	}
	
	String info() {
		return "이름: " +name+", 번호: "+num;
	}
}

public class ConstuctorTest01 {
	public static void main(String[] args) {
		Member m1 = new Member();
		m1.num = 100;
		m1.name = "홍길동";

		Member m2 = new Member(101, "김길동");
		
		System.out.println(m1.info());
		System.out.println(m2.info());
	}
}
