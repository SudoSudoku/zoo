package pl.cezaryregec.zoo.stages.given;

import com.tngtech.jgiven.annotation.BeforeStage;
import pl.cezaryregec.zoo.model.animal.Animal;
import pl.cezaryregec.zoo.repository.AnimalRepository;
import pl.cezaryregec.zoo.stages.PolishStage;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class AnimalRepositoryState extends PolishStage<AnimalRepositoryState> {
    @BeforeStage
    public void prepareRepository() {
        AnimalRepository repository = ReflectionUtils.getInstance(AnimalRepository.class);
        repository.removeAll();
    }

    public AnimalRepositoryState wRepozytoriumZnajdujeSię(Animal animal) {
        AnimalRepository repository = ReflectionUtils.getInstance(AnimalRepository.class);
        repository.add(animal);
        return self();
    }

    public AnimalRepositoryState repozytoriumJestPuste() {
        AnimalRepository repository = ReflectionUtils.getInstance(AnimalRepository.class);
        repository.removeAll();
        return self();
    }
}
