import emp.Employee;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class Company {
	Employee[] emps = new Employee[100];
	int cnt;

	void addEmployee(Employee emp) { //Employee emp = new PartTime("102","고길동",160,10000)
		emps[cnt++] = emp;
	}

	void allEmployeeInfo() {
		for(int i=0; i<cnt; i++) {
			System.out.println(emps[i].toString());
		}
	}
	int getTotalPay() {
		int tot = 0;
		for(int i=0; i<cnt; i++) {
//			if(emps[i] instanceof Permanent) {
//				tot += ((Permanent)emps[i]).getPay();
//			} else if(emps[i] instanceof Sales) {
//				tot += ((Sales)emps[i]).getPay();
//			} else if(emps[i] instanceof PartTime) {
//				tot += ((PartTime)emps[i]).getPay();
//			}
			tot += emps[i].getPay();
		}
		return tot;
	}
	public static void main(String[] args) {
		Company com = new Company();
		Permanent emp1 = new Permanent("100","홍길동",1000000);
		Sales emp2 = new Sales("101","김길동",800000,500000);
		PartTime emp3 = new PartTime("102","고길동",160,10000);
		com.addEmployee(emp1);
		com.addEmployee(emp2);
		com.addEmployee(emp3);
		com.allEmployeeInfo();
		System.out.println("총 급여액:"+com.getTotalPay());
	}
}
//출력결과
//사번:100, 이름:홍길동, 급여:1000000
//사번:101, 이름:김길동, 급여:1300000
//사번:102, 이름:고길동, 급여:1600000
//총 급여액:3900000