package db.migration;

import org.motechproject.ananya.jasper.reports.ReportsMigration;

public class V1_1__InitialReports extends ReportsMigration {
    @Override
    public String[] getReportNamesToAdd() {
        return new String[]{
                "AverageCallDuration",
                "AverageLessonUsage",
                "CertificateCourseUsage",
                "CertificateLessonUsage",
                "CertificateRepeatVisit",
                "ChapterLessonQuizCompletion",
                "ContentAdmin",
                "CourseUsage",
                "DetailFLWRegistration",
                "IVRCertification",
                "IVRContent",
                "JobAidDateWise",
                "JobAidUsage",
                "PercentageUsage",
                "JobAidLessonUsage",
                "QuizScore",
                "JobAidUsageWithFlwId",
                "CertificationCourseUsageWithFlwId"
        };
    }

    @Override
    public String[] getReportNamesToDelete() {
        return new String[0];
    }
}

