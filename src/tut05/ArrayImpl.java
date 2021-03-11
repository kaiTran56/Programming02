package tut05;

import java.util.HashMap;
import java.util.Map;

public class ArrayImpl implements ArrayInterface<ArrayObj>{

	@Override
	public int count(ArrayObj t) {
		int i = 0 ;
		for(int numb : t.getArr()) {
			if(numb < 0) {
				i++;
			}
		}
		return i;
	}

	@Override
	public int minimum(ArrayObj t) {
		int min = t.getArr()[0];
		for(int numb : t.getArr()) {
			if(min > numb) {
				min = numb;
			}
		}
		return min;
	}

	@Override
	public boolean isAscendingOrder(ArrayObj t) {
		int min = t.getArr()[0];
		for(int numb : t.getArr()) {
			if(min > numb) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int length(ArrayObj t) {
		int i = 0;
		for(int numb : t.getArr()) {
			i++;
		}
		return i;
	}

	@Override
	public Map<Integer, Integer> freq(ArrayObj t) {
		Map<Integer, Integer> numbFreq = new HashMap<Integer, Integer>();
		for(int numbTemp: t.getArr()) {
			if(numbFreq.containsKey(numbTemp)) {
				numbFreq.put(numbTemp, numbFreq.get(numbTemp)+1);
			}else {
				numbFreq.put(numbTemp, 1);
			}
		}
		return numbFreq;
	}

	

}
