package pl.cezaryregec.zoo.console.deserializers;

public interface DeserializationLink {
    Object deserialize(String input, Class<?> type);
}
