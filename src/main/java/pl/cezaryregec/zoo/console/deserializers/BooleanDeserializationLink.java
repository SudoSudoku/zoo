package pl.cezaryregec.zoo.console.deserializers;

public class BooleanDeserializationLink implements DeserializationLink {

    @Override
    public Object deserialize(String input, Class<?> type) {
        if (type == Boolean.class || type == boolean.class) {
            return Boolean.valueOf(input);
        }

        return null;
    }
}
