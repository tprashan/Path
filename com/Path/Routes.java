import java.util.*;

class Routes{
	public static Queue<String> queue = new LinkedList<String>();

	public static String giveKeyFromMapValue(String fileName,String src){
    	Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
		String dummyString="dummy@String";
		for (String keyCity : db.keySet()) {
			if(db.get(keyCity).contains(src))
				return keyCity;
		}
		return dummyString;
	}

	public static Boolean isDirectRoutes(String fileName,String src,String des){
    	Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
		String key = giveKeyFromMapValue(fileName,src); 
 		if((db.get(src)!=null && db.get(src).contains(des)) || key.equals(des)){
 			queue.add(src);queue.add(des);
			return true;
 		}
		return false;
	}
}