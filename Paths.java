public class Paths{
	public static Boolean findPaths(String src,String des)throws Exception{
	    Boolean directPath = DirectPath.findDirectPath(src,des);
		if(directPath)
			throw new Exception("Full Path is:"+DirectPath.queue);//return true;
		if(!SearchInDatabase.isCityPresentInDatabase(src))
			throw new Exception("No city Named : "+ src +" in database.");
		if(!SearchInDatabase.isCityPresentInDatabase(des))
			throw new Exception("No city Named : "+des +" in database.");
	    Boolean fullPath = DirectPath.findPath(src,des);
	    if(fullPath)
	    	throw new Exception("Full Path is:"+DirectPath.queue); 
		return fullPath;
	}
}