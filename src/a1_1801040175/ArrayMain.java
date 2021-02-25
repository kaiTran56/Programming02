package a1_1801040175;

public class ArrayMain {

	/**
	 * Determine the number of elements of elements of an array of Integer that are
	 * negative
	 * 
	 * @requires: arrray "a" not eq null<br>
	 *            a not eq 0
	 * @effects:
	 * 
	 *           <pre>
	 *           return number of elements of a that are negative. *
	 * 
	 *           <pre>
	 *           i.e: result = [x| x in a /\ x < 0 ].length
	 * 
	 *           i.g: countNegatives([-1, -2, 0, 3])=2
	 */

	public int countNegatives(int[] a) {
		return 0;
	}

	/**
	 * 
	 * Detemine the number of elements of a that are even
	 * 
	 * @requires: array "arr" not eq null, a not eq 0
	 * 
	 * @effects: return number of elements of arr that are even
	 * 
	 *           <pre>
	 *           i.e: result = [x|x in arr /\ x % 2 ==0].length
	 * 
	 *           <pre>
	 *           e.g: countEvens([1,2,3,4])=2
	 */

	public int countEven(int[] arr) {
		return 0;
	}

	/**
	 * Divide the elements of real number array by a real number
	 * 
	 * @requires: arr neq null /\ d != 0
	 * @modifies: arr
	 * @effects: divide each elements of arr by d
	 * 
	 *           <pre>
	 *           i.e: arr_post =[x| x = y/d, y in arr]
	 * 
	 *           <pre>
	 *           e.g: divArray([1,2,3], 2)=[0.4, 1, 1.5]
	 */
	public void divArray(double[] arr, int d) {

	}

	/**
	 * Find the minimum number in array
	 * 
	 * @requires: arr neq null /\ arr neq 0
	 * 
	 * @return: return the minimum number in array
	 * 
	 *          <pre>
	 *          i.e: result = numb wher numb = xk, <br>
	 *          xi int arr /\ for all 1 <= i <= arr.length-1 /\ for all i+1 <= k <=
	 *          arr.length /\ xk < xi -> xk
	 * 
	 *          <pre>
	 *          e.g: min([1,2,3,0,4]) = 0
	 */
	public int min(int[] arr) {
		return 0;
	}

	/**
	 * Detemine whether an array of integer is in ascending order
	 * 
	 * @requires: arr != null /\ arr != 0
	 * 
	 * @effect: check the ascending integer array or not
	 * 
	 *          <pre>
	 *          i.e: result = [x in arr /\ a[i] < x[i+1]]
	 * 
	 *          <pre>
	 *          e.g: isAscOrder([1,2,3,1,3]) = false
	 */

	public boolean isAscSorted(int[] arr) {
		return false;
	}

	/**
	 * find the number of character which is before NUL character in an array
	 * 
	 * @requires: arr eq /\ arr neq null
	 * 
	 * @effects: return the number of character which is before the null character
	 *           in a char array
	 * 
	 *           <pre>
	 *           i.e: result = [x in arr /\ x != null].length
	 * 
	 *           <pre>
	 *           e.g: length([a,s, ,b]) = 2
	 */
	public int length(char[] arr) {
		return 0;
	}

	/**
	 * Find the median number in an real array
	 * 
	 * @requires: arr neq /\ arr sorted
	 * @return
	 */
	public double median(double[] arr) {
		return 0.0;
	}

	public static void main(String[] args) {

	}
}
