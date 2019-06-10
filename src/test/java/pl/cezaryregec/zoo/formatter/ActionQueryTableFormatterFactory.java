package pl.cezaryregec.zoo.formatter;

import com.tngtech.jgiven.annotation.Table;
import com.tngtech.jgiven.config.FormatterConfiguration;
import com.tngtech.jgiven.format.ObjectFormatter;
import com.tngtech.jgiven.format.table.RowFormatter;
import com.tngtech.jgiven.format.table.RowFormatterFactory;

import java.lang.annotation.Annotation;

public class ActionQueryTableFormatterFactory implements RowFormatterFactory {

    @Override
    public RowFormatter create(Class<?> aClass, String s, Table table, Annotation[] annotations, FormatterConfiguration formatterConfiguration, ObjectFormatter<?> objectFormatter) {
        return new ActionQueryRowFormatter(aClass, s, table, annotations);
    }
}
