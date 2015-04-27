package org.motechproject.ananya.jasper.reports;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AnanyaReportsMigrationTest {

    private TestMigration testMigration = new TestMigration();

    @Test
    public void shouldAddInputControlsAfterAddingAllTheReports() {
        String[] actualReports = testMigration.getReportNamesToAdd();

        assertEquals(2, actualReports.length);
        assertEquals("inputcontrols", actualReports[1]);
    }

    private class TestMigration extends AnanyaReportsMigration {
        @Override
        public String[] getAnanyaReportsToAdd() {
            return new String[]{"hello"};
        }

        @Override
        public String[] getReportNamesToDelete() {
            return new String[0];
        }
    }
}

