package db.migration;

import org.motechproject.ananya.jasper.reports.ReportsMigration;

public class V1_1__InitialReports extends ReportsMigration {
    @Override
    public String[] getReportNamesToAdd() {
        return new String[]{
                "AverageCallDuration",
                "AverageLessonUsage",
                "CertificateCourseUsage",
                "QuizScore",
                "CertificateLessonUsage",
                "CertificateRepeatVisit",
                "ChapterLessonQuizCompletion",
                "ContentAdmin",
                "CourseUsage",
                "DetailFLWRegistration",
                "IvrCertification",
                "JobAidDateWise"
        };
    }

    @Override
    public String[] getReportNamesToDelete() {
        return new String[0];
    }
}

