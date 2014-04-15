package org.nameapi.client.services.matcher.personmatcher;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.matcher.personmatcher.wsdl.*;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Compares two people and tells if and how they match.
 */
public class PersonMatcherCommand
        extends NameApiBaseCommand<SoapPersonMatcher, PersonMatcherArgument, PersonMatcherResult>
{

    private static final String servicePath = "/matcher/personmatcher";

    public PersonMatcherCommand() {
        super(SoapPersonMatcher.class);
    }

    @Override @NotNull
    public PersonMatcherResult call(@NotNull Optional<PersonMatcherArgument> arg, @NotNull ExecutionContext ec) throws Exception {
        PersonMatcherArgument argument = arg.get();
        SoapPersonMatcherResult result = getPort(ec).match(
                getContext(ec),
                Conversions.convert(argument.getInputPerson1()),
                Conversions.convert(argument.getInputPerson2())
        );
        return convert(result);
    }

    private PersonMatcherResult convert(SoapPersonMatcherResult result) {
        return new PersonMatcherResult(
                result.getMatchType(),
                result.getMatchComposition(),
                result.getPoints(),
                result.getConfidence(),
                convert(result.getPersonNameMatcherResult()),
                convert(result.getGenderMatcherResult()),
                convert(result.getAgeMatcherResult())
        );
    }

    private AgeMatcherResult convert(SoapAgeMatcherResult ageMatcherResult) {
        return new AgeMatcherResult(ageMatcherResult.getMatchType());
    }

    private PersonNameMatcherResult convert(SoapPersonNameMatcherResult personNameMatch) {
        return new PersonNameMatcherResult(personNameMatch.getMatchType());
    }

    private GenderMatcherResult convert(SoapGenderMatcherResult genderMatch) {
        return new GenderMatcherResult(genderMatch.getMatchType(), genderMatch.getConfidence(), genderMatch.getWarnings());
    }


    @NotNull @Override
    protected Callable<SoapPersonMatcher> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapPersonMatcher>() {
            @Override
            public SoapPersonMatcher call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapPersonMatcherService(url).getSoapPersonMatcherPort();
            }
        };
    }

}
