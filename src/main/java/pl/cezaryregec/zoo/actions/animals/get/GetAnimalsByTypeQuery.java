package pl.cezaryregec.zoo.actions.animals.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.cezaryregec.zoo.actions.ActionQuery;
import pl.cezaryregec.zoo.actions.animals.AnimalType;
import pl.cezaryregec.zoo.console.annotation.ReadableName;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetAnimalsByTypeQuery implements ActionQuery {
    @ReadableName("Typ zwierzęcia")
    private AnimalType type;
}
