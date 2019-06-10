package pl.cezaryregec.zoo.scenario.shutdown;

import org.junit.Test;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.actions.shutdown.ShutdownQuery;
import pl.cezaryregec.zoo.scenario.PolishScenarioTest;
import pl.cezaryregec.zoo.stages.given.EmptyState;
import pl.cezaryregec.zoo.stages.then.ActionOutcome;
import pl.cezaryregec.zoo.stages.when.ApplicationAction;

public class ShutdownTest extends PolishScenarioTest<EmptyState, ApplicationAction, ActionOutcome> {
    @Test
    public void wyłączenieAplikacji() {
        kiedy().wybieramOpcję(ZooActionIndex.SHUTDOWN, ShutdownQuery.class);
        wtedy().nastąpiłWyjątekZakończeniaAplikacji();
    }
}
