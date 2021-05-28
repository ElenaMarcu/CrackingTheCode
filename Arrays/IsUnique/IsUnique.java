/*
Implement an algorithm to determine if a string has all unique characters.
*/

import java.util.*;

public class IsUnique{
	
	static void verifyString(String strToVerify){
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		
		for(int i=0;i<strToVerify.length();i++){
			char ch = strToVerify.charAt(i);
			if (ht.containsKey(ch)){
				System.out.println("The string " + strToVerify + " doesn't contain only unique characters.");
				return;
			}
			ht.put(ch, 0);
		}
		System.out.println("The string " + strToVerify + " contains only unique characters");
	}
	
	public static void main(String... args){
		String strToVerify = "Abc itzy";
		if (strToVerify == null || strToVerify.isEmpty()){
			System.out.println("Please insert a valid string");
			return;
		}
		
		verifyString(strToVerify);
	}
}