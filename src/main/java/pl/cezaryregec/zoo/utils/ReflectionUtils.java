package pl.cezaryregec.zoo.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {

    private ReflectionUtils() {}

    public static <T> T createInstance(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setField(Field field, Object object, Object value) {
        boolean wasAccessible = field.isAccessible();
        try {
            field.setAccessible(true);
            field.set(object, value);
            field.setAccessible(wasAccessible);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
