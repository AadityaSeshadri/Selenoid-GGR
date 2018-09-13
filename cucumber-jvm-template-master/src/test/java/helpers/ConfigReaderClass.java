package helpers;

public class ConfigReaderClass {

    public String getReportConfigPath(){
        String reportConfigPath = System.getProperty("user.dir")+"\\config\\extent-config.xml";
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }


}
