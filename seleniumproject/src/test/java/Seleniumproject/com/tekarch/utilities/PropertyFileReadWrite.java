package Seleniumproject.com.tekarch.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileReadWrite {
public static String readDataFromPropertyFile(File path,String key){
		
		FileInputStream fi=null;
		Properties propFile=new Properties();
		try {
			fi=new FileInputStream(path);
			propFile.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=propFile.getProperty(key);
	
		return value;
		
	}
	
public static void writeDataToPropertyFile(File path,String key,String value){
		
		
		Properties propFile=new Properties();
		propFile.setProperty(key, value);
		try {
			propFile.store(new FileOutputStream(path),"updating data");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

