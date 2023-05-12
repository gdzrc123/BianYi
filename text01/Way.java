package text01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Way {
	//判断字符串是否为数字类型
	boolean isNumeric(String del_String) {
		// TODO Auto-generated method stub
		for (int i = del_String.length()-1;i>=0;i--){
		      if (!Character.isDigit(del_String.charAt(i))){
		          return false;
		      }
		}
		return true;
   }
	
	//向File中重新写入新数据
	public boolean Wrtie_Data(String afterString,String file) {
	// TODO Auto-generated method stub
	   String content=afterString;
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
			
		}catch (IOException el) {
			System.out.print("写入文件发生错误");
			el.printStackTrace();
			// TODO: handle exception
		}
	return true;
	}
	
	//从file读取数据返回子符串
	public String Read_Data(String file) {
		String not_MainString="";
		try {
			String line="";
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
			//UTF-8中文不显示
			while((line=reader.readLine())!=null) {
				not_MainString+=line;
			}
			reader.close();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//System.out.print("字符表读取的字符串 :---");
		//System.out.println(NOT_main_string+"---");
		return not_MainString;
	}
	
	//查找串数组中是否有字串
	public  boolean ZiChuan_find(String Yuan,String string) {
		String arr[]=Yuan.split(",");
		for(int i=0;i<arr.length;i++) {
			if(string.equals(arr[i]))
					return true;
		}			
		return false;
	}
}
