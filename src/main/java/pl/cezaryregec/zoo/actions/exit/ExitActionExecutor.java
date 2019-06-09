package pl.cezaryregec.zoo.actions.exit;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.exception.ExitStateRequestException;

public class ExitActionExecutor implements ActionExecutor<ExitQuery> {
    @Override
    public ResultDto execute(ExitQuery query) {
        throw new ExitStateRequestException();
    }
}
