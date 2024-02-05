package test;

public class PolymoTest4 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 10;
		
		Parent1[] pars = new Parent1[10];
		pars[0] = new Parent1();
		pars[1] = new Child1();
		pars[0].method1();  //Parent method1
		pars[1].method1();  //Child1 method1
//		pars[1].method2();  //호출 불가
	}
}
