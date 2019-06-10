package pl.cezaryregec.zoo;

import com.tngtech.jgiven.junit.ScenarioTest;

public class PolishScenarioTest<ZAKLADAJAC, KIEDY, WTEDY> extends ScenarioTest<ZAKLADAJAC, KIEDY, WTEDY> {
    public ZAKLADAJAC zakladajacZe() {
        return getScenario().given("Zakładając że");
    }

    public KIEDY kiedy() {
        return getScenario().when("Kiedy");
    }

    public WTEDY wtedy() {
        return getScenario().then("Wtedy");
    }
}
