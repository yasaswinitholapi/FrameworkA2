package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/*
 * THIS CLASS CONTANS REUSABLE METHODS TO NTIIALIZE AND READ DATA FROM PROPERTIES FILE
 * @author yasaswini
 */
public class PropertiesUtility {
	private Properties property;
	/**
	 * This method is used to initialize properties file
	 * @param filepath
	 */
  public void propertesInit(String filePath)
  
  {
	  FileInputStream fis=null;
	  try {
	 fis =new   FileInputStream (filePath);
	  }
	  catch(FileNotFoundException e)
	  {
		  e.printStackTrace();
	  }
	  property=new Properties();
	  try {
		  property.load(fis);
	  }
	  catch(IOException e )
	  {
		  e.printStackTrace();
	  }
  }
  /**
   * THIS METHOD FETCHES DATA FROM PROPERTIES FLE BASED ON THE KEY PASSED AS AN ARGUMRNT
   * @param key
   * @return
   */
  public String readFromProperties(String key)
  {
	return property.getProperty(key);
	  
  }
}
