package com.example.demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

class addWords {// this is the file write class 
	 
	public void WritePropertiesFile(String key, String data) {
	        FileOutputStream fileOut = null;
	        FileInputStream fileIn = null;
	        try {
	            Properties configProperty = new Properties();
	            File file = new File("C:\\Users\\alexk\\Documents\\workspace-sts-3.9.11.RELEASE\\project-I18N\\src\\main\\resources\\messages_se.properties");
	            // change this when using on a server^^
	            fileIn = new FileInputStream(file);
	            configProperty.load(fileIn);
	            configProperty.setProperty(key, data);
	            fileOut = new FileOutputStream(file);
	            configProperty.store(fileOut, "translation");

	        } catch (Exception ex) {
	            Logger.getLogger(addWords.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {

	            try {
	                fileOut.close();
	            } catch (IOException ex) {
	                Logger.getLogger(addWords.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
}
