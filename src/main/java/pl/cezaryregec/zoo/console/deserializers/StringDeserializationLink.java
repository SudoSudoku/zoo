package pl.cezaryregec.zoo.console.deserializers;

public class StringDeserializationLink implements DeserializationLink {

    @Override
    public Object deserialize(String input, Class<?> type) {
        if (type == String.class) {
            return input;
        }

        return null;
    }
}
