package top.yannyi.util.retry;

/**
 * 重试接口
 * @param <T>
 */
public interface RetryFunction<T> {
    T apply() throws Exception;
}
