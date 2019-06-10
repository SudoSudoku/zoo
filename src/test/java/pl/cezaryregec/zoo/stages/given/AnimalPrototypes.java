package pl.cezaryregec.zoo.stages.given;

import pl.cezaryregec.zoo.actions.animals.AnimalType;
import pl.cezaryregec.zoo.model.animal.Animal;
import pl.cezaryregec.zoo.model.animal.Elephant;
import pl.cezaryregec.zoo.model.animal.Giraffe;
import pl.cezaryregec.zoo.model.animal.Tiger;

import java.time.LocalDate;

public class AnimalPrototypes {

    public static Animal create(AnimalType type, String name) {
        switch (type) {
            case GIRAFFE:
                return createGiraffe(name);
            case ELEPHANT:
                return createElephant(name);
            case TIGER:
                return createTiger(name);
        }
        throw new IllegalStateException("Type not supported: " + type);
    }

    public static Giraffe createGiraffe(String name) {
        return new Giraffe(name, LocalDate.now());
    }

    public static Elephant createElephant(String name) {
        return new Elephant(name, LocalDate.now());
    }

    public static Tiger createTiger(String name) {
        return new Tiger(name, LocalDate.now());
    }
}
