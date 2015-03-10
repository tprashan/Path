import java.lang.Boolean;
import java.util.*;

class PrintRoutes{
    public static String printRoutes(String cfile,String src,String des){
        String path = "";
        if(!("Dummy@File".equals(cfile))){
            Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(cfile);
            for(String q : Routes.queue)
                path+=q.toString()+db.get(q)+"->";
        }
        else
            path= String.join("->",Routes.queue);
        return path;
    }
}

class SearchPath{

    public static Boolean findSingleRoute(String cfile,String file,String src,String des,String option)throws Exception{
        Boolean directRoute = Routes.isDirectRoutes(file,src,des);
        if(directRoute){
            throw new Exception("Full Path is: "+PrintRoutes.printRoutes(cfile,src,des)+"\nTotal Cost: "+
                    TotalCost.findCost(file));}
        Boolean wholeRoute = Routes.isRoute(file,src,des);
        if(wholeRoute){
            throw new Exception("Full Path is: "+PrintRoutes.printRoutes(cfile,src,des)+"\nTotal Cost: "+
                    TotalCost.findCost(file));}
        return wholeRoute;
    }

    public static Boolean findAllRoutes(String cfile,String file,String src,String des,String option)throws Exception{
        Boolean directRoute = AllRoutes.isDirectRoutes(file,src,des);
        if(directRoute){
            throw new Exception("Full Path is: "+PrintRoutes.printRoutes(cfile,src,des)+"\nTotal Cost: "+
                    TotalCost.findCost(file));}
        Boolean wholeRoute = AllRoutes.isRoute(file,src,des);
        if(wholeRoute){
            throw new Exception("Full Path is: "+PrintRoutes.printRoutes(cfile,src,des)+"\nTotal Cost: "+
                    TotalCost.findCost(file));}
        return wholeRoute;
    }

    public static Boolean findRoutes(String cfile,String file,String src,String des,String option)throws Exception{
        if(!SearchInInputDb.isCityPresentInDB(file,src))
            throw new Exception("No city Named : "+ src +" in database.");
        if(!SearchInInputDb.isCityPresentInDB(file,des))
            throw new Exception("No city Named : "+des +" in database.");
        if(option.equals("-a")){
            return findAllRoutes(cfile,file,src,des,option);
        }
        else{
            return findSingleRoute(cfile, file,src,des,option);
        }
    }
}