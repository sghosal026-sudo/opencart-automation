package listeners;

import factory.DriverFactory;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IRetryAnalyzer, IAnnotationTransformer {
    private int retries = 0;
    private final int MAX_RETRY = 2; // number of retries
    
    @Override
    public boolean retry(ITestResult result) {
        if (retries < MAX_RETRY) {
            retries++;
            
            DriverFactory.quit();
            
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(this.getClass());
    }
}
