package pl.cezaryregec.zoo.actions.shutdown;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.exception.ShutdownRequestException;

public class ShutdownActionExecutor implements ActionExecutor<ShutdownQuery> {
    @Override
    public ResultDto execute(ShutdownQuery query) {
        throw new ShutdownRequestException();
    }
}
