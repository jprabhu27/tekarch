package com.firebase.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	public Properties loadFile(String filename) {	//loadFile method takes a filename parameter which specifies the path or
													//name of the properties file
		
		Properties properties = new Properties();		//inside loadfile() method,a a 'Properties' object named properties is created
		FileInputStream input = null;			//A 'FileInputStream' named 'input' is used to read the properties file 
												//specified by the 'filename' parameter
		
		try {
            // Load the properties file
            input = new FileInputStream(filename);
            properties.load(input);				//The properties file is loaded into the props object using the load()method
            									//of Properties.
		
		} catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        // Close the input stream
	        if (input != null) {			
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
        return properties;
	}
}
