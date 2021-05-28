/*
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
*/

import java.lang.Math;

public class OneAway{
	
	public static void main(String args[]){
		String[][] strsToCheck = {{"pale", "bale"}, {"pale","ple"}, {"pale", "pld"}, {"pale", "bake"}, {"pales", "pale"}};
		
		for(String[] s: strsToCheck){
			System.out.println(s[0] + " " + s[1] + " "+ checkEdits(s[0], s[1]));
		}		
	}
	
	static boolean checkEdits(String s1, String s2){
		int n1 = s1.length();
		int n2 = s2.length();
		
		// Check if there is more than one edit
		if (Math.abs(n1 - n2) > 1){
			return false;
		}
		
		boolean editMade = false;
		
		int i1 = 0, i2 = 0;
		
		while (i1 < n1 && i2 < n2){
			if ( s1.charAt(i1) != s2.charAt(i2)){
				if (editMade){ //this is the second edit
					return false;
				}
				editMade = true;
				if (n1 == n2) {
					i1++;
					i2++;
					continue;
				}
				if (n1 > n2 ){
					i1++;
					continue;
				}
				i2++;
			}else{
				i1++;
				i2++;
			}
		}
		return true;
	}
	
}