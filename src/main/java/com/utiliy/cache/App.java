package com.utiliy.cache;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App 
{
	LRUCache cache = new LRUCache();
	
	
	private void readFile(String filename){
		
    	try(BufferedReader br = new BufferedReader(new FileReader(filename))){
    		String currentLine;
    		while((currentLine = br.readLine())!=null){
    			String [] argmnt = currentLine.split(" ");
    			cache.put(Integer.valueOf(argmnt[0]), Integer.valueOf(argmnt[1]), argmnt[2]);
    		}
    		
    		System.out.println("File Read");
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void writeFile(String filename){
		
    	try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
    		for(Map.Entry<Integer, Student> map:cache.map.entrySet()){
    			Student student = map.getValue();
    			bw.write(map.getKey()+" "+student.getMarks()+" "+student.getSubjectEnrolled());
    			bw.newLine();
    		}
    		System.out.println("File written");
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		ResourceBundle  resource;
		resource = ResourceBundle.getBundle("Utility");
		app.readFile(resource.getString("PathOfReadWords"));
		app.writeFile(resource.getString("PathOfInsertionWords"));
		
		
		
		
	}
	
	
}
	
	
	


