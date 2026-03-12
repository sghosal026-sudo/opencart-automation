package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance() {
        
        if (extent == null) {
            
            String reportPath = RunManager.getRunFolder() + "/index.html";
            
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            
            spark.config().setDocumentTitle("OpenCart Automation Report");
            spark.config().setReportName("Test Execution Results");
            
            extent = new ExtentReports();
            extent.attachReporter(spark);
            
            extent.setSystemInfo("Tester", "Souvik");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", ConfigReader.getProperty("BROWSER"));
        }
        
        return extent;
    }
}