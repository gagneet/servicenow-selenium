package Miscellaneous;

import java.util.Random;
import java.util.stream.Collectors;

public class Randomgen {
	
	public String generateRandomNumber(int length) {
		
		String chars = "0123456789";
		String str = new Random().ints(length, 0, chars.length())
		                         .mapToObj(i -> "" + chars.charAt(i))
		                         .collect(Collectors.joining());
		return str;
		}
	
	public String generateRandomNID(int length) {
		String chars = "0123456789";
		String str = new Random().ints(length, 0, chars.length())
		                         .mapToObj(i -> "" + chars.charAt(i))
		                         .collect(Collectors.joining());
		return str;
	}
	
	public String generateRandomemailID() {
		int length=10;
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String str = new Random().ints(length, 0, chars.length())
		                         .mapToObj(i -> "" + chars.charAt(i))
		                         .collect(Collectors.joining());
		return str;
		
	}
	
	public String generateRandomPassword() {
		int length = 8;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_";
		String str = new Random().ints(length, 0, chars.length())
		                         .mapToObj(i -> "" + chars.charAt(i))
		                         .collect(Collectors.joining());
		
		return str;
	}
	
	public String generateRandomName() {
		int length = 8;
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String str = new Random().ints(length, 0, chars.length())
		                         .mapToObj(i -> "" + chars.charAt(i))
		                         .collect(Collectors.joining());
		
		return str;
	}

	
	
}
