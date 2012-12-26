package db.migration;

import org.motechproject.ananya.jasper.reports.ReportsMigration;

public class V1_1__InitialReports extends ReportsMigration {
    @Override
    public String[] getReportNamesToAdd() {
        return new String[]{"averageCallDuration", "quizScore"};
    }

    @Override
    public String[] getReportNamesToDelete() {
        return new String[0];
    }
}

