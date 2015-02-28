import java.util.*;

interface ListMapper{
	public int increment(int ele);
}

public class CollectionUtils{
	
	public static List<Integer> map(List<Integer> list, ListMapper fun){
		List<Integer> myList = new ArrayList<Integer>();
		for (Integer i: list) {
			myList.add((int)fun.increment(i));
		}
		return myList;
	}
}