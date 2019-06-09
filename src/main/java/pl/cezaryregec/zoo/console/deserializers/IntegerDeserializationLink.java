package pl.cezaryregec.zoo.console.deserializers;

public class IntegerDeserializationLink implements DeserializationLink {
    @Override
    public Object deserialize(String input, Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return Integer.valueOf(input);
        }
        return null;
    }
}
