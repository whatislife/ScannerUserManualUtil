package com.venustech.scanner;

import java.util.HashMap;
import java.util.Map;

public class UserManualUtil {
	public static Map<String,String> getSource(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("<!-- Generated by CHM Decoder \\(http://www.gridinsoft.com\\) -->\r\n", "");
		map.put("<meta name=\"generator\" content=\"CHM Decoder by GridinSoft LLC   www.gridinsoft.com\">", "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\" />\r\n");
		map.put("<script type=\"text/javascript\" src=\"___dtree.js\"></script>", "<script type=\"text/javascript\" src=\"../js/jquery/jquery-1.4.3.min.js\"></script>\r\n<script type=\"text/javascript\" src=\"___dtree.js\"></script>");
		map.put("<a href=\"javascript: d.closeAll\\(\\);\">全部折叠</a></p>" ,"<a href=\"javascript: d.closeAll\\(\\);\">全部折叠</a></p>\r\n<div id=\"showManualMenu\"></div>");
		map.put("document.write\\(d\\);", "\\$\\(\"#showManualMenu\"\\).html\\(d+\"\"\\);");
		map.put("<font class=\"dtree\">由<a target=\"_blank\" href=\"http://www.gridinsoft.com\">CHM Decoder生成，xhs0923汉化！</a></font><br><br>\r\n", "");
		map.put("<font class=\"dtree\">你想要翻译此文档到其他语言吗\\?<br>立即获取<a target=\"_blank\" href=\"http://www.chmeditor.com\">CHM Editor来编辑!</a> </font>\r\n", "");
		map.put("<meta http-equiv=Content-Type content=\"text/html; charset=x-cp20936\">","<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\" />");
		map.put("  <meta name=\"GENERATOR\" content=\"Macrobject Word-2-CHM\">\r\n", "");
		return map;
	}
	public static Map<String,String> getReplaceSourceLeft(){
		Map<String,String> mapLeft = new HashMap<String,String>();
		mapLeft.put("<!-- Generated by CHM Decoder \\(http://www.gridinsoft.com\\) -->\r\n", "");
		mapLeft.put("<meta name=\"generator\" content=\"CHM Decoder by GridinSoft LLC   www.gridinsoft.com\">", "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\" />\r\n");
		mapLeft.put("<script type=\"text/javascript\" src=\"___dtree.js\"></script>", "<script type=\"text/javascript\" src=\"../js/jquery/jquery-1.4.3.min.js\"></script>\r\n<script type=\"text/javascript\" src=\"___dtree.js\"></script>");
		mapLeft.put("<a href=\"javascript: d.closeAll\\(\\);\">全部折叠</a></p>" ,"<a href=\"javascript: d.closeAll\\(\\);\">全部折叠</a></p>\r\n<div id=\"showManualMenu\"></div>");
		mapLeft.put("document.write\\(d\\);", "\\$\\(\"#showManualMenu\"\\).html\\(d+\"\"\\);");
		mapLeft.put("<font class=\"dtree\">由<a target=\"_blank\" href=\"http://www.gridinsoft.com\">CHM Decoder生成，xhs0923汉化！</a></font><br><br>\r\n", "");
		mapLeft.put("<font class=\"dtree\">你想要翻译此文档到其他语言吗\\?<br>立即获取<a target=\"_blank\" href=\"http://www.chmeditor.com\">CHM Editor来编辑!</a> </font>\r\n", "");
		return mapLeft;
	}
	public static Map<String,String> getReplaceSourceExceptLeft(){
		Map<String,String> mapExceptLeft = new HashMap<String,String>();
		mapExceptLeft.put("<meta http-equiv=Content-Type content=\"text/html; charset=x-cp20936\">","<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\" />");
	    mapExceptLeft.put("  <meta name=\"GENERATOR\" content=\"Macrobject Word-2-CHM\">\r\n", "");
	    return mapExceptLeft;
	}
}