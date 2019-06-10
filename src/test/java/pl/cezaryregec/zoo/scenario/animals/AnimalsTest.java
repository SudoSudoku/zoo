package pl.cezaryregec.zoo.scenario.animals;

import com.tngtech.jgiven.annotation.ScenarioStage;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.actions.animals.AnimalType;
import pl.cezaryregec.zoo.actions.animals.add.AddAnimalQuery;
import pl.cezaryregec.zoo.actions.animals.remove.RemoveAnimalQuery;
import pl.cezaryregec.zoo.scenario.PolishScenarioTest;
import pl.cezaryregec.zoo.stages.given.AnimalPrototypes;
import pl.cezaryregec.zoo.stages.given.AnimalRepositoryStage;
import pl.cezaryregec.zoo.stages.then.ActionOutcome;
import pl.cezaryregec.zoo.stages.then.AnimalRepositoryOutcome;
import pl.cezaryregec.zoo.stages.when.ApplicationAction;

@RunWith(JUnitParamsRunner.class)
public class AnimalsTest extends PolishScenarioTest<AnimalRepositoryStage, ApplicationAction, ActionOutcome> {

    @ScenarioStage
    AnimalRepositoryOutcome repositoryOutcome;

    @Test
    public void dodanieZwierzęcia() {
        zakładającŻe().repozytoriumJestPuste();
        kiedy().wybieramOpcję$ZParametrami(ZooActionIndex.ADD_ANIMAL, AddAnimalQuery.builder()
                .type(AnimalType.GIRAFFE)
                .name("Cezary")
                .yearOfBirth(1950)
                .monthOfBirth(2)
                .dayOfBirth(11)
                .build());
        wtedy().wynikZawiera("Żyrafa Cezary, urodzony 1950-02-11, żywy: tak");
        repositoryOutcome
                .oraz().repozytoriumZawieraZwierzę("Cezary");
    }

    @Test
    @Parameters({
            "TIGER, Grzegorz",
            "GIRAFFE, Alicja"
    })
    public void udaneUsunięcieZwierzęcia(AnimalType typ, String imię) {
        zakładającŻe().wRepozytoriumZnajdujeSię(AnimalPrototypes.create(typ, imię));
        kiedy().wybieramOpcję$ZParametrami(ZooActionIndex.REMOVE_ANIMAL, RemoveAnimalQuery.builder().name(imię).build());
        wtedy().wynikZawiera("Usunięto zwierzę");
        repositoryOutcome
                .oraz().repozytoriumNieZawieraZwierzęcia(imię);
    }



    @Test
    @Parameters({
            "Grzegorz",
            "Alicja"
    })
    public void nieudaneUsunięcieZwierzęcia(String imię) {
        zakładającŻe().repozytoriumJestPuste();
        kiedy().wybieramOpcję$ZParametrami(ZooActionIndex.REMOVE_ANIMAL, RemoveAnimalQuery.builder().name(imię).build());
        wtedy().wynikZawiera("Nie usunięto żadnego zwierzęcia");
    }
}
