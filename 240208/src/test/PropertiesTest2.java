package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest2 {
	public static void main(String[] args) {
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream("props.properties"));
			System.out.println(props.getProperty("driver"));
			System.out.println(props.getProperty("url"));
			System.out.println(props.getProperty("user"));
			System.out.println(props.getProperty("password"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
