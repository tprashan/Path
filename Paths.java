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

class CheckDatabase{
	public static Boolean checkcity(String src,String des){
		Map<Source, Destination> db = PathDatabase.createDataBase();
		int keyCount = 0, valueCount=0;
		for(Source city: db.keySet()) {
			if(city.toString().equals(src))
				keyCount++;
			if(city.toString().equals(des))
				valueCount++;
		}
		for(Destination city: db.values()) {
			if(city.toString().equals(src))
				keyCount++;
			if(city.toString().equals(des))
				valueCount++;
		}
		if(keyCount==0 || valueCount==0){
			return true;
		}
		return false;
	} 
}

class DirectPath{
	public static Boolean findDirectPath(String src,String des)throws Exception{
		Map<Source, Destination> db = PathDatabase.createDataBase();
		for(Source city: db.keySet()) {
			if(city.toString().equals(src) && db.get(city).toString().equals(des))
				return true;
		}
		return false;
	}
}

class IsPath{
	public static Boolean findPaths(String src,String des)throws Exception{
	    Boolean directPath = DirectPath.findDirectPath(src,des);
		if(directPath) return true;
		Map<Source, Destination> db = PathDatabase.createDataBase();
		Boolean checkCities = CheckDatabase.checkcity(src,des);		
		if(checkCities){
			throw new Exception("No city Named : "+ src + " or "+des +" in database.");
		}
		return false;
	}
}

public class Paths{
	public static void main(String[] args)throws Exception{
		String src = args[0];
		String des = args[1];
		try{
			Boolean path = IsPath.findPaths(src,des);
			System.out.println(path);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
};