package com.venustech.scanner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;


public class Client {
	public static void main(final String[] args) {
		try {
		  Config config = new Config("manual.properties");
		  String fileDirPath=new String( config.getString("dirPath").getBytes("ISO-8859-1"), "utf-8");
		  File root = new File(fileDirPath);
		  File[] files = root.listFiles();
		  for(File file:files){     
			  if(file.getName().endsWith(".htm")){
				  String fileStr = 	FileUtils.readFileToString(file, "GBK");
				  Map<String,String> sourcemap = new HashMap<String,String>();
				  if(file.getName().endsWith("left.htm")){
					  sourcemap=UserManualUtil.getSource();
				  }else{
					  sourcemap=UserManualUtil.getSource();
				  }
				  for (Map.Entry<String, String> entry : sourcemap.entrySet()) {
					  fileStr =  fileStr.replaceAll(entry.getKey(), entry.getValue());
				  }
				  file.delete();
				  FileUtils.write(file, fileStr,"GBK");
			  }
		   }
		  System.out.println("执行成功");
		  } catch (Exception e) {
		  System.out.println("执行失败");
			  e.printStackTrace();
		}
		
		
	}
}
