package org.nameapi.client.services.nameparser.fieldnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;

import static org.testng.Assert.assertFalse;

/**
 * @author Fabian Kessler
 */
public class FieldNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    //Service currently not available as public API.
//    @Test
    public void testCall() throws Exception {
        FieldNameParserCommand command = new FieldNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NameField nameField = new NameField("Petra Müller", CommonNameFieldType.FULLNAME);
//        FieldNameParserResult result = executor.execute(command, mode, nameField).get();
//        assertFalse(result.getMatches().isEmpty());
    }

}
