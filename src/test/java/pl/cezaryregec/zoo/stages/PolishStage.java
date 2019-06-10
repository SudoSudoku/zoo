package pl.cezaryregec.zoo.stages;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.IntroWord;

public class PolishStage<SELF extends PolishStage<?>> extends Stage<SELF> {
    @IntroWord
    public SELF zakładającŻe() {
        return super.given();
    }

    @IntroWord
    public SELF kiedy() {
        return super.when();
    }

    @IntroWord
    public SELF wtedy() {
        return super.then();
    }

    @IntroWord
    public SELF oraz() {
        return super.and();
    }

    @IntroWord
    public SELF ale() {
        return super.but();
    }
}
