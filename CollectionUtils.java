import java.util.*;

interface ListMapper<E,K>{
	public K callback(E ele);
}

interface ListFilter<E>{
	public Boolean filterCallback(E ele);
}

public class CollectionUtils{
	
	public static<E,K> List<K> map(List<E> list, ListMapper<E,K> method){
		List<K> myList = new ArrayList<K>();
		for (E i: list) {
			myList.add(method.callback(i));
		}
		return myList;
	}

	public static<E> List<E> filter(List<E> list, ListFilter method){	
		List<E> myList = new ArrayList<E>();
		for (E i: list) {
			if((boolean)method.filterCallback(i))
				myList.add(i);
		}
		return myList;
	} 
}