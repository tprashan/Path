import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;



class Adder implements ListMapper{
	public int increment(int ele){
		return ele + 2;
	}
}

public class VersionTest{

	@Test
	public void add_2_in_each_element_of_mapList(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=5;i++){
			list.add(i);
		}

		ListMapper l = new Adder();		
		List<Integer> newlist = CollectionUtils.map(list,l);
		int newElement = newlist.get(0);
		int newElement1 = newlist.get(4);
		assertEquals(newElement,3);
		assertEquals(newElement1,7);
	}
}