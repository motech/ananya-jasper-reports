package db.migration;

import db.migration.domain.EntityResource;
import db.migration.domain.PermissionItem;
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
        List<PermissionItem> permissions = new ArrayList<>();

        addPermissionsForDefaultRole(permissions);
        addPermissionsForFLWRole(permissions);

        return new EntityResource(permissions);
    }

    private void addPermissionsForDefaultRole(List<PermissionItem> permissions) {
        PermissionRecipient permissionRecipient = new PermissionRecipient(Roles.ROLE_USER.name());
        permissions.add(new PermissionItem(AccessRights.NO_ACCESS.getPermissionMask(), permissionRecipient, "repo:/Ananya"));
        permissions.add(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), permissionRecipient, "repo:/themes"));
        permissions.add(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), permissionRecipient, "repo:/properties"));
    }

    private void addPermissionsForFLWRole(List<PermissionItem> permissions) {
        PermissionRecipient permissionRecipient = new PermissionRecipient(Roles.ROLE_FLW.name());
        permissions.add(new PermissionItem(AccessRights.READ_ONLY.getPermissionMask(), permissionRecipient, "repo:/Ananya"));
        permissions.add(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), permissionRecipient, "repo:/Ananya/Data_Sources"));
        permissions.add(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), permissionRecipient, "repo:/Ananya/Input_Controls"));
    }
}
