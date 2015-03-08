import java.util.*;

public class Path{
	public static void main(String[] args)throws Exception{
		if(args[0].equals("-f")){
			try{
				Boolean path = SearchPath.findRoutes(args[1],args[2],args[3]);
				System.out.println(path);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}else{
			try{
				Boolean path = Paths.findPaths(args[0],args[1]);
				System.out.println(path);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
};