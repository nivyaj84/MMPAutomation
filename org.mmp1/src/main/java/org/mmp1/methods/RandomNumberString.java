package org.mmp1.methods;

import java.util.Random;

public class RandomNumberString {

	/* Method that returns a random string of a specified length */
	public static String getRandomString(int length,int case_choice) {
		int i = 0;
		String randomString = "";
		Random rdn = new Random();
		int a;
		switch(case_choice){
		case 1: //Generates uppercase and lowercase string
		a = 65 + rdn.nextInt(26); /* First letter Uppercase */
		randomString = randomString + (char) (a);
		while (i < (length - 1)) {
			a = 97 + rdn.nextInt(26); /* Random Lowercase Letter */
			randomString = randomString + (char) (a);
			i++;
		}
		break;
		case 2: //Generates only lowercase string
			while (i < (length)) {
				a = 97 + rdn.nextInt(26); /* Random Lowercase Letter */
				randomString = randomString + (char) (a);
				i++;
			}
			break;
		case 3: //Generates only Uppercase string
			while (i < (length)) {
				a = 65 + rdn.nextInt(26); /* Random Uppercase Letter */
				randomString = randomString + (char) (a);
				i++;
			}
			break;
		default:
			a = 65 + rdn.nextInt(26); /* One Uppercase letter */
			randomString = randomString + (char) (a);
			break;
		}
		return randomString;
	}

	/* Method that returns a value within a range*/
	public static int getRandonNum(int upperLimit) {
		Random rdn = new Random();
		int randomNumber = 1 + rdn.nextInt(upperLimit - 1);
		return randomNumber;
	}

	/* Method that returns a random number based on the number of digits */
	public static int getRandonNumber(int numberOfDigits) {
		Random rdn = new Random();
		int randomNumber = 0;
		switch (numberOfDigits) {
		case 1:
			randomNumber = rdn.nextInt(9); // Random 1 digit number
			break;
		case 2:
			randomNumber = 10 + rdn.nextInt(99); // Random 2 digit number
			break;
		case 3:
			randomNumber = 100 + rdn.nextInt(99);// Random 3 digit number
			break;
		case 4:
			randomNumber = 1000 + rdn.nextInt(999);// Random 4 digit number
			break;
		case 5:
			randomNumber = 10000 + rdn.nextInt(9999);// Random 5 digit number
			break;
		case 6:
			randomNumber = 100000 + rdn.nextInt(99999);// Random 6 digit number
			break;
		case 7:
			randomNumber = 1000000 + rdn.nextInt(999999);// Random 7 digit
															// number
			break;
		case 8:
			randomNumber = 10000000 + rdn.nextInt(9999999);// Random 8 digit
															// number
			break;
		case 9:
			randomNumber = 100000000 + rdn.nextInt(99999999);// Random 9 digit
																// number
			break;
		default: randomNumber=10;	
		}
		return randomNumber;
	}

	/* Method that returns a string of special characters */
	public static String getSpecialChars(int length) {
		int a;
		String randomSpecial = null;
		Random rdn2 = new Random();
		for (int i = 0; i < length; i++) {
			a = 33 + rdn2.nextInt(14);
			randomSpecial = randomSpecial + (char) (a);
		}
		return (randomSpecial);
	}
}
