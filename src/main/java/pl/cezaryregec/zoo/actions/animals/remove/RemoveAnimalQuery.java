package pl.cezaryregec.zoo.actions.animals.remove;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.cezaryregec.zoo.actions.ActionQuery;
import pl.cezaryregec.zoo.console.annotation.ReadableName;

@NoArgsConstructor
@Getter
public class RemoveAnimalQuery implements ActionQuery {
    @ReadableName("Imię zwierzęcia")
    private String name;
}
