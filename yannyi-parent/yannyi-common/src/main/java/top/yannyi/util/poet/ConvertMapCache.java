package top.yannyi.util.poet;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @Author: LeahAna
 * @Date: 2023/5/23 16:07
 * @Desc:
 */

public class ConvertMapCache {

    private static final Map<String, Function<Object, Object>> converterMap = new ConcurrentHashMap<>();

    public static Function<Object, Object> getConverter(String type) {
        return converterMap.computeIfAbsent(type, ConvertMapCache::updateConverterMapCache);
    }

    private static Function<Object, Object> updateConverterMapCache(String type) {
        Function<Object, Object> converter = null;
        switch (type) {
            case "String":
                converter = s -> s;
                break;
            case "Integer":
                converter = parseWithExceptionHandling(Integer::parseInt);
                break;
            case "Long":
                converter = parseWithExceptionHandling(Long::parseLong);
                break;
            case "Double":
                converter = parseWithExceptionHandling(Double::parseDouble);
                break;
            case "Boolean":
                converter = s -> Boolean.parseBoolean(String.valueOf(s));
                break;
            case "Byte":
                converter = parseWithExceptionHandling(Byte::parseByte);
                break;
            case "Short":
                converter = parseWithExceptionHandling(Short::parseShort);
                break;
            case "Float":
                converter = parseWithExceptionHandling(Float::parseFloat);
                break;
            default:
                throw new RuntimeException("Unsupported field type: " + type);
        }
        return converter;
    }

    private static Function<Object, Object> parseWithExceptionHandling(Function<String, ?> parser) {
        return s -> {
            try {
                return parser.apply(String.valueOf(s));
            } catch (Exception e) {
                return null;
            }
        };
    }

    protected static Class<?> getClassFromName(String className) {
        className = Character.toUpperCase(className.charAt(0)) + className.substring(1);
        switch (className) {
            case "Integer":
                return Integer.class;
            case "Boolean":
                return Boolean.class;
            case "Character":
                return Character.class;
            case "Byte":
                return Byte.class;
            case "Short":
                return Short.class;
            case "Long":
                return Long.class;
            case "Float":
                return Float.class;
            case "Double":
                return Double.class;
            case "String":
            default:
                return String.class;
//                throw new IllegalArgumentException("Invalid class name: " + className);
        }
    }


}
