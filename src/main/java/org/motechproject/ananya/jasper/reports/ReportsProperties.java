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
        String resourcePath = properties.getProperty("jasper.resource.path");
        return String.format("%s%s", getJasperserverURL(), resourcePath);
    }


    public String getJasperserverUserName() {
        return properties.getProperty("jasper.username");
    }

    public String getJasperserverPassword() {
        return properties.getProperty("jasper.password");
    }

    public String getJasperRoleCreationURL() {
        String roleCreationPath = properties.getProperty("jasper.role.creation.path");
        return String.format("%s%s", getJasperserverURL(), roleCreationPath);
    }

    private String getJasperserverURL() {
        return properties.getProperty("jasper.url");
    }

    public String getJasperPermissionsURL() {
        String setPermissionsPath = properties.getProperty("jasper.set.permissions.path");
        return String.format("%s%s", getJasperserverURL(), setPermissionsPath);
    }
}