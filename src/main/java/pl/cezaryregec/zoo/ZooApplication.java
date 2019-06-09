package pl.cezaryregec.zoo;

import pl.cezaryregec.zoo.actions.ActionFactory;
import pl.cezaryregec.zoo.actions.ZooActionFactory;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.console.ConsoleAdapter;
import pl.cezaryregec.zoo.console.ZooConsoleAdapter;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

public class ZooApplication {
    public static void main(String[] args) {
        ReflectionUtils.bind(ActionFactory.class, ZooActionFactory.class);
        ReflectionUtils.bind(ConsoleAdapter.class, ZooConsoleAdapter.class);

        ConsoleAdapter consoleAdapter = ReflectionUtils.getInstance(ConsoleAdapter.class);

        consoleAdapter.execute(ZooActionIndex.GET_MENU);
        while (consoleAdapter.isRunning()) {
            consoleAdapter.nextCommand();
        }
    }
}
