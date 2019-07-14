package config;

public class MainMethod {

	public static void main(String[] args) {
		//ConfigurationReader.getInstance().readConfigFile();
		//System.out.println(ConfigurationReader.getInstance().browseType);
		//System.out.println(ConfigurationReader.getInstance().url);
		
		AccessDataReader e = new AccessDataReader();
		System.out.println(e.readExcelFile());
	}

}
