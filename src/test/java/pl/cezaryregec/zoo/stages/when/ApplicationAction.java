package pl.cezaryregec.zoo.stages.when;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Hidden;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.Table;
import org.mockito.Mockito;
import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.actions.ActionQuery;
import pl.cezaryregec.zoo.actions.ZooActionFactory;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.actions.animals.add.AddAnimalQuery;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.formatter.ActionQueryTableFormatterFactory;
import pl.cezaryregec.zoo.stages.PolishStage;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class ApplicationAction extends PolishStage<ApplicationAction> {
    @ProvidedScenarioState
    private ResultDto resultDto;

    @ProvidedScenarioState
    private Exception exception;

    public ApplicationAction wybieramOpcję(ZooActionIndex opcja, @Hidden Class<? extends ActionQuery> queryClass) {
        try {
            ZooActionFactory actionFactory = ReflectionUtils.createInstance(ZooActionFactory.class);
            ActionExecutor actionExecutor = actionFactory.create(opcja);
            ActionQuery query = Mockito.mock(queryClass);
            resultDto = actionExecutor.execute(query);
        } catch (Exception ex) {
            exception = ex;
        }
        return self();
    }

    public ApplicationAction wybieramOpcję$ZParametrami(ZooActionIndex opcja, @Table(rowFormatter = ActionQueryTableFormatterFactory.class) ActionQuery parametry) {
        try {
            ZooActionFactory actionFactory = ReflectionUtils.createInstance(ZooActionFactory.class);
            ActionExecutor actionExecutor = actionFactory.create(opcja);
            resultDto = actionExecutor.execute(parametry);
        } catch (Exception ex) {
            exception = ex;
        }
        return self();
    }
}
