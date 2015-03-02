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
	public static Boolean checkcity(String src){
		Map<Source, Destination> db = PathDatabase.createDataBase();
		Boolean result = false;

		for(Source city: db.keySet()) {
			if(city.toString().equals(src)) result=true;
			if(db.get(city).toString().equals(src)) result=true;
		}
		return result;
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

// class AnyPathBtwnTwoCities{
// 	public static boolean findAnyPath(String src,String des){
// 		Map<Source, Destination> db = PathDatabase.createDataBase();
		
// 	}
// }

class IsPath{
	public static Boolean findPaths(String src,String des)throws Exception{
	    Boolean directPath = DirectPath.findDirectPath(src,des);
		if(directPath) return true;	

		if(!CheckDatabase.checkcity(src))
			throw new Exception("No city Named : "+ src +" in database.");
		if(!CheckDatabase.checkcity(des))
			throw new Exception("No city Named : "+des +" in database.");
		return false;
	}
}

public class Paths{
	public static void main(String[] args)throws Exception{
		try{
			Boolean path = IsPath.findPaths(args[0],args[1]);
			System.out.println(path);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
};