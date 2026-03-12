package utilities;

import constants.FrameworkConstants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunManager {
    
    private static String runFolder;
    private static String testRunName;
    
    public static void setTestName(String name) {
        testRunName = name.replaceAll("[^a-zA-Z0-9]", "_");
        runFolder = null;
    }
    
    public static String getRunFolder() {
        
        if (runFolder == null) {
            
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());
            
            String baseFolder = System.getProperty("user.dir")
                    + "/reports/" + testRunName + " Runs";
            
            String runPath = baseFolder + "/" + "TR-" + timestamp;
            
            new File(runPath + "/screenshots").mkdirs();
            
            runFolder = runPath;
        }
        
        return runFolder;
    }
}