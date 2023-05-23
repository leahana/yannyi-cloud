package top.yannyi.util.retry;

/**
 * @Author: LeahAna
 * @Date: 2023/5/23 15:08
 * @Desc: 重试工具类
 */

public class RetryUtils {

    public static <T> T retry(RetryFunction<T> function, int retryCount, long retryInterval) throws Exception {
        Exception lastException = null;
        while (retryCount > 0) {
            try {
                return function.apply();
            } catch (Exception e) {
                lastException = e;
                retryCount--;
                if (retryCount == 0) {
                    throw lastException;

                } else {
                    Thread.sleep(retryInterval);
                }
            }
        }
        throw new RuntimeException("retry failed");
    }
}
