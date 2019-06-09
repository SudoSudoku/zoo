package pl.cezaryregec.zoo.actions.animals.add;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.cezaryregec.zoo.actions.ActionQuery;
import pl.cezaryregec.zoo.actions.animals.AnimalType;
import pl.cezaryregec.zoo.console.annotation.ReadableName;

@NoArgsConstructor
@Getter
public class AddAnimalQuery implements ActionQuery {
    @ReadableName("Rodzaj zwierzęcia")
    private AnimalType type;

    @ReadableName("Imię zwierzęcia")
    private String name;

    @ReadableName("Rok urodzenia")
    private Integer yearOfBirth;

    @ReadableName("Miesiąc urodzenia")
    private Integer monthOfBirth;

    @ReadableName("Dzień urodzenia")
    private Integer dayOfBirth;
}
