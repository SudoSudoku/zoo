package pl.cezaryregec.zoo.console.deserializers;

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
