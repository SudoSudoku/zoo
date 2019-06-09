package pl.cezaryregec.zoo.actions.animals;

import pl.cezaryregec.zoo.model.animal.Elephant;
import pl.cezaryregec.zoo.model.animal.Giraffe;
import pl.cezaryregec.zoo.model.animal.Tiger;

public class AnimalTypeFactory {
    public static Class<?> create(AnimalType type) {
        switch (type) {
            case GIRAFFE:
                return Giraffe.class;
            case ELEPHANT:
                return Elephant.class;
            case TIGER:
                return Tiger.class;
        }

        throw new IllegalStateException("Animal type " + type + " is not supported");
    }
}
