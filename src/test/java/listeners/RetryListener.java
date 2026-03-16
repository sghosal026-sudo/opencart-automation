package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IRetryAnalyzer, IAnnotationTransformer {
    private final int MAX_RETRY = 2; // number of retries
    private int retries = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retries < MAX_RETRY) {
            retries++;
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
