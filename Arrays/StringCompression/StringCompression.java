/*
String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

class StringCompression{
	
	public static void main(String... args){
		String uncompressed = "aabaaa";
		
		String compressed = compressString(uncompressed);
		
		System.out.println("Uncompressed string is " + uncompressed + " and the compressed one is " + compressed);
	}
	
	static String compressString(String str){
		StringBuilder compresedString = new StringBuilder();
		
		int count = 0, indexO = 0, indexC = 0;
		while (indexO < str.length()){
			char ch = str.charAt(indexO++);
			count++;
				while(indexO<str.length() && ch == str.charAt(indexO)) {
					count++;
					indexO++;
				}
			compresedString.insert(indexC++, ch);
			compresedString.insert(indexC++, count);
			count = 0;
		}
		
		System.out.println("Uncompressed string is " + str + " and the compressed one is " + compresedString.toString());
		
		if (str.length() == compresedString.length()){
			return str;
		}
		return compresedString.toString();
	}
	
}