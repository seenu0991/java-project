package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Testprop {
	public static void main(String[] args) {

		test();
	}
	
	
	public static void test(){
        System.out.println(System.getProperty("label"));
        assertEquals("label_value", System.getProperty("label"));
    }
   
}
