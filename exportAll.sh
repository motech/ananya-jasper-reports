#!/bin/bash
jasper_export_script="$JASPER_HOME/buildomatic/js-export.sh"
reports_destination="src/main/reports/"
$jasper_export_script --uris /Ananya/Reports/Average_Call_Duration/Average_Call_Duration_Report --output-zip $reports_destination/AverageCallDuration.zip
$jasper_export_script --uris /Ananya/Reports/Average_Lesson_Usage/AverageLessonUsageReport --output-zip $reports_destination/AverageLessonUsage.zip
$jasper_export_script --uris /Ananya/Reports/Certificate_Course_Usage/Certificate_Course_Usage_Report --output-zip $reports_destination/CertificateCourseUsage.zip
$jasper_export_script --uris /Ananya/Reports/Certificate_Lesson_Usage_Report/Certificate_Lesson_Usage_Report --output-zip $reports_destination/CertificateLessonUsage.zip
$jasper_export_script --uris /Ananya/Reports/Certificate_Course_Usage_with_Flw_Id/Certificate_Course_Usage_with_Flw_Id --output-zip $reports_destination/CertificationCourseUsageWithFlwId.zip
$jasper_export_script --uris /Ananya/Reports/Certificate_Repeat_Visit/Certificate_Repeat_Visit --output-zip $reports_destination/CertificateRepeatVisit.zip
$jasper_export_script --uris /Ananya/Reports/Chapter__Lesson__Quiz_Completion_Report/Chapter__Lesson__Quiz_Completion_Report --output-zip $reports_destination/ChapterLessonQuizCompletion.zip
$jasper_export_script --uris /Ananya/Reports/Content_Admin/Content_Admin_Report --output-zip $reports_destination/ContentAdmin.zip
$jasper_export_script --uris /Ananya/Reports/Course_Usage/Course_Usage_Report --output-zip $reports_destination/CourseUsage.zip
$jasper_export_script --uris /Ananya/Reports/Detail_FLW_Registration/Detail_FLW_Registration_Report --output-zip $reports_destination/DetailFLWRegistration.zip
$jasper_export_script --uris /Ananya/Reports/IVR_Certification_Report/IVR_Certification_Report --output-zip $reports_destination/IVRCertification.zip
$jasper_export_script --uris /Ananya/Reports/IVR_Content/IVR_Content_Report --output-zip $reports_destination/IVRContent.zip
$jasper_export_script --uris /Ananya/Reports/Job_Aid_Date_wise/Job_Aid_Date_wise_Report --output-zip $reports_destination/JobAidDateWise.zip
$jasper_export_script --uris /Ananya/Reports/Job_Aid_Lesson_Usage/Job_Aid_Lesson_Usage_Report --output-zip $reports_destination/JobAidLessonUsage.zip
$jasper_export_script --uris /Ananya/Reports/Job_Aid_Usage/Job_Aid_Usage_Report --output-zip $reports_destination/JobAidUsage.zip
$jasper_export_script --uris /Ananya/Reports/Percentage_Usage/Percentage_Usage_Report --output-zip $reports_destination/PercentageUsage.zip
$jasper_export_script --uris /Ananya/Reports/Quiz_Score/Quiz_Score_Report --output-zip $reports_destination/QuizScore.zip
$jasper_export_script --uris /Ananya/Reports/Job_Aid_Usage_with_Flw_Id --output-zip $reports_destination/JobAidUsageWithFlwId.zip
$jasper_export_script --uris /Ananya/Reports/Certificate_Course_Usage_with_Flw_Id/Certificate_Course_Usage_with_Flw_Id --output-zip $reports_destination/CertificationCourseUsageWithFlwId.zip
$jasper_export_script --uris /Ananya/Reports/Partially_Registered_FLWs/Partially_Registered_FLWs_Report --output-zip $reports_destination/PartiallyRegisteredFLWs.zip
$jasper_export_script --uris /Ananya/Reports/Job_Aid_Date_wise_Night_Time_Usage/Job_Aid_Date_wise_Night_Usage_Report --output-zip $reports_destination/JobAidDatewiseNightUsage.zip
$jasper_export_script --uris /Ananya/Reports/Disconnected_Calls --output-zip $reports_destination/DisconnectedCalls.zip
$jasper_export_script --uris /Ananya/Input_Controls --output-zip $reports_destination/inputcontrols.zip

