package pl.cezaryregec.zoo.actions.animals.remove;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.repository.AnimalRepository;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

import java.util.Objects;

public class RemoveAnimalActionExecutor implements ActionExecutor<RemoveAnimalQuery> {
    @Override
    public ResultDto execute(RemoveAnimalQuery query) {
        AnimalRepository repository = ReflectionUtils.getInstance(AnimalRepository.class);
        boolean removed = repository.remove(item -> Objects.equals(item.getName(), query.getName()));
        if (removed) {
            return ResultDto.of("Usunięto zwierzę");
        } else {
            return ResultDto.of("Nie usunięto żadnego zwierzęcia");
        }
    }
}
