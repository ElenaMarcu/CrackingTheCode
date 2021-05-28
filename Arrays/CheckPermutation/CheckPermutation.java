/*
Given two strings, write a method to decide if one is a permutation of the
other.
*/

import java.util.*;

public class CheckPermutation{
	
	public static void main(String args[]){
		checkPermutation("apple", "papel");
		checkPermutation("carrot", "tarroc");
		checkPermutation("hello", "llloh");
	}
	
	static void checkPermutation(String str1, String str2){
		if ((str1.length() != str2.length()) || str1.equals(str2)){
			System.out.println("The strings are not permutation one of the other");
			return;
		}
		
		var ht = new Hashtable<Character, Integer>();
		
		for (int i=0; i< str1.length(); i++){
			Character ch = str1.charAt(i);
			if (ht.containsKey(ch)){
				Integer noOfAparitions = ht.get(ch);
				ht.put(ch, ++noOfAparitions);
			}
			else{
				ht.put(ch, 1);
			}
		}
		
		for (int i= 0;i<str2.length();i++){
			Character ch = str2.charAt(i);
			if (!ht.containsKey(ch)){
				System.out.println("The strings are not permutation one of the other");
				return;
			}
			Integer noOfAparitions = ht.get(ch);
			noOfAparitions--;
			if (noOfAparitions == 0){
				ht.remove(ch);
			}else{
				ht.put(ch, noOfAparitions);
			}
		}
		if(ht.size() != 0){
			System.out.println("The strings are not permutation one of the other");
		}else{
			System.out.println("The strings are permutation one of the other. Yey!");
		}
	}
	
}