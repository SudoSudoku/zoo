package pl.cezaryregec.zoo.actions.animals.get;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.actions.animals.AnimalTypeFactory;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.repository.AnimalRepository;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class GetAnimalsByTypeActionExecutor implements ActionExecutor<GetAnimalsByTypeQuery> {

    @Override
    public ResultDto execute(GetAnimalsByTypeQuery query) {
        AnimalRepository repository = ReflectionUtils.getInstance(AnimalRepository.class);
        Class<?> type = AnimalTypeFactory.create(query.getType());
        return ResultDto.of(repository.get(item -> item.getClass() == type));
    }
}
