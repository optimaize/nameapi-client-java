package org.nameapi.client.services.validator.placeholdernamedetector;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * ...
 */
public class PlaceholderNameDetectorCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider="people")
    public void people(String gn, String sn, int minIncl, int maxIncl, FakeType fakeType) throws Exception {
        PlaceholderNameDetectorCommand command = new PlaceholderNameDetectorCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName(gn, sn)).build();
//        PlaceholderNameResult result = executor.execute(command, mode, person).get();
//        int points = result.getPoints();
//        assertTrue(points >= minIncl && points <= maxIncl);
//        assertEquals(result.getFakeType(), fakeType);
    }

    @DataProvider(name="people")
    public Object[][] people() {
        return new Object[][] {
                {"John",  "Doe",         90, 100, FakeType.PLACEHOLDER_NAME},
                {"Max",   "Mustermann",  90, 100, FakeType.PLACEHOLDER_NAME},
                {"Sandy", "Beach",       10,  90, FakeType.HUMEROUS_NAME},
        };
    }

}
