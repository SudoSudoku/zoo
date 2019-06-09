package pl.cezaryregec.zoo.dto.result;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ListResultDto<Result extends Serializable> extends ResultDto<Result> {
    private final List<Result> result;

    public ListResultDto(List<Result> result) {
        super(null);
        this.result = result;
    }

    @Override
    public String toString() {
        List<String> stringResultList = result.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        return String.join("\n", stringResultList);
    }
}
