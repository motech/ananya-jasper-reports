package db.migration;


import org.motechproject.ananya.jasper.reports.AnanyaReportsMigration;

public class V1_1__InitialReports extends AnanyaReportsMigration {
    @Override
    public String[] getAnanyaReportsToAdd() {
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
                "CertificationCourseUsageWithFlwId",
                "PartiallyRegisteredFLWs",
                "JobAidDatewiseNightUsage",
                "DisconnectedCalls"
        };
    }

    @Override
    public String[] getReportNamesToDelete() {
        return new String[0];
    }
}

