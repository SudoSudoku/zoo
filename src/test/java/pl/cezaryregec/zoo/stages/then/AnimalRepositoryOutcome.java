package pl.cezaryregec.zoo.stages.then;

import com.tngtech.jgiven.annotation.Quoted;
import org.assertj.core.api.Assertions;
import pl.cezaryregec.zoo.model.animal.Animal;
import pl.cezaryregec.zoo.repository.AnimalRepository;
import pl.cezaryregec.zoo.stages.PolishStage;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class AnimalRepositoryOutcome extends PolishStage<AnimalRepositoryOutcome> {
    public AnimalRepositoryOutcome repozytoriumZawieraZwierzę(@Quoted String imię) {
        AnimalRepository animalRepository = ReflectionUtils.getInstance(AnimalRepository.class);
        Animal animal = animalRepository.get(imię);
        Assertions.assertThat(animal).isNotNull();
        return self();
    }

    public AnimalRepositoryOutcome repozytoriumNieZawieraZwierzęcia(@Quoted String imię) {
        AnimalRepository animalRepository = ReflectionUtils.getInstance(AnimalRepository.class);
        Animal animal = animalRepository.get(imię);
        Assertions.assertThat(animal).isNull();
        return self();
    }
}
