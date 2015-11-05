package org.nameapi.client.services.nameparser.syntax;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.nameparser.NameParserResult;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 */
public class SyntaxBasedNameParserCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall() throws Exception {
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        List<NameParserRule> rules = makeRules();
        SyntaxBasedNameParserCommand command = new SyntaxBasedNameParserCommand();
        NameParserArgument nameparserArgument = new NameParserArgument("John Doe", rules);
//        NameParserResult parserResult = executor.execute(command, mode, nameparserArgument).get();
//        assertEquals(parserResult.getShortestItemCount(), 2);
    }

    private List<NameParserRule> makeRules() {
        return new RuleCollector()
                .add( new NameParserRule("natural-1.1", 100, "name:cat:surname(1,3) char:comma(1) name:cat:givenname(1)") )
                .add( new NameParserRule("natural-1.2", 100, "name:cat:givenname(1) name:cat:surname(1,3)") )
        .toList();
    }
}
