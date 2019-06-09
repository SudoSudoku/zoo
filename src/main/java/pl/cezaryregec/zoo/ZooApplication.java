package pl.cezaryregec.zoo;

import pl.cezaryregec.zoo.actions.ZooActionFactory;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.console.ZooConsoleAdapter;

public class ZooApplication {
    public static void main(String[] args) {
        ZooActionFactory zooActionFactory = new ZooActionFactory();
        ZooConsoleAdapter consoleAdapter = new ZooConsoleAdapter(zooActionFactory);

        consoleAdapter.execute(ZooActionIndex.GET_MENU);
        while (consoleAdapter.isRunning()) {
            consoleAdapter.nextCommand();
        }
    }
}
