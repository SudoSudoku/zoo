package pl.cezaryregec.zoo.formatter;

import com.google.common.collect.Sets;
import com.tngtech.jgiven.annotation.Table;
import com.tngtech.jgiven.format.table.FieldBasedRowFormatter;
import com.tngtech.jgiven.impl.util.ReflectionUtil;
import pl.cezaryregec.zoo.console.annotation.ReadableName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ActionQueryRowFormatter extends FieldBasedRowFormatter {

    private List<Field> fields;

    public ActionQueryRowFormatter(Class<?> type, String parameterName, Table tableAnnotation, Annotation[] annotations) {
        super(type, parameterName, tableAnnotation, annotations);
        this.fields = getFields(tableAnnotation, type);
    }

    @Override
    public List<String> header() {
        return getFieldNames(this.fields);
    }

    private List<String> getFieldNames(Iterable<Field> fields) {
        return StreamSupport.stream(fields.spliterator(), false)
                .map(this::mapName)
                .collect(Collectors.toList());
    }

    private String mapName(Field field) {
        if (field.isAnnotationPresent(ReadableName.class)) {
            return field.getAnnotation(ReadableName.class).value();
        }

        return field.getName().replace('_', ' ');
    }

    private static List<Field> getFields(Table tableAnnotation, Class<?> type) {
        final Set<String> includeFields = Sets.newHashSet(tableAnnotation.includeFields());
        final Set<String> excludeFields = Sets.newHashSet(tableAnnotation.excludeFields());
        return ReflectionUtil.getAllNonStaticFields(type).stream().filter(input -> {
            String name = input.getName();
            if (!includeFields.isEmpty()) {
                return includeFields.contains(name);
            } else {
                return !excludeFields.contains(name);
            }
        }).collect(Collectors.toList());
    }
}

