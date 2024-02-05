package test;

interface IClick {
	void click();
}

class MyButton {
	IClick iclick; // 멤버변수
	void onClick() {
		System.out.println("Button Push!");
		if (iclick!=null) {
			iclick.click();
		}
	}
	void addClickList(IClick iclick) {
		this.iclick = iclick; // 외부 매칭.. null이 아님
	}
}

//class LoginClick implements IClick {
//	@Override
//	public void click() {
//		System.out.println("Login Success!");
//	}
//}

public class InterfaceTest02 {
	public static void main(String[] args) {
		MyButton mb = new MyButton();
//		mb.addClickList(new LoginClick());
		mb.addClickList(new IClick() { 	// 익명 클래스 
			@Override
			public void click() {
				System.out.println("Login ...");
			}
		});
		mb.onClick();
	}
}
