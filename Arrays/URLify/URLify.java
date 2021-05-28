/*
* Write a method to replace all spaces in a string with '%20: You may assume that the string
* has sufficient space at the end to hold the additional characters, and that you are given the "true"
* length of the string.
*/

public class URLify{
	private static int noOfSpaces = 0;	
	
	public static void main(String args[]){
		String str = "Mr John Smith      ";
		
		char[] chars = getCharacters (str);
		char[] replacedString = replaceAllSpaces(chars);
		
		for (int i=0; i <chars.length; i++){
			System.out.print(chars[i] + " ");
		}
		
		System.out.println();
		
		
		for (int i=0; i <replacedString.length; i++){
			System.out.print(replacedString[i] + " ");
		}
	}
	
	public static char[] getCharacters (String str){
		String str2 = str.trim();
		
		int n = str2.length();
		
		char[] chars = new char[n];
		
		for (int i=0; i<n; i++){
			char ch = str2.charAt(i);
			if (ch == ' '){
				noOfSpaces++;
			}
			chars[i] = ch;
		}
		
		return chars;
	}
	
	public static char[] replaceAllSpaces(char[]  chars){
		int n = chars.length + noOfSpaces * 2;
		
		char[] replacedString = new char[n];
		int j = 0;
		for (int i = 0;i < chars.length; i++){
			if (chars[i] == ' '){
				replacedString[j++] = '%';
				replacedString[j++] = '2';
				replacedString[j++] = '0';
			}else{
				replacedString[j++] = chars[i];
			}
		}
		return replacedString;
		
	}
}