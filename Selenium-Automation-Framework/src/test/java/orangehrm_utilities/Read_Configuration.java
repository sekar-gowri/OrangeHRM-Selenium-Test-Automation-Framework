package orangehrm_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//created configuration class for reading values from properties file
public class Read_Configuration {

	Properties p;

	public Read_Configuration() {
		File config = new File("./Configuration_File\\Configuration.properties");

		try {
			FileInputStream fis = new FileInputStream(config);
			p = new Properties();
			p.load(fis);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	public String get_Application_URL() {
		String url = p.getProperty("URL");
		return url;

	}
}
