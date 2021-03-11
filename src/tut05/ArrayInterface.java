package tut05;

import java.util.Map;

public interface ArrayInterface<T> {

	int count(T t);
	
	int minimum(T t);
	
	boolean isAscendingOrder(T t);
	
	int length(T t);
	
	Map<Integer, Integer> freq(T t);
}
