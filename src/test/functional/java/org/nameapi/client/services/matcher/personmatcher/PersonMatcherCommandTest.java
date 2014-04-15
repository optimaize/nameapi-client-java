package org.nameapi.client.services.matcher.personmatcher;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.ontology.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology.input.entities.person.NaturalInputPersonBuilder;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class PersonMatcherCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void test_equal() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Petra Müller")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("Petra Müller")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.EQUAL);
    }

    @Test
    public void test_matching() throws Exception {
        PersonMatcherCommand command = new PersonMatcherCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person1 = new NaturalInputPersonBuilder().name(makeName("Petra Müller")).build();
        NaturalInputPerson person2 = new NaturalInputPersonBuilder().name(makeName("Petra Mueller")).build();
        PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
        PersonMatcherResult result = executor.execute(command, mode, argument).get();
        assertEquals(result.getMatchType(), PersonMatchType.EQUAL);
    }

}
