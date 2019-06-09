package pl.cezaryregec.zoo.actions.animals.get;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.repository.AnimalRepository;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class GetAnimalsActionExecutor implements ActionExecutor<GetAnimalsQuery> {
    @Override
    public ResultDto execute(GetAnimalsQuery query) {
        AnimalRepository repository = ReflectionUtils.getInstance(AnimalRepository.class);
        return ResultDto.of(repository.getAll());
    }
}
