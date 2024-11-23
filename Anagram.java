/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if (str1.length() != str2.length()) {
			return false;
		}
		StringBuilder newstr2 = new StringBuilder(str2);
		for (char c : str1.toCharArray()) {
			int i = newstr2.indexOf(Character.toString(c));
			if (i == -1) {
				return false;
			}
			newstr2.deleteCharAt(i);
		}
	
		return true;
	}
	   
	
	public static String preProcess(String str) {
		str = str.replaceAll("[^a-zA-Z]", "");
		str = str.toLowerCase();
		return str;
	} 
	   
	public static String randomAnagram(String str) {
		char[] chars = str.toCharArray();
		if (str == null || str.isEmpty()) {
			return "";
		}
		for (int i = 0; i<chars.length; i++){
			int j = (int) (Math.random() * chars.length);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		String NewAnag = new String(chars);

		return NewAnag;
	}
}
