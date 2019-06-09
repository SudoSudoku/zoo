package pl.cezaryregec.zoo.dto.result;

import java.io.Serializable;

public class ResultDto<Result extends Serializable> {
    private final Result result;

    public ResultDto(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
