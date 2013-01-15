package db.migration;

import db.migration.domain.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.ananya.jasper.reports.ReportsProperties;
import org.motechproject.ananya.jasper.reports.util.JasperRESTClient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class V1_2__CreateRolesTest {
    @Mock
    private JasperRESTClient jasperRESTClient;
    @Mock
    private ReportsProperties reportsProperties;
    private V1_2__CreateRoles createRoles;

    @Before
    public void setup(){
        createRoles = new V1_2__CreateRoles(jasperRESTClient, reportsProperties);
    }

    @Test
    public void shouldCreateRole() throws Exception {
        String url = "/jasperserver/rest/role/";
        when(reportsProperties.getJasperRoleCreationURL()).thenReturn(url);

        createRoles.migrate(null);

        ArgumentCaptor<Role> captor = ArgumentCaptor.forClass(Role.class);
        verify(jasperRESTClient).put(eq(url), captor.capture());
        List<Role> actualRequestBody = captor.getAllValues();
        assertEquals(1, actualRequestBody.size());
        assertEquals(new Role("ROLE_FLW"), actualRequestBody.get(0));
    }
}
