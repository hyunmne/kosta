package emp;

abstract public class Employee {
	String id;
	String name;
	public Employee() {}
	public Employee(String id, String name) {
		this.id=id;
		this.name=name;
	}
	@Override
	public String toString() {
		return "���:"+id+", �̸�:"+name;
	}
	abstract public int getPay();
}