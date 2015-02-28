import java.util.*;

interface ListMapper<E>{
	public E callback(E ele);
}

public class CollectionUtils{
	
	public static<E> List<E> map(List<E> list, ListMapper fun){
		List<E> myList = new ArrayList<E>();
		for (E i: list) {
			myList.add((E)fun.callback(i));
		}
		return myList;
	}
}