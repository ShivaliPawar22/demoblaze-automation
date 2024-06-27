
public class VowelPresnt {

	public static void main(String[] args) {
		 
		System.out.println(StringContainsVowels("Hello"));
		System.out.println(StringContainsVowels("TV"));
	}
    
	public static boolean StringContainsVowels(String input) {
		
		return input.toLowerCase().matches(".*[aeiou].*");  //converts the input string to lowercase to ensure case insensitivity when checking for vowels , (.*) followed by any vowel ([aeiou]) followed by any sequence of characters (.*).
	}
}
