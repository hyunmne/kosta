package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectStreamTest2 {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("pers.per"));
//			int size = ois.readInt();
//			for (int i=0; i<size; i++) {
//				Person p1 = (Person) ois.readObject();
//				System.out.println(p1);
//			}
			ArrayList<Person> pers = (ArrayList<Person>) ois.readObject();
			for (Person p : pers) {
				System.out.println(p);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			try {
				if (ois!=null) ois.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
