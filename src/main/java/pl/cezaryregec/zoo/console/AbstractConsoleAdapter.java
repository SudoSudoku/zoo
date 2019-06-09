package pl.cezaryregec.zoo.console;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.actions.ActionFactory;
import pl.cezaryregec.zoo.actions.ActionQuery;
import pl.cezaryregec.zoo.console.annotation.ReadableName;
import pl.cezaryregec.zoo.console.deserializers.BooleanDeserializationLink;
import pl.cezaryregec.zoo.console.deserializers.DeserializationLink;
import pl.cezaryregec.zoo.console.deserializers.IntegerDeserializationLink;
import pl.cezaryregec.zoo.console.deserializers.StringDeserializationLink;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.exception.ExitStateRequestException;
import pl.cezaryregec.zoo.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractConsoleAdapter<Actions extends ActionFactory, ActionIndex extends Enum<ActionIndex>> {
    private static final List<Class<? extends DeserializationLink>> DESERIALIZATION_CHAIN = Stream.of(
            StringDeserializationLink.class,
            IntegerDeserializationLink.class,
            BooleanDeserializationLink.class
    ).collect(Collectors.toList());

    private final Scanner SCANNER = new Scanner(System.in);
    protected final Actions actions;
    protected boolean isRunning = true;

    public AbstractConsoleAdapter(Actions actions) {
        this.actions = actions;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void shutDown() {
        this.isRunning = false;
        SCANNER.close();
    }

    public abstract void nextCommand();

    public void execute(ActionIndex index) {
        if (!isRunning) {
            throw new IllegalStateException("Console is shut down");
        }

        ActionExecutor actionExecutor = actions.create(index);
        Class<?> queryType = actionExecutor.getClass().getMethods()[0].getParameterTypes()[0];
        ActionQuery query = (ActionQuery) ReflectionUtils.createInstance(queryType);
        Field[] declaredFields = queryType.getDeclaredFields();

        for (Field field : declaredFields) {
            String name = field.getName();
            if (field.isAnnotationPresent(ReadableName.class)) {
                name = field.getAnnotation(ReadableName.class).value();
            }

            System.out.print(name + ": ");
            Class<?> type = field.getType();

            ReflectionUtils.setField(field, query, readInput(type));
        }

        try {
            ResultDto resultDto = actionExecutor.execute(query);
            System.out.println(format(resultDto));
        } catch(ExitStateRequestException exit) {
            shutDown();
        }
    }

    protected <T> T readInput(Class<T> type) {
        String input = SCANNER.nextLine();
        for (Class<? extends DeserializationLink> linkClass : DESERIALIZATION_CHAIN) {
            DeserializationLink link = ReflectionUtils.createInstance(linkClass);
            Object result = link.deserialize(input, type);

            if (result != null) {
                return (T) result;
            }
        }

        throw new IllegalStateException(type + " type not supported");
    }

    protected String format(ResultDto resultDto) {
        if (resultDto != null) {
            return resultDto.toString();
        }
        return "";
    }
}
