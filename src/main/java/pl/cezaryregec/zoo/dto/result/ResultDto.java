package pl.cezaryregec.zoo.dto.result;

import java.io.Serializable;
import java.util.List;

public class ResultDto<Result extends Serializable> {
    private final Result result;

    public ResultDto(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result.toString();
    }

    public static <T extends Serializable> ResultDto<T> of(List<T> list) {
        return new ListResultDto<>(list);
    }

    public static <T extends Serializable> ResultDto<T> of(T result) {
        return new ResultDto<T>(result);
    }
}
