package pl.cezaryregec.zoo.stages.then;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Table;
import org.assertj.core.api.Assertions;
import pl.cezaryregec.zoo.dto.result.ResultDto;
import pl.cezaryregec.zoo.stages.PolishStage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActionOutcome extends PolishStage<ActionOutcome> {
    @ExpectedScenarioState
    private ResultDto resultDto;

    public ActionOutcome wynikZawiera(@Table(objectFormatting = Table.ObjectFormatting.PLAIN) String... wartości) {
        String[] values = resultDto.toString().split("\n");
        List<String> expected = Stream.of(wartości).collect(Collectors.toList());
        Assertions.assertThat(values).hasSameElementsAs(expected);
        return self();
    }
}
