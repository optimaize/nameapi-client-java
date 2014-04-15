package org.nameapi.client.services.parser.personnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.NameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.ontology.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology.output.entities.person.name.OutputPersonName;
import org.nameapi.ontology.output.entities.person.name.TermType;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall() throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = NameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Petra Müller")).build();
        PersonNameParserResult result = executor.execute(command, mode, person).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName firstName = parsedPerson.getNames().get(0);
        assertEquals("Petra", firstName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("Müller", firstName.getFirst(TermType.SURNAME).get().getString());
    }

}
