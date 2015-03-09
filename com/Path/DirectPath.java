import java.util.*;


class SearchInDatabase{
	public static Boolean isCityPresentInDatabase(String src){
		Map<String,List<String>> db =  Database.createDataBase();
		for(String city: db.keySet())
			if(city.equals(src) || db.get(city).contains(src)) return true;
		return false;
	} 
}

class DirectPath{
	public static Queue<String> queue = new LinkedList<String>();
	public static Map<String,List<String>> db =  Database.createDataBase();

	public static String findKeyFromMapValue(String src){
		String dummyString="dummyString";
		for (String keyCity : db.keySet()) {
			if(db.get(keyCity).contains(src))
				return keyCity;
		}
		return dummyString;
	}

	public static Boolean findDirectPath(String src,String des){
		String key = findKeyFromMapValue(src); 
 		if((db.get(src)!=null && db.get(src).contains(des)) || key.equals(des)){
 			queue.add(src);queue.add(des);
			return true;
 		}
		return false;
	}

	public static Boolean doesPathExists(String src,String des){
		for(String city: db.get(src)) {
			if((db.keySet().contains(city)) && db.get(city).contains(des)){
				queue.add(city);queue.add(des);
				return true;
			}
		}
		for(String city: db.get(src))
			if(!queue.contains(city)) return findPath(city,des);
		return false;
	}

	public static Boolean findReversePath(String src,String des){
		String key = findKeyFromMapValue(src);
		if(key.equals(des)) { queue.add(des);return true;}

		if(db.get(key)!=null && db.get(key).contains(des)){ queue.add(key);queue.add(des);return true;}

		if(db.keySet().contains(key)){
			if(queue.size()>0 && queue.element().equals(src)){ queue.clear();queue.add(src);}
			
			if(findDirectPath(key,des) || findPath(key,des)) return true;
			return findReversePath(key,des);
		}
		return false;
	}

	public static Boolean findPath(String src,String des){
		if(src.equals(des)) return true;
		if(db.keySet().contains(src)){
			queue.add(src);
			return doesPathExists(src,des);
		}
		if(!(db.keySet().contains(src))){
			queue.add(src);
			return findReversePath(src,des);
		}
		return false;
	}
}