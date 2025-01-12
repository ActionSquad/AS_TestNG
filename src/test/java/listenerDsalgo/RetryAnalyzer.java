package listenerDsalgo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final int MAX_RETRY_COUNT = 3;

    // ThreadLocal to store retry count per thread
    private ThreadLocal<Integer> retryCount = ThreadLocal.withInitial(() -> 0);

    @Override
    public boolean retry(ITestResult result) {
        int currentRetry = retryCount.get();
        if (currentRetry < MAX_RETRY_COUNT && !result.isSuccess()) {
            retryCount.set(currentRetry + 1); // Increment retry count for this thread
            System.out.println("Retrying test " + result.getName() + " for the " + retryCount.get() + " time.");
            return true; // Retry the test
        }
        return false; // Do not retry
    }
}
