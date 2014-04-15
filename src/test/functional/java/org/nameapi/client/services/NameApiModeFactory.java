package org.nameapi.client.services;

import com.optimaize.command4j.ext.extensions.logging.stdoutlogging.StdoutLoggingExtension;
import com.optimaize.soapworks.client.Keys;
import com.optimaize.command4j.Mode;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.CombinedExceptionTranslator;
import com.optimaize.soapworks.client.exensions.exceptiontranslation.DefaultClientExceptionTranslator;
import com.optimaize.soapworks.client.exensions.exceptiontranslation.SoapFaultExceptionTranslator;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.ExceptionTranslationExtension;
import com.optimaize.soapworks.common.host.Host;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.lib.NameApiKeys;
import org.nameapi.client.lib.NameApiPortUrlFactory;
import org.nameapi.ontology.input.context.Context;
import org.nameapi.ontology.input.context.ContextBuilder;
import org.nameapi.ontology.input.context.Priority;

/**
 * Provides Mode instances that contain the minimum.
 *
 * @author Fabian Kessler
 */
public class NameApiModeFactory {

    private static final String API_KEY = null;

    private static final Mode minimalMode = Mode.create()
            .with(Keys.PORT_URL_FACTORY, new NameApiPortUrlFactory())
            .with(ExceptionTranslationExtension.TRANSLATOR, new CombinedExceptionTranslator(new DefaultClientExceptionTranslator(), new SoapFaultExceptionTranslator()))
    ;

    private static final Mode unitTestMode = minimalMode
            .with(NameApiKeys.CONTEXT, Conversions.convert(makeContext()))
            .with(Keys.HOST, new Host("api.nameapi.org", 80)) //"192.168.1.220", 8080
            //.with(TimeoutExtension.TIMEOUT, Duration.millis(5000))
            .with(StdoutLoggingExtension.enabled())
    ;

    private static Context makeContext() {
        if (API_KEY==null) {
            throw new RuntimeException("Set the api key variable to run the functional tests (get it from nameapi.org)!");
        }
        return new ContextBuilder()
                .apiKey(API_KEY)
                .priority(Priority.REALTIME)
        .build();
    }

    @NotNull
    public static Mode functionalTest() {
        return unitTestMode;
    }

}
