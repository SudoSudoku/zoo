package pl.cezaryregec.zoo.scenario.menu;

import org.junit.Test;
import pl.cezaryregec.zoo.scenario.PolishScenarioTest;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.actions.menu.GetMenuQuery;
import pl.cezaryregec.zoo.stages.given.AnimalRepositoryStage;
import pl.cezaryregec.zoo.stages.then.ActionOutcome;
import pl.cezaryregec.zoo.stages.when.ApplicationAction;

public class MenuTest extends PolishScenarioTest<AnimalRepositoryStage, ApplicationAction, ActionOutcome> {

    @Test
    public void menu() {
        kiedy().wybieramOpcję(ZooActionIndex.GET_MENU, GetMenuQuery.class);
        wtedy().wynikZawiera(
                "[GET_MENU] Menu dostępnych opcji",
                "[ADD_ANIMAL] Dodaj zwierzę",
                "[GET_ANIMALS] Wyświetl zwierzęta w ZOO",
                "[GET_ANIMALS_BY_TYPE] Wyświetl zwierzęta w ZOO filtrując po typie",
                "[REMOVE_ANIMAL] Usuń zwierzę",
                "[EXIT] Zakończ program"
        );
    }
}
