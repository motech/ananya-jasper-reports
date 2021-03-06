package db.migration;

import com.googlecode.flyway.core.migration.java.JavaMigration;
import org.motechproject.jasper.reports.ReportsProperties;
import org.motechproject.jasper.reports.util.JasperRESTClient;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class V1_0__DeleteFolders implements JavaMigration {

    private final ReportsProperties properties;
    private RestTemplate restTemplate;

    public V1_0__DeleteFolders() {
        properties = new ReportsProperties();
        restTemplate = new RestTemplate();
    }

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        JasperRESTClient jasperRESTClient = new JasperRESTClient();
        String reportsFolderInJasperServer = properties.getReportsRootLocation();
        try {
            jasperRESTClient.deleteResource(reportsFolderInJasperServer);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() != HttpStatus.NOT_FOUND) {
                throw e;
            }
        }
    }
}