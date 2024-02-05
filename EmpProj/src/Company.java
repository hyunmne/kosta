import emp.Employee;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class Company {
	Employee[] emps = new Employee[100];
	int cnt;

	void addEmployee(Employee emp) { //Employee emp = new PartTime("102","��浿",160,10000)
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
		Permanent emp1 = new Permanent("100","ȫ�浿",1000000);
		Sales emp2 = new Sales("101","��浿",800000,500000);
		PartTime emp3 = new PartTime("102","��浿",160,10000);
		com.addEmployee(emp1);
		com.addEmployee(emp2);
		com.addEmployee(emp3);
		com.allEmployeeInfo();
		System.out.println("�� �޿���:"+com.getTotalPay());
	}
}
//��°��
//���:100, �̸�:ȫ�浿, �޿�:1000000
//���:101, �̸�:��浿, �޿�:1300000
//���:102, �̸�:��浿, �޿�:1600000
//�� �޿���:3900000