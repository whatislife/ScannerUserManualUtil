package com.venustech.scanner;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
public class Config {
  private Properties cfg = new Properties();
  public Config(String file){
    try {
      cfg.load(new FileInputStream(file));
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  public String getString(String key){
    return cfg.getProperty(key);
  }
  
  public int getInt(String key){
    return Integer.parseInt(cfg.getProperty(key));
  }
  
  public double getDouble(String key){
    return Double.parseDouble(getString(key));
  }
public  void showKeysAndValues() {  
      Iterator<Entry<Object, Object>> it = cfg.entrySet().iterator();  
      while (it.hasNext()) {  
          Entry<Object, Object> entry = it.next();  
          Object key = entry.getKey();  
          Object value = entry.getValue();  
          System.out.println("key   :" + key);  
          System.out.println("value :" + value);  
          System.out.println("---------------");  
      }  
  }  
}
