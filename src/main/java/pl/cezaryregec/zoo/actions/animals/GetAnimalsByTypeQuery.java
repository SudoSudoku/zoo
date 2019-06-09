package pl.cezaryregec.zoo.actions.animals;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.cezaryregec.zoo.actions.ActionQuery;
import pl.cezaryregec.zoo.console.annotation.ReadableName;

@NoArgsConstructor
@Getter
public class GetAnimalsByTypeQuery implements ActionQuery {
    @ReadableName("Typ zwierzęcia")
    private AnimalType type;
}
