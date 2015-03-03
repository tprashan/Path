import java.util.*;

class Database{
	public static Map<String,List<String>> createDataBase(){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("Bangalore", new ArrayList(Arrays.asList("Singapore")));
		map.put("Singapore", new ArrayList(Arrays.asList("Seoul", "Bangalore","Dubai")));
		map.put("Seoul", new ArrayList(Arrays.asList("Beijing", "Singapore")));
		map.put("Beijing", new ArrayList(Arrays.asList("Tokyo", "Seoul")));
		map.put("Tokyo", new ArrayList(Arrays.asList("Beijing")));
		map.put("Dubai", new ArrayList(Arrays.asList("Lucknow")));
		return map;
	}
}

class CheckDatabase{
	public static Boolean checkCityInDatabase(String src){
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
			if(city.equals(src) && db.get(city).contains(des)){
				queue.add(src);queue.add(des);
				return true;
			}
		}
		return false;
	}

	public static Boolean findPath(String src,String des){
		Map<String,List<String>> db =  Database.createDataBase();
		if(src.equals(des)) return true;
		queue.add(src);
		if((db.keySet().contains(src))){
			for(String city: db.get(src)) {
				if((db.keySet().contains(city)) && db.get(city).contains(des)){
					queue.add(city);queue.add(des);
					return true;
				}
			}
			for(String city: db.get(src)) {
				if(!queue.contains(city))
					return findPath(city,des);
			}
		}
		return false;
	}
}