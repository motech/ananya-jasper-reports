package org.motechproject.ananya.jasper.reports;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReportsProperties {

    private Properties properties;

    public ReportsProperties() {
        properties = new Properties();
        try {
            InputStream inputStream = getClass().getResourceAsStream("/flwJasperReports.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getReportsSourceLocation() {
        return properties.getProperty("reports.source.location");
    }

    public String getAnanyaFolderInJasperserver() {
        return properties.getProperty("jasper.reports.root.location.name");
    }

    public String getJasperserverResourceURL() {
        return properties.getProperty("jasper.resource.url");
    }

    public String getJasperserverUserName() {
        return properties.getProperty("jasper.username");
    }

    public String getJasperserverPassword() {
        return properties.getProperty("jasper.password");
    }
}