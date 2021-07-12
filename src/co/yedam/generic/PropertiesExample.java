package co.yedam.generic;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) {
		// 상대경로를읽어오기 위해
		String path = PropertiesExample.class.getResource("../../db.properties").getPath();
		Properties prop = new Properties(); // 생성자 호출
		try {
			prop.load(new FileReader(path));
			String id = prop.getProperty("id");
			String name = prop.getProperty("name");
			String pass = prop.getProperty("password");
			
			System.out.println(id + " / " + name + " / " + pass ); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
