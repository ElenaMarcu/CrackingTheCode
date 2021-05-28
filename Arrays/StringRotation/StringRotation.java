/*
String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
*/

public class StringRotation{
	
	public static void main (String[] args){
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		String doubles2 = s2 + s2;
		
		System.out.println(doubles2.indexOf(s1));
	}
	
}