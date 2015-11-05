package org.nameapi.client.services.formatter.personnameformatter;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.client.services.formatter.FormatterProperties;
import org.nameapi.client.services.formatter.FormatterPropertiesBuilder;
import org.nameapi.client.services.formatter.FormatterResult;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class PersonNameFormatterCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall() throws Exception {
        PersonNameFormatterCommand command = new PersonNameFormatterCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();

        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("petra müller")).build();
        FormatterProperties properties = new FormatterPropertiesBuilder().build();
        PersonNameFormatterArgument argument = new PersonNameFormatterArgument(person, properties);
        FormatterResult formatterResult = executor.execute(command, mode, argument).get();
        assertEquals(formatterResult.getFormatted(), "Petra Müller");
    }
}
