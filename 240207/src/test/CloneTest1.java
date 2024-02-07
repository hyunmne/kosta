package test;

class Data implements Cloneable {
	String str;
	Data(String str){
		this.str = str;
	}
	
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
//	public Object clone() {
//		return new Data(str);
//	}
}

public class CloneTest1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Data d1 = new Data("Stiven");
		Data d2 = (Data)d1.clone();
		System.out.println(d1.str);
		System.out.println(d2.str);
		d1.str = "Micle";
		System.out.println(d1.str);
		System.out.println(d2.str);
	}
}
