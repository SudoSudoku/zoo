package pl.cezaryregec.zoo.scenario.animals;

import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioStage;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.actions.animals.AnimalType;
import pl.cezaryregec.zoo.actions.animals.add.AddAnimalQuery;
import pl.cezaryregec.zoo.actions.animals.get.GetAnimalsByTypeQuery;
import pl.cezaryregec.zoo.actions.animals.get.GetAnimalsQuery;
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
    @Parameters({
            "GIRAFFE, Cezary, 2010, 2, 11, Żyrafa Cezary\\, urodzony 2010-02-11\\, żywy: tak",
            "ELEPHANT, Krzysztof, 1999, 8, 9, Słoń Krzysztof\\, urodzony 1999-08-09\\, żywy: tak"
    })
    public void dodanieZwierzęcia(AnimalType typ, String imię, Integer rokUrodzenia, Integer miesiącUrodzenia, Integer dzieńUrodzenia, @Quoted String wynik) {
        zakładającŻe().repozytoriumJestPuste();
        kiedy().wybieramOpcję$ZParametrami(ZooActionIndex.ADD_ANIMAL, AddAnimalQuery.builder()
                .type(typ)
                .name(imię)
                .yearOfBirth(rokUrodzenia)
                .monthOfBirth(miesiącUrodzenia)
                .dayOfBirth(dzieńUrodzenia)
                .build());
        wtedy().wynikZawieraTylko(wynik);
        repositoryOutcome
                .oraz().repozytoriumZawieraZwierzę(imię);
    }

    @Test
    public void nadpisanieZwierzęcia() {
        zakładającŻe().wRepozytoriumZnajdujeSię(AnimalPrototypes.createGiraffe("Andrzej"));
        kiedy().wybieramOpcję$ZParametrami(ZooActionIndex.ADD_ANIMAL, AddAnimalQuery.builder()
                .type(AnimalType.TIGER)
                .name("Andrzej")
                .yearOfBirth(2010)
                .monthOfBirth(9)
                .dayOfBirth(26)
                .build());
        wtedy().wynikZawieraTylko("Tygrys Andrzej, urodzony 2010-09-26, żywy: tak");
        repositoryOutcome
                .oraz().repozytoriumZawieraZwierzę("Andrzej")
                .oraz().$jestTygrysem("Andrzej");
    }

    @Test
    @Parameters({
            "TIGER, Grzegorz",
            "GIRAFFE, Alicja"
    })
    public void udaneUsunięcieZwierzęcia(AnimalType typ, String imię) {
        zakładającŻe().wRepozytoriumZnajdujeSię(AnimalPrototypes.create(typ, imię));
        kiedy().wybieramOpcję$ZParametrami(ZooActionIndex.REMOVE_ANIMAL, RemoveAnimalQuery.builder().name(imię).build());
        wtedy().wynikZawieraTylko("Usunięto zwierzę");
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
        wtedy().wynikZawieraTylko("Nie usunięto żadnego zwierzęcia");
    }

    @Test
    public void wyświetlenieWszystkichZwierząt() {
        zakładającŻe().wRepozytoriumZnajdujeSię(AnimalPrototypes.createElephant("Tadeusz"))
                .oraz().wRepozytoriumZnajdujeSię(AnimalPrototypes.createTiger("Ryszard"));
        kiedy().wybieramOpcję(ZooActionIndex.GET_ANIMALS, GetAnimalsQuery.class);
        wtedy().wynikZawieraTylko(
                "Słoń Tadeusz, urodzony 2000-01-01, żywy: tak",
                "Tygrys Ryszard, urodzony 2000-01-01, żywy: tak"
        );
    }

    @Test
    public void wyświetlenieZwierzątPoTypie() {
        zakładającŻe().wRepozytoriumZnajdujeSię(AnimalPrototypes.createElephant("Janusz"))
                .oraz().wRepozytoriumZnajdujeSię(AnimalPrototypes.createGiraffe("Anita"))
                .oraz().wRepozytoriumZnajdujeSię(AnimalPrototypes.createTiger("Piotr"));
        kiedy().wybieramOpcję$ZParametrami(ZooActionIndex.GET_ANIMALS_BY_TYPE, GetAnimalsByTypeQuery.builder()
                        .type(AnimalType.GIRAFFE)
                        .build()
        );
        wtedy().wynikZawieraTylko("Żyrafa Anita, urodzony 2000-01-01, żywy: tak");
    }
}
