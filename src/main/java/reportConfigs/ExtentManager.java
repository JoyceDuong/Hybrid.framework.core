package reportConfigs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/ExtentReport.html");
        reporter.config().setReportName(" Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Vnext.Automation", "Selenium Java Framework | HieuDm");
        extentReports.setSystemInfo("Author", "Hieu Automation Tester");
        return extentReports;
    }
}
