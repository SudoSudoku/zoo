package pl.cezaryregec.zoo.stages.when;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Hidden;
import org.mockito.Mockito;
import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.actions.ActionQuery;
import pl.cezaryregec.zoo.actions.ZooActionFactory;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class ApplicationAction extends Stage<ApplicationAction> {
    @ExpectedScenarioState
    private ResultDto resultDto;

    public ApplicationAction wybieramOpcje(ZooActionIndex opcja, @Hidden Class<? extends ActionQuery> queryClass) {
        ZooActionFactory actionFactory = ReflectionUtils.createInstance(ZooActionFactory.class);
        ActionExecutor actionExecutor = actionFactory.create(opcja);
        ActionQuery query = Mockito.mock(queryClass);
        resultDto = actionExecutor.execute(query);
        return self();
    }
}
