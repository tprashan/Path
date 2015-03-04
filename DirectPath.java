import java.util.*;

class Database{
	public static Map<String,List<String>> createDataBase(){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("Bangalore", new ArrayList<String>(Arrays.asList("Singapore")));
		map.put("Singapore", new ArrayList<String>(Arrays.asList("Seoul", "Bangalore","Dubai")));
		map.put("Seoul", new ArrayList<String>(Arrays.asList("Beijing", "Singapore")));
		map.put("Beijing", new ArrayList<String>(Arrays.asList("Tokyo", "Seoul")));
		map.put("Tokyo", new ArrayList<String>(Arrays.asList("Beijing")));
		map.put("Dubai", new ArrayList<String>(Arrays.asList("Lucknow")));
		map.put("Delhi", new ArrayList<String>(Arrays.asList("Kanpur")));
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
	public static Map<String,List<String>> db =  Database.createDataBase();

	public static Boolean findDirectPath(String src,String des){
		for(String city: db.keySet()) {
			if(city.equals(src) && db.get(city).contains(des)){
				queue.add(src);queue.add(des);
				return true;
			}
		}
		return false;
	}

	public static Boolean findDestination(String src,String des){
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
		return false;
	}

	public static Boolean findPath(String src,String des){
		if(src.equals(des)) return true;
		queue.add(src);
		if((db.keySet().contains(src)))
			return findDestination(src,des);
		return false;
	}
}