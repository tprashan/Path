import java.util.*;
import java.util.Map;
import java.util.HashMap;

class Source{
	private String city;
	public Source(String city){
		this.city = city;
	}
	public String toString(){
		return city;
	}
}
class Destination{
	private String city;
	public Destination(String city){
		this.city = city;
	}
	public String toString(){
		return city;
}
	}

class PathDatabase{
	public static Map<Source, Destination> createDataBase(){
    	Map<Source, Destination> map = new HashMap<Source, Destination>();
		map.put(new Source("Bangalore"), new Destination("Singapore"));
		map.put(new Source("Singapore"), new Destination("Seoul"));
		map.put(new Source("Singapore"), new Destination("Dubai"));
		map.put(new Source("Beijing"), new Destination("Tokyo"));
		map.put(new Source("Seoul"), new Destination("Beijing"));
		return map;
	} 
}

public class DirectPath{
	public static Boolean findDirectPath(String src,String des){
		Map<Source, Destination> db = PathDatabase.createDataBase();
		for(Source city: db.keySet()) {
			if(city.toString()==src && db.get(city).toString()==des)
				return true;
		}
		return false;
	}
}