package a1_1801040175;

public class Math {

	/**
	 * determine the remainder of a integer after devision
	 * 
	 * @requires: y!=0 /\ (x=0\/|x| >= |y|)
	 * 
	 * @effects: return r. (in: r /\ (0<=|r| < y) /\ exists int: z. (x = yz +r))
	 */
	public static int remainder(int x, int y) {

		int dxy = x - y;
		if (x == 0) {
			return 0;
		} else if (x < y) {
			return -1;
		} else if (dxy >= 0 && dxy < y) {
			return dxy;
		} else {
			if (dxy >= y && y > 0) {
				return remainder(x - y, y);
			} else if (x <= y && y < 0) {
				return remainder(-x, -y);
			} else if (x > 0 && y < 0) {
				return remainder(x, -y);
			} else {
				return -remainder(-x, y);
			}
		}
	}

	/**
	 * determine the midle one of three numbers
	 * 
	 * @requires: a != null /\ b != null /\ c != null
	 * 
	 * 
	 * @effects: return the number which is in the midle of three number
	 * 
	 *           <pre>
	 *           i.e: if ((a < b && b < c) || (c < b && b < a)) return b;
	 * 
	 *           else if ((b < a && a < c) || (c < a && a < b)) return a;
	 * 
	 *           else return c;
	 * 
	 *           <pre>
	 *           e.g: middle(8,9,10) = 9
	 */
	public static int middle(int a, int b, int c) {

		if ((a < b && b < c) || (c < b && b < a))
			return b;

		else if ((b < a && a < c) || (c < a && a < b))
			return a;

		else
			return c;
	}

	/**
	 * determine the string is a palindrom or not
	 * 
	 * @param str !=null
	 * @effects: return the determine of string is palindrom or not
	 * 
	 *           <pre>
	 *           i.e:if(str.length()==1) return true; <br>
	 *           \/ check the symbol per position of str which have the same
	 *           character with the opersite characters
	 */
	public static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;

		if (str.length() == 1) {
			return true;
		}
		while (i < j) {

			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

	/**
	 * determine the integer number is prime or not
	 * 
	 * @requires: number >0
	 * @effects:
	 * 
	 *           <pre>
	 *           if(1<=number<=2) return true <br>
	 *           forall i in the range[2, number)/\ if(number % i ==0) return false
	 */

	public static boolean isPrime(int number) {
		if (number <= 2 && number >= 1) {
			return true;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPrime(12));
	}

}
