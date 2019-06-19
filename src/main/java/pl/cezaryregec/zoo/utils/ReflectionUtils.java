package pl.cezaryregec.zoo.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionUtils {

    private static final Map<Class<?>, Object> IMPLEMENTATIONS = new ConcurrentHashMap<>();

    private ReflectionUtils() {}

    public static <T> void bind (Class<T> type, Class<? extends T> implementationClass) {
        T instance = createInstance(implementationClass);
        IMPLEMENTATIONS.put(implementationClass, instance);
        IMPLEMENTATIONS.put(type, instance);
    }

    public static <T, I extends T> void bind(Class<I> type, I implementation) {
        IMPLEMENTATIONS.put(implementation.getClass(), implementation);
        IMPLEMENTATIONS.put(type, implementation);
    }

    public static <T> T getInstance(Class<T> type) {
        return (T) IMPLEMENTATIONS.computeIfAbsent(type, (instanceType) -> createInstance(instanceType));
    }

    public static <T> T createInstance(Class<T> type) {
        try {
            Constructor<?>[] declaredConstructors = type.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                throw new InstantiationException("Cannot make an instance of an interface: " + type.getCanonicalName());
            }

            Constructor constructor = declaredConstructors[0];
            for (Constructor c : declaredConstructors) {
                if (c.getParameterTypes().length == 0) {
                    constructor = c;
                }
            }

            Class[] parameterTypes = constructor.getParameterTypes();
            List<Object> parameters = new ArrayList<>();
            for (Class<?> parameter : parameterTypes) {
                parameters.add(getInstance(parameter));
            }

            return (T) constructor.newInstance(parameters.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
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
