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
//			String[] children = fileDest.list();
//	        for (int i=0; i<children.length; i++) {
//	            boolean success = deleteDir(new File(fileDest, children[i]));
//	            if(!success){
//	            	return "删除目标目录失败";
//	            }
//	        }
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
	private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

}
