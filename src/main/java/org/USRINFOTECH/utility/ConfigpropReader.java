package org.USRINFOTECH.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigpropReader {
	
	
		private Properties prop;
		private FileInputStream ip;

		public Properties initLangProp(String language)
		{
			prop = new Properties();
			try {
				switch (language.toLowerCase()) {

				case "360degree_flow":
					ip = new FileInputStream("./properties/360Degree_Flow.properties");
					break;

				case "normalflowtest":
					ip = new FileInputStream("./src/resourcestyrty/configProperties/NormalFlowTest.properties");
					System.out.println(ip);
					break;

					default:
					System.out.println("lang not found..." + language);
					break;
				}
				prop.load(ip);
			} catch (Exception e) {

			}
			return prop;
		}
	}


