
public class ReverseString {

	public static void main(String[] args) {
		
		String str="abc";
		String reversed = reverse(str); // Reversed string will get stored in reversed variable
		System.out.println(reversed);

	}

	public static String reverse(String in) {  // in is the input string that needs to be reversed
		// TODO Auto-generated method stub
		
		StringBuilder out = new StringBuilder();  //Stringbuilder manipulates the string
		
		for ( int i= in.length() - 1; i >=0 ; i--) {  // in is 123 , appends each character of in 
			out.append(in.charAt(i));  //append the string representation of the boolean argument to a given sequence.
		}
		
		return out.toString(); //converts out to a regular string using out.toString() and returns the reversed string.

}
}