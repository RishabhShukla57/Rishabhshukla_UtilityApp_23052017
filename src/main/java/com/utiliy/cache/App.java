package com.utiliy.cache;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

	private static final String  FILENAME="";
	
	private void readFile(){
		LRUCache cache = new LRUCache();
    	try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
    		String currentLine;
    		while((currentLine = br.readLine())!=null){
    			String [] argmnt = currentLine.split(" ");
    			cache.put(Integer.valueOf(argmnt[0]), Integer.valueOf(argmnt[1]), argmnt[2]);
    		}
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void writeFile(){
		LRUCache cache = new LRUCache();
    	try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))){
    		bw.write("");
    		
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void main( String[] args ) 
    {
    	    
		
    }


	
}




