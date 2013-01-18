package db.migration;

import db.migration.domain.Role;
import org.motechproject.ananya.jasper.reports.domain.Roles;
import org.motechproject.jasper.reports.ReportsProperties;
import org.motechproject.jasper.reports.ReportsRoles;
import org.motechproject.jasper.reports.util.JasperRESTClient;

import java.util.ArrayList;
import java.util.List;

public class V1_2__CreateRoles extends ReportsRoles {

    public V1_2__CreateRoles() {
    }

    public V1_2__CreateRoles(JasperRESTClient jasperRESTClient, ReportsProperties reportsProperties) {
        super(jasperRESTClient, reportsProperties);
    }

    @Override
    protected List<Role> getRolesToCreate() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Roles.ROLE_FLW.getRole());
        return roles;
    }
}
