package pl.cezaryregec.zoo.actions;

import pl.cezaryregec.zoo.actions.animals.AddAnimalActionExecutor;
import pl.cezaryregec.zoo.actions.animals.GetAnimalsActionExecutor;
import pl.cezaryregec.zoo.actions.menu.GetMenuActionExecutor;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

public class ZooActionFactory implements ActionFactory<ZooActionIndex> {
    private static final Map<ZooActionIndex, Class<? extends ActionExecutor>> EXECUTOR_MAP = new HashMap<>();

    static {
        EXECUTOR_MAP.put(ZooActionIndex.GET_MENU, GetMenuActionExecutor.class);
        EXECUTOR_MAP.put(ZooActionIndex.ADD_ANIMAL, AddAnimalActionExecutor.class);
        EXECUTOR_MAP.put(ZooActionIndex.GET_ANIMALS, GetAnimalsActionExecutor.class);
    }

    public ActionExecutor create(ZooActionIndex zooActionIndex) {
        Class<? extends ActionExecutor> executorClass = EXECUTOR_MAP.get(zooActionIndex);

        if (executorClass != null) {
            return ReflectionUtils.getInstance(executorClass);
        }

        throw new IllegalStateException(String.format("%s is not supported", zooActionIndex));
    }
}
