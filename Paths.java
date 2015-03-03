import java.util.*;
import java.util.Map;
import java.util.HashMap;

class Database{
	public static Map<String,List<String>> createDataBase(){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> bangalore = new ArrayList<String>();
		bangalore.add("Singapore");
		map.put("Bangalore",bangalore);

		List<String> singapore = new ArrayList<String>();
		singapore.add("Seoul");
		singapore.add("Dubai");
		singapore.add("Bangalore");
		map.put("Singapore",singapore);

		List<String> beijing = new ArrayList<String>();
		beijing.add("Seoul");
		beijing.add("Tokyo");
		map.put("Beijing",beijing);

		List<String> tokyo = new ArrayList<String>();
		tokyo.add("Beijing");
		map.put("Tokyo",tokyo);

		List<String> seoul = new ArrayList<String>();
		seoul.add("Beijing");
		seoul.add("Singapore");
		map.put("Seoul",seoul);

		List<String> dubai = new ArrayList<String>();
		dubai.add("Lucknow");
		map.put("Dubai",dubai);
		return map;
	}
}

class CheckDatabase{
	public static Boolean checkcity(String src){
		Map<String,List<String>> db =  Database.createDataBase();
		Boolean result = false;
		for(String city: db.keySet()) {
			if(city.equals(src)) result=true;
			if(db.get(city).contains(src)) result=true;
		}
		return result;
	} 
}

class DirectPath{
	public static Queue<String> queue = new LinkedList<String>();

	public static Boolean findDirectPath(String src,String des){
		Map<String,List<String>> db =  Database.createDataBase();
		for(String city: db.keySet()) {
			if(city.equals(src) && db.get(city).contains(des))
				return true;
		}
		return false;
	}

	public static Boolean findPath(String src,String des){
		Map<String,List<String>> db =  Database.createDataBase();
		if(src.equals(des))
			return true;
		queue.add(src);
		if((db.keySet().contains(src))){
			for(String city: db.get(src)) {
				if((db.keySet().contains(city)) && db.get(city).contains(des)){
					queue.add(city);queue.add(des);
					return true;
				}
			}
			for(String city: db.get(src)) {
				if(!src.equals(city))
					return findPath(city,des);
			}
		}
		return false;
	}
}

class Paths{
	public static Boolean findPaths(String src,String des)throws Exception{
	    Boolean directPath = DirectPath.findDirectPath(src,des);
		if(directPath) return true;	
		if(!CheckDatabase.checkcity(src))
			throw new Exception("No city Named : "+ src +" in database.");
		if(!CheckDatabase.checkcity(des))
			throw new Exception("No city Named : "+des +" in database.");
	    Boolean fullPath = DirectPath.findPath(src,des);
	    if(fullPath)
	    	throw new Exception("Full Path is:"+DirectPath.queue); 
		return fullPath;
	}
}