import java.util.*;

interface ListMapper<E>{
	public E callback(E ele);
}

interface ListFilter<E>{
	public Boolean filterCallback(E ele);
}

public class CollectionUtils{
	
	public static<E> List<E> map(List<E> list, ListMapper method){
		List<E> myList = new ArrayList<E>();
		for (E i: list) {
			myList.add((E)method.callback(i));
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