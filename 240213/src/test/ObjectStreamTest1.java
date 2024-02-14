package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Person implements Serializable {
	int age;
	String name;
	transient String password; // 직렬화에서 제외시킨다. 
	
	Person(String name, int age, String password){
		this.name = name;
		this.age = age;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return name+", "+age;
	}
	
	public void info() {
		
	}
}

public class ObjectStreamTest1 {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ArrayList<Person> pers = new ArrayList<>();
		
		Person p1 = new Person("hong", 20, "1q2e3");
		Person p2 = new Person("song", 30, "1q2e3");
		Person p3 = new Person("gong", 40, "5tswg6");
		
		pers.add(p1);
		pers.add(p2);
		pers.add(p3);
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("pers.per"));
//			oos.writeInt(3);
//			oos.writeObject(p1);
//			oos.writeObject(p2);
//			oos.writeObject(p3);
			oos.writeObject(pers);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos!=null) oos.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
