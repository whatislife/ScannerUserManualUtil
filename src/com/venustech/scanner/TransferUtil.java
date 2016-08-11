package com.venustech.scanner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class TransferUtil {
	public  static String  userManual(String srcPath,String destPath){
		String flag = "";
		try {
			File fileSrc = new File(srcPath);
			File fileDest = new File(destPath+"\\");
			//FileUtils.deleteDirectory(fileDest);
			FileUtils.copyDirectory(fileSrc, fileDest);
			String fileDirPath = destPath;
			File root = new File(fileDirPath);
			File[] files = root.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.getName().endsWith(".htm")) {
						String fileStr = FileUtils
								.readFileToString(file, "GBK");
						Map<String, String> sourcemap = new HashMap<String, String>();
						if (file.getName().endsWith("left.htm")) {
							sourcemap = UserManualUtil.getSource();
						} else {
							sourcemap = UserManualUtil.getSource();
						}
						for (Map.Entry<String, String> entry : sourcemap
								.entrySet()) {
							fileStr = fileStr.replaceAll(entry.getKey(),
									entry.getValue());
						}
						file.delete();
						FileUtils.write(file, fileStr, "GBK");
					}
				}
			} 
			flag = "转化成功";
		} catch (Exception e) {
			flag = "执行失败";
			e.printStackTrace();
		}
		return flag;
	}

}
