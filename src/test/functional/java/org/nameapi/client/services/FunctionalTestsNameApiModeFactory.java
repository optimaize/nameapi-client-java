package org.nameapi.client.services;

import com.optimaize.command4j.Mode;
import com.optimaize.command4j.ext.extensions.logging.stdoutlogging.StdoutLoggingExtension;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.lib.NameApiModeFactory;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.context.ContextBuilder;
import org.nameapi.ontology5.input.context.Priority;

/**
 * @author Fabian Kessler
 */
public class FunctionalTestsNameApiModeFactory extends NameApiModeFactory {

    //Developer: set your api key here. It looks something like this:
    //private static final String API_KEY = "32d21gc5071d7463ef6064c07ea98cb2-user1";
    private static final String API_KEY = null;

    private static final Mode unitTestMode = withContext(API_KEY, makeContext())
            //.with(TimeoutExtension.TIMEOUT, Duration.millis(5000))
            .with(StdoutLoggingExtension.enabled())
    ;

    private static Context makeContext() {
        if (API_KEY==null) {
            throw new RuntimeException("Set the api key variable to run the functional tests (get it from nameapi.org)!");
        }
        return new ContextBuilder()
                .priority(Priority.REALTIME)
        .build();
    }

    @NotNull
    public static Mode functionalTest() {
        return unitTestMode;
    }

}
