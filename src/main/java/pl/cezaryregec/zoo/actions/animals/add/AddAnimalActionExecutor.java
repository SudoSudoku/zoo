package pl.cezaryregec.zoo.actions.animals.add;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.model.animal.Animal;
import pl.cezaryregec.zoo.repository.AnimalRepository;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class AddAnimalActionExecutor implements ActionExecutor<AddAnimalQuery> {
    @Override
    public ResultDto execute(AddAnimalQuery query) {
        Animal animal = AnimalFactory.create(query);
        AnimalRepository animalRepository = ReflectionUtils.getInstance(AnimalRepository.class);
        animalRepository.add(animal);
        return ResultDto.of(animal);
    }
}
