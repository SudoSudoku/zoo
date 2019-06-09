package pl.cezaryregec.zoo.console;

import pl.cezaryregec.zoo.actions.ZooActionFactory;
import pl.cezaryregec.zoo.actions.ZooActionIndex;

public class ZooConsoleAdapter extends AbstractConsoleAdapter<ZooActionFactory, ZooActionIndex> {
    public ZooConsoleAdapter(ZooActionFactory zooActionFactory) {
        super(zooActionFactory);
    }

    @Override
    public void nextCommand() {
        if (!isRunning()) {
            throw new IllegalStateException("Console is shut down");
        }

        System.out.print("\nOpcja: ");
        String input = readInput(String.class);
        try {
            ZooActionIndex zooActionIndex = ZooActionIndex.valueOf(input);
            execute(zooActionIndex);
        } catch(IllegalArgumentException exception) {
            System.out.println("Nieznane polecenie");
        }
    }
}
