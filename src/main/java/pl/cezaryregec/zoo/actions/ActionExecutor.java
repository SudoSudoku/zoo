package pl.cezaryregec.zoo.actions;

import pl.cezaryregec.zoo.dto.result.ResultDto;

public interface ActionExecutor<Query extends ActionQuery> {
    ResultDto execute(Query query);
}
