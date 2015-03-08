class PrintRoutes{
	public static String printRoutes(String src,String des){
		String path= "";
		if(!Routes.queue.element().equals(des))
			path = String.join("->",Routes.queue);
		else{
			for(String q : Routes.queue)
			  		path+=q.toString()+" -> "; 
		}
		return path;
	}
}

class SearchPath{
	public static Boolean findRoutes(String file,String src,String des)throws Exception{
		if(!SearchInInputDb.isCityPresentInDB(file,src))
			throw new Exception("No city Named : "+ src +" in database.");
		if(!SearchInInputDb.isCityPresentInDB(file,des))
			throw new Exception("No city Named : "+des +" in database.");
		Boolean directRoute = Routes.isDirectRoutes(file,src,des);
		if(directRoute)
			throw new Exception("Full Path is: "+PrintRoutes.printRoutes(src,des));//return true;
	 //    Boolean fullPath = DirectPath.findPath(src,des);
	 //    if(fullPath)
	 //    	throw new Exception("Full Path is: "+PrintRoutes.printRoutes(src,des)); 
		// return fullPath;
		return true;
	}
}