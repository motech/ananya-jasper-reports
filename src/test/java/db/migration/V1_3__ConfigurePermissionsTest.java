package db.migration;

import db.migration.domain.EntityResource;
import db.migration.domain.PermissionItem;
import db.migration.domain.PermissionRecipient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.ananya.jasper.reports.domain.Roles;
import org.motechproject.jasper.reports.AccessRights;
import org.motechproject.jasper.reports.ReportsProperties;
import org.motechproject.jasper.reports.util.JasperRESTClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class V1_3__ConfigurePermissionsTest {
    @Mock
    private JasperRESTClient jasperRESTClient;
    @Mock
    private ReportsProperties reportsProperties;
    private V1_3__ConfigurePermissions configurePermissions;

    @Before
    public void setup() {
        configurePermissions = new V1_3__ConfigurePermissions(jasperRESTClient, reportsProperties);
    }

    @Test
    public void shouldSetAppropriatePermissions() throws Exception {
        String url = "/jasperserver/rest/permission/";
        when(reportsProperties.getJasperPermissionsURL()).thenReturn(url);

        configurePermissions.migrate(null);

        ArgumentCaptor<EntityResource> captor = ArgumentCaptor.forClass(EntityResource.class);
        verify(jasperRESTClient).put(eq(url), captor.capture());
        EntityResource actualRequestBody = captor.getValue();
        assertEquals(6, actualRequestBody.getPermissionItem().size());

        assertTrue(actualRequestBody.getPermissionItem().contains(new PermissionItem(AccessRights.NO_ACCESS.getPermissionMask(), new PermissionRecipient(Roles.ROLE_USER.name()), "repo:/Ananya")));
        assertTrue(actualRequestBody.getPermissionItem().contains(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(Roles.ROLE_USER.name()), "repo:/themes")));
        assertTrue(actualRequestBody.getPermissionItem().contains(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(Roles.ROLE_USER.name()), "repo:/properties")));
        assertTrue(actualRequestBody.getPermissionItem().contains(new PermissionItem(AccessRights.READ_ONLY.getPermissionMask(), new PermissionRecipient(Roles.ROLE_FLW.name()), "repo:/Ananya")));
        assertTrue(actualRequestBody.getPermissionItem().contains(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(Roles.ROLE_FLW.name()), "repo:/Ananya/Data_Sources")));
        assertTrue(actualRequestBody.getPermissionItem().contains(new PermissionItem(AccessRights.EXECUTE_ONLY.getPermissionMask(), new PermissionRecipient(Roles.ROLE_FLW.name()), "repo:/Ananya/Input_Controls")));
    }
}
