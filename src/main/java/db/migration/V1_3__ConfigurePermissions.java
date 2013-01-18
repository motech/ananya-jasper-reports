package db.migration;

import db.migration.domain.EntityResource;
import db.migration.domain.Item;
import db.migration.domain.PermissionRecipient;
import org.motechproject.ananya.jasper.reports.domain.Roles;
import org.motechproject.jasper.reports.AccessRights;
import org.motechproject.jasper.reports.ReportsPermissions;
import org.motechproject.jasper.reports.ReportsProperties;
import org.motechproject.jasper.reports.util.JasperRESTClient;

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
        restrictAccessTo(Roles.ROLE_USER, items);
        setAppropriatePermissionTo(Roles.ROLE_FLW, items);
        setExecuteOnlyPermissionOnSystemFolders(Roles.ROLE_USER, items);
        return new EntityResource(items);
    }

    private void restrictAccessTo(Roles role, List<Item> items) {
        items.add(new Item(AccessRights.NO_ACCESS.getPermissionMask(), new PermissionRecipient(role.name()), "repo:/Ananya"));
    }

    private void setExecuteOnlyPermissionOnSystemFolders(Roles role, List<Item> items) {
        items.add(new Item(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(role.name()), "repo:/System Properties"));
    }

    private void setAppropriatePermissionTo(Roles role, List<Item> items) {
        String roleName = role.name();
        items.add(new Item(AccessRights.READ_ONLY.getPermissionMask(), new PermissionRecipient(roleName), "repo:/Ananya"));
        items.add(new Item(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(roleName), "repo:/Ananya/Data_Sources"));
        items.add(new Item(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(roleName), "repo:/Ananya/Input_Controls"));
    }
}
