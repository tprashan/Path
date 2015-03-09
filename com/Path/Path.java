import java.util.*;

public class Path{
	public static void main(String[] args)throws Exception{
		int fileIndex = Arrays.asList(args).indexOf("-f");
		int countryFileIndex = Arrays.asList(args).indexOf("-c");
		int length = args.length;
		if(fileIndex>=0){
			try{
				Boolean path = false;
				if(countryFileIndex>=0)
					path = SearchPath.findRoutes(args[countryFileIndex+1],args[fileIndex+1],args[length-2],args[length-1]);
				else
					path = SearchPath.findRoutes("Dummy@File",args[fileIndex+1],args[2],args[3]);
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