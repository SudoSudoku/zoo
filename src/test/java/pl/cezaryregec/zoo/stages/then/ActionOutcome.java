package pl.cezaryregec.zoo.stages.then;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Table;
import org.assertj.core.api.Assertions;
import pl.cezaryregec.zoo.dto.result.ResultDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActionOutcome extends Stage<ActionOutcome> {
    @ExpectedScenarioState
    private ResultDto resultDto;

    public ActionOutcome wynikZawiera(@Table(objectFormatting = Table.ObjectFormatting.PLAIN) String... wartosci) {
        String[] values = resultDto.toString().split("\n");
        List<String> expected = Stream.of(wartosci).collect(Collectors.toList());
        Assertions.assertThat(values).hasSameElementsAs(expected);
        return self();
    }
}
