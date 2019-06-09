package pl.cezaryregec.zoo.actions;

public interface ActionFactory<ActionIndex extends Enum<ActionIndex>> {
    ActionExecutor create(ActionIndex index);
}
