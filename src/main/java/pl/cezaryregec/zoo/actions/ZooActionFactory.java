package pl.cezaryregec.zoo.actions;

import pl.cezaryregec.zoo.actions.menu.GetMenuActionExecutor;

public class ZooActionFactory implements ActionFactory<ZooActionIndex> {
    public ActionExecutor create(ZooActionIndex zooActionIndex) {
        if (zooActionIndex == ZooActionIndex.GET_MENU) {
            return new GetMenuActionExecutor();
        }

        throw new IllegalStateException(String.format("%s is not supported", zooActionIndex));
    }
}
