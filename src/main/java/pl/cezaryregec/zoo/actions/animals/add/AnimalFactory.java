package pl.cezaryregec.zoo.actions.animals.add;

import pl.cezaryregec.zoo.model.animal.Animal;
import pl.cezaryregec.zoo.model.animal.Elephant;
import pl.cezaryregec.zoo.model.animal.Giraffe;
import pl.cezaryregec.zoo.model.animal.Tiger;

import java.time.LocalDate;

class AnimalFactory {
    static Animal create(AddAnimalQuery query) {
        LocalDate birthday = LocalDate.of(query.getYearOfBirth(), query.getMonthOfBirth(), query.getDayOfBirth());
        switch (query.getType()) {
            case GIRAFFE:
                return new Giraffe(query.getName(), birthday);
            case ELEPHANT:
                return new Elephant(query.getName(), birthday);
            case TIGER:
                return new Tiger(query.getName(), birthday);
        }

        throw new IllegalStateException("Unknown animal type");
    }
}
