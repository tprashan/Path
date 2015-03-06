class PrintPath{
	public static String printPath(String src,String des){
		String path = "";
		for(String q : DirectPath.queue) {
			if(DirectPath.queue.element().equals(des))
				path = q.toString() + " -> " + path;
			else
		  		path+=q.toString()+" -> "; 
		}
		return path;
	}
}

public class Paths{
	public static Boolean findPaths(String src,String des)throws Exception{
	    Boolean directPath = DirectPath.findDirectPath(src,des);
			if(!SearchInDatabase.isCityPresentInDatabase(src))
			throw new Exception("No city Named : "+ src +" in database.");
		if(!SearchInDatabase.isCityPresentInDatabase(des))
			throw new Exception("No city Named : "+des +" in database.");
		if(directPath)
			throw new Exception("Full Path is: "+PrintPath.printPath(src,des));//return true;
	    Boolean fullPath = DirectPath.findPath(src,des);
	    if(fullPath)
	    	throw new Exception("Full Path is: "+PrintPath.printPath(src,des)); 
		return fullPath;
	}
}