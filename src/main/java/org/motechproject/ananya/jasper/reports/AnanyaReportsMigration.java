package org.motechproject.ananya.jasper.reports;

import org.motechproject.jasper.reports.ReportsMigration;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AnanyaReportsMigration extends ReportsMigration {

    public abstract String[] getAnanyaReportsToAdd();

    @Override
    public String[] getReportNamesToAdd() {
        String[] ananyaReportsToAdd = getAnanyaReportsToAdd();
        ArrayList<String> reportList = new ArrayList<>(Arrays.asList(ananyaReportsToAdd));
        reportList.add("inputcontrols");
        return reportList.toArray(new String[reportList.size()]);
    }
}
