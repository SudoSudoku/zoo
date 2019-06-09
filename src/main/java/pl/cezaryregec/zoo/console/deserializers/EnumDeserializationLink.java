package pl.cezaryregec.zoo.console.deserializers;

import pl.cezaryregec.zoo.utils.ReflectionUtils;

import java.util.stream.Stream;

public class EnumDeserializationLink implements DeserializationLink {
    @Override
    public Object deserialize(String input, Class<?> type) {
        if (type.getSuperclass() == Enum.class) {
            Class<? extends Enum> enumClass = (Class<? extends Enum>) type;
            return Enum.valueOf(enumClass, input);
        }
        return null;
    }
}
