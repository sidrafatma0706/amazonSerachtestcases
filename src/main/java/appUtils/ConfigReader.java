package appUtils;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    
    static {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/config.properties");
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getBrowser() {
        return getProperty("browser");
    }
    
    public static String getUrl() {
        return getProperty("url");
    }
    public static String getScreenshot() {
        return getProperty("screenshot.path");
    }
   
//    public static int getImplicitWait() {
//        return Integer.parseInt(getProperty("implicit.wait"));
//    }

	public static String getExcelfile() {
		
		return getProperty ("excel.path");
	}
	public static String getExtentReportFile() {
		
		return getProperty ("extent.report.path");
	}
	

	
}