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
	public static Integer checkcity(String src,String des){
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
		if(keyCount==0 )
			return -1;
		if(valueCount==0)
			return 0;
		return keyCount;
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
		Integer checkCities = CheckDatabase.checkcity(src,des);		
		if(checkCities<=0){
			if(checkCities==-1)
				throw new Exception("No city Named : "+ src +" in database.");
			if(checkCities==0)
				throw new Exception("No city Named : "+des +" in database.");
		}
		return false;
	}
}