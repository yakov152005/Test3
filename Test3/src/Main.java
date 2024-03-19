public class Main {
	public static void main(String[] args) {
		Ex1();
		Ex2();
		Ex3A();
		Ex3B();
		Ex3C();
		Ex3D();
		EX4();
		Ex5();
		Ex6A();
		Ex6B();
	}

	public static void Ex1() {
		int[] data = {7, 7, 58, 58, 13, 13, 22, 22, 56, 56};
		if (checkFollowNumber(data)) {
			System.out.println("The couple is diff");
		} else {
			System.out.println("The couple is NOT diff");

		}
	}

	public static boolean checkFollowNumber(int[] data) {
		boolean res = false;
		int dif1 = data[1] - data[0];
		for (int i = 2; i < data.length; i++) {
			for (int j = 3; j < data.length; j += 2) {
				if ((data[j] - data[i] == dif1)) {
					res = true;
				} else {
					res = false;
					break;
				}
				i += 2;
			}
			if (i == 8) {
				break;
			}
		}
		return res;
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex2() {
		int[] data = {4, 3, 7, 12, 13, 13, 12, 7, 3, 4};
		if (isSymmetrical(data)) {
			System.out.println("Its symmetrical.");
		} else {
			System.out.println("Its not symmetrical");
		}
	}

	public static boolean isSymmetrical(int[] data) {
		boolean res = true;
		if (data.length % 2 != 0) {
			res = false;
		} else {
			for (int i = 0; i < data.length; i++) {
				for (int j = data.length - 1; j > 0; j--) {
					if (data[i] != data[j]) {
						res = false;
						break;
					}
					i++;
					if (i > j) {
						res = true;
						break;
					}
				}

			}
		}
		return res;
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex3A() {
		String str = "ABCBA";
		String resversString = reversStr(str);
		if (resversString.equals(str)) {
			System.out.println("This string is palindrome.");
		} else {
			System.out.println("NOT palindrome");
		}
	}

	public static String reversStr(String str) {
		String reversString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reversString += str.charAt(i);
		}
		return reversString;
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex3B() {
		String[] strArr = {"ABA", "lol", "MoM", "yakov"};
		int countPalindrome = howManyPalindromeInTheStrArr(strArr);
		System.out.println("The string Arr have: " + countPalindrome + " palindrome strings");
	}

	public static int howManyPalindromeInTheStrArr(String[] strArr) {
		int countPalindrome = 0;
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			String reversStr = reversStr(temp);
			if (temp.equals(reversStr)) {
				countPalindrome++;
			}

		}
		return countPalindrome;
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex3C() {
		String[] strArr1 = {"ABA", "lol", "MoM", "yakov"};
		String[] strArr2 = {"racecar", "WoW", "pop", "NoN"};
		String[] strArr3 = {"xoox", "wave", "ball"};
		int countPalindrome1 = howManyPalindromeInTheStrArr(strArr1);
		int countPalindrome2 = howManyPalindromeInTheStrArr(strArr2);
		int countPalindrome3 = howManyPalindromeInTheStrArr(strArr3);
		if (countPalindrome1 > countPalindrome2 && countPalindrome1 > countPalindrome3) {
			printStrArr(strArr1);
		} else if (countPalindrome2 > countPalindrome1 && countPalindrome2 > countPalindrome3) {
			printStrArr(strArr2);
		} else {
			printStrArr(strArr3);
		}
	}

	public static void printStrArr(String[] strArr) {
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + ",");
		}
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex3D() {
		String[] strArr = {"lol", "xoox", "racecar", "ABA"};
		String longestPalindrome = theLongestPalindromeInTheStrArr(strArr);
		System.out.println("The longest palindrome is: " + longestPalindrome);
	}

	public static String theLongestPalindromeInTheStrArr(String[] strArr) {
		String longestPalindrome = " ";
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			String reversStr = reversStr(temp);
			if (temp.equals(reversStr) && reversStr.length() > longestPalindrome.length()) {
				longestPalindrome = reversStr;
			}
			temp = null;
			reversStr = null;
		}
		return longestPalindrome;
	}

	//---------------------------------------------------------------------------------------------------
	public static void EX4() {
		int[] arr = {33524, 5478, 6542, 1201, 236547, 22222221};
		int result = digitRepeatsMostInTheArray(arr);
		System.out.println(result);
	}

	public static int digitRepeatsMostInTheArray(int[] arr) {
		String res = "";
		String number = "0123456789";
		int digitMostAppear = 0;
		int count = 0;
		int currentCount = 0;
		for (int i = 0; i < arr.length; i++) {
			String str = String.valueOf(arr[i]);
			res += str;
		}
		for (int i = 0; i < number.length(); i++) {
			for (int j = 0; j < res.length(); j++) {
				if (number.charAt(i) == res.charAt(j)) {
					count++;
				}
			}
			if (count > currentCount) {
				currentCount = count;
				digitMostAppear = i;

			}
			count = 0;
		}
		return digitMostAppear;
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex5() {
		String[] strArr = {"abcabcabc", "abcasdasdabc", "abcabcabcabcasd", "fhshj", "abcdfgabc"};
		String str = "abc";
		String result = stringAppearsManyTimesInTimesStrArr(strArr, str);
		System.out.println(result);
	}

	public static String stringAppearsManyTimesInTimesStrArr(String[] strArr, String str) {
		int countStr = 0;
		int currentCount = 0;
		String res = "";
		String temp = "";
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].contains(str)) {
				temp = strArr[i];
				strArr[i] = strArr[i].replace(str, "1");
				for (int j = 0; j < strArr[i].length(); j++) {
					if (strArr[i].charAt(j) == '1') {
						countStr++;
					}
				}
			}
			if (countStr > currentCount) {
				currentCount = countStr;
				res = temp;
			}
			countStr = 0;
		}
		return res;
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex6A() {
		int num1 = 32; //3+2=6
		int num2 = 46; //4+6 = 10
		int sum = numberWithTheHighestSumOfDigits(num1, num2);
		System.out.println(sum);
	}

	public static int numberWithTheHighestSumOfDigits(int num1, int num2) {
		int highestSum = 0;
		int sum1 = numberSumOfDigits(num1);
		int sum2 = numberSumOfDigits(num2);
		if (sum1 > sum2) {
			highestSum = num1;
		} else {
			highestSum = num2;
		}
		return highestSum;
	}

	public static int numberSumOfDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	//---------------------------------------------------------------------------------------------------
	public static void Ex6B() {
		int[] arr = {28, 12, 22, 43, 35, 55, 64};//10,3,4,7,8,10,10
		int extraNumber = 37;//10
		int[] result = digitSumIsTheSameAsTheExtraNumber(arr, extraNumber);
		for (int j : result) {
			System.out.print(j + " ");
		}
	}
	public static int[] digitSumIsTheSameAsTheExtraNumber(int[] arr, int extraNumber) {
		int counterForNewArr = 0;
		int sumExtraNumber = numberSumOfDigits(extraNumber);
		for (int i = 0; i < arr.length; i++) {
			int sumOfArrOnTheIndexI = numberSumOfDigits(arr[i]);
			if (sumExtraNumber == sumOfArrOnTheIndexI) {
				counterForNewArr++;
			}
		}
		int[] newArrWithSameSum = new int[counterForNewArr];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			int sumOfArrOnTheIndexI = numberSumOfDigits(arr[i]);
			if (sumExtraNumber == sumOfArrOnTheIndexI) {
				newArrWithSameSum[index] = arr[i];
				index++;
			}
		}
		return newArrWithSameSum;
	}
}
