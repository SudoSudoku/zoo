package pl.cezaryregec.zoo.actions.menu;

import pl.cezaryregec.zoo.actions.ActionExecutor;
import pl.cezaryregec.zoo.actions.ZooActionIndex;
import pl.cezaryregec.zoo.dto.result.ListResultDto;
import pl.cezaryregec.zoo.dto.result.ResultDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetMenuActionExecutor implements ActionExecutor<GetMenuQuery> {
    @Override
    public ResultDto execute(GetMenuQuery query) {
        List<String> result = Stream.of(ZooActionIndex.values())
                .map(MenuItemFormatter::map)
                .collect(Collectors.toList());

        return ResultDto.of(result);
    }
}
