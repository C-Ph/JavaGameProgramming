
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;



public class Configuration {
	
	Properties propeties = new Properties();

	public void saveConfiguration(String key, double value) {
		String path = "config.xml";
		try {
			File file = new File(path);
			boolean exist = file.exists();
			if(!exist) {
				file.createNewFile();
			}
			OutputStream write = new FileOutputStream(path);
			propeties.setProperty(key, Double.toString(value));
			propeties.storeToXML(write, "Options");
		}catch(Exception e) {}	
	}
	
	public void loadConfiguration(String path) {
		try {
			InputStream read = new FileInputStream(path);
			propeties.loadFromXML(read);
			String best = propeties.getProperty("best");
			setBest(Double.parseDouble(best));
			read.close();
		}catch(FileNotFoundException e) {
			saveConfiguration("best", 3.0);
			loadConfiguration(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void setBest(double bestTime) {
		flee.best = bestTime;
	}
	
	
}