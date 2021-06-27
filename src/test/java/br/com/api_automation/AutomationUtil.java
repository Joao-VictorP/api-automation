package br.com.api_automation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AutomationUtil {

	public static String getProperty(String propriedade) {
		try {
			InputStream is = AutomationUtil.class.getResourceAsStream("/config.properties");
			Properties props = new Properties();
			props.load(is);

			return props.getProperty(propriedade);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
