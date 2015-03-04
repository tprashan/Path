// import java.io.*;
// import java.util.*;

// public class ReadFile{
// 	public static String read(String fileName){
// 		JSONParser parser = new JSONParser();
// 	    try{
//  			JSONObject obj = (JSONObject) parser.parse(new FileReader(fileName));
//  			// JSONObject jsonObject = (JSONObject) obj;
// 		   // FileInputStream fin = new FileInputStream(fileName);
// 		   // ObjectInputStream ois = new ObjectInputStream(fin);
// 		   // database = (Database) ois.readObject();
// 		   // ois.close();
// 		   return jsonObject;
 
// 	    }catch(Exception ex){
// 		   ex.printStackTrace();
// 		   return null;
// 	    } 
// 	}
// }




// // public class ReadFile{
// // 	public static String read(String fileName){
// // 		File file = new File(fileName);
// // 		int len = (int)file.length();
// // 		char ch[] = new char[len];
// // 		try{
// // 			FileInputStream fstream = new FileInputStream(fileName);
// // 			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
// // 			br.read(ch,0,len);
// // 		}catch(IOException e){
// // 			System.out.println("error is>>"+e);
// // 		}
// // 		String fileData = new String(ch);
// // 		return fileData;
// // 	}
// // }