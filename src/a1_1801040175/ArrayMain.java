package a1_1801040175;

import java.util.HashMap;
import java.util.Map;

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
	 * @effects: return the number which is median
	 * 
	 *           <pre>
	 *           i.e: return numb wher <br>
	 *           arr[x in arr | x[i] < x[i+1]]/\ n = arr.length /\ n % 2 != 0 ->
	 *           numb = arr[(n+1)/2-1] \/ n%2 == 0 -> numb = (arr[n/2] + arr[n/2 -
	 *           1])/2
	 * 
	 *           <pre>
	 *           e.g: length([1,2,3,4]) = 2.5
	 */
	public double median(double[] arr) {
		return 0.0;
	}

	/**
	 * Detemine the relationship between 2 arbitrary arrays
	 * 
	 * @requires: arr1 != null /\ arr2 != null /\ arr1 != arr2
	 * @effects: the relationship of 2 arbitrary array
	 * 
	 *           <pre>
	 *           i.e: arr1 is subset of arr2 -> arr1.length < arr2.length /\ x[i] in
	 *           arr2 /\ x[i] not in arr1 \/ arr1 intersect with arr2 -> [x in arr1
	 *           /\ x in arr2].length < arr1.length /\ x[i] in arr2 /\ x[i] not in
	 *           arr1
	 * 
	 *           <pre>
	 *           e.g: compare([1,2,3.5], [1,2,3])=intersect
	 * 
	 */

	public void compare(double[] arr1, double[] arr2) {

	}

	/**
	 * Compute the frequencies of each elements of real array
	 * 
	 * @requires: arr != null /\ numb != null
	 * @modifies: numb
	 * @effects: return the array which is used to store the frequencies of each
	 *           element in array
	 * 
	 *           <pre>
	 *           i.e: return numb where<br>
	 *           for all 0 <= i <= arr.length-1 /\ numb.containKeys(arr[i])->
	 *           numb.put(arr[i], numb.get(arr[i])+1) \/ numb.put(arr[i], 1)
	 * 
	 *           <pre>
	 *           e.g: freq([1,1,2,3.3]) = [2,2,1,1]
	 * 
	 */
	public Map<Double, Integer> freq(double[] arr) {
		Map<Double, Integer> numb = new HashMap<Double, Integer>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (numb.containsKey(arr[i])) {
				numb.put(arr[i], numb.get(arr[i]) + 1);
			} else {
				numb.put(arr[i], 1);
			}
		}
		return numb;
	}

	public static void main(String[] args) {
		double[] arr = { 1, 2, 1, 2, 3 };
		new ArrayMain().freq(arr).forEach((k, v) -> System.out.println(k + " : " + v));
	}
}
