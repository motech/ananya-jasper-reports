package db.migration;

import db.migration.domain.EntityResource;
import db.migration.domain.Item;
import db.migration.domain.PermissionRecipient;
import org.motechproject.ananya.jasper.reports.AccessRights;
import org.motechproject.ananya.jasper.reports.ReportsPermissions;
import org.motechproject.ananya.jasper.reports.ReportsProperties;
import org.motechproject.ananya.jasper.reports.util.JasperRESTClient;

import java.util.ArrayList;
import java.util.List;

public class V1_3__ConfigurePermissions extends ReportsPermissions {

    public V1_3__ConfigurePermissions() {
    }

    public V1_3__ConfigurePermissions(JasperRESTClient jasperRESTClient, ReportsProperties reportsProperties) {
        super(jasperRESTClient, reportsProperties);
    }

    @Override
    protected EntityResource getResourcePermissions() {
        List<Item> items = new ArrayList<>();
        restrictAccessTo("ROLE_USER", items);
        setAppropriatePermissionTo("ROLE_FLW", items);
        return new EntityResource(items);
    }

    private void restrictAccessTo(String role, List<Item> items) {
        items.add(new Item(AccessRights.NO_ACCESS.getPermissionMask(), new PermissionRecipient(role), "repo:/Ananya"));
    }

    private void setAppropriatePermissionTo(String role, List<Item> items) {
        items.add(new Item(AccessRights.READ_ONLY.getPermissionMask(), new PermissionRecipient(role), "repo:/Ananya"));
        items.add(new Item(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(role), "repo:/Ananya/Data_Sources"));
        items.add(new Item(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(role), "repo:/Ananya/Input_Controls"));
    }
}
