package org.nameapi.client.services.email.emailnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.NameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class EmailNameParserCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = NameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "john.doe@gmail.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "john");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "doe");
    }
}
