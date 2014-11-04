package org.nameapi.client.services.email.emailnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class EmailNameParserCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testParse_John_Doe() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "john.doe@gmail.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.PERSON_NAME);
        assertEquals(result.getBestNameMatch().get().getGivenNames().get(0).getName(), "john");
        assertEquals(result.getBestNameMatch().get().getSurnames().get(0).getName(), "doe");
    }

    @Test
    public void testParse_webmaster() throws Exception {
        EmailNameParserCommand command = new EmailNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        EmailNameParserResult result = executor.execute(command, mode, "webmaster@example.com").get();
        assertEquals(result.getResultType(), EmailAddressParsingResultType.FUNCTIONAL);
    }

}
