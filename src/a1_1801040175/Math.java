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

	public static int middle(int a, int b, int c) {

		if ((a < b && b < c) || (c < b && b < a))
			return b;

		else if ((b < a && a < c) || (c < a && a < b))
			return a;

		else
			return c;
	}

	public static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

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
