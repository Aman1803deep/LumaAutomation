package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDataGenerator {


		 // Character sets for generating random data
	    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	    private static final String DIGITS = "0123456789";
	    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+";

	    
	    public static String generateRandomFirstName() {
	        return generateRandomName(UPPERCASE + LOWERCASE, 1, 1);
	    }
	    
	    public static String generateRandomLastName() {
	        return generateRandomName(UPPERCASE + LOWERCASE, 1, 1);
	    }
	    
	    public static String generateRandomEmail() {
	        String username = generateRandomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", 5, 10);
	        String domain = generateRandomString("abcdefghijklmnopqrstuvwxyz", 5, 8);
	        String extension = generateRandomString("abcdefghijklmnopqrstuvwxyz", 2, 3);
	        return username + "@" + domain + "." + extension;
	    }
	    
	    public static String generateRandomPassword() {
	        String password = generateRandomString(UPPERCASE, 1, 1) +
	                          generateRandomString(LOWERCASE, 1, 1) +
	                          generateRandomString(DIGITS, 1, 1) +
	                          generateRandomString(SPECIAL_CHARS, 1, 1);

	        // Append 8-12 random characters from all sets (uppercase, lowercase, digits, special characters)
	        password += generateRandomString(UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARS, 8, 12);
	        return shuffleString(password);
	    }
	    
	    private static String generateRandomString(String charSet, int minLength, int maxLength) {
	        int length = ThreadLocalRandom.current().nextInt(minLength, maxLength + 1);
	        StringBuilder stringBuilder = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int randomIndex = ThreadLocalRandom.current().nextInt(charSet.length());
	            stringBuilder.append(charSet.charAt(randomIndex));
	        }

	        return stringBuilder.toString();
	    }
	    
	    
	    private static String generateRandomName(String charSet, int upperCaseCount, int lowerCaseCount) {
	        String name = generateRandomString(UPPERCASE, upperCaseCount, upperCaseCount) +
	                      generateRandomString(LOWERCASE, lowerCaseCount, lowerCaseCount);

	        // Append 8-12 random characters from the allowed set (uppercase + lowercase)
	        name += generateRandomString(charSet, 8, 12);
	        return shuffleString(name);
	    }
	    
	    private static String shuffleString(String input) {
	        StringBuilder shuffled = new StringBuilder(input);

	        // Shuffle the string by randomly swapping characters
	        for (int i = 0; i < shuffled.length(); i++) {
	            int j = ThreadLocalRandom.current().nextInt(shuffled.length());
	            char temp = shuffled.charAt(i);
	            shuffled.setCharAt(i, shuffled.charAt(j));
	            shuffled.setCharAt(j, temp);
	        }

	        return shuffled.toString();
	    }
	}


