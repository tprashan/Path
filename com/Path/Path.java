import java.util.*;

public class Path{
	public static void main(String[] args)throws Exception{
		int fileIndex = Arrays.asList(args).indexOf("-f");
		int countryIndex = Arrays.asList(args).indexOf("-c");
		if(fileIndex>=0){
			try{
				Boolean path = false;
				if(countryIndex>=0){
					path = SearchPath.findRoutes(args[countryIndex+1],args[fileIndex+1],args[4],args[5]);
				}
				else{
					path = SearchPath.findRoutes("Dummy@File",args[fileIndex+1],args[2],args[3]);
				}
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