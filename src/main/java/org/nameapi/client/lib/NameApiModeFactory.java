package org.nameapi.client.lib;

import com.optimaize.command4j.Mode;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.CombinedExceptionTranslator;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.ExceptionTranslationExtension;
import com.optimaize.soapworks.client.Keys;
import com.optimaize.soapworks.client.exensions.exceptiontranslation.DefaultClientExceptionTranslator;
import com.optimaize.soapworks.client.exensions.exceptiontranslation.SoapFaultExceptionTranslator;
import com.optimaize.soapworks.common.host.Host;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.ontology4.input.context.Context;

/**
 * Provides Mode instances that contain the minimum.
 *
 * @author Fabian Kessler
 */
public class NameApiModeFactory {

    private static final Mode minimalMode = Mode.create()
            .with(Keys.PORT_URL_FACTORY, new NameApiPortUrlFactory())
            .with(ExceptionTranslationExtension.TRANSLATOR, new CombinedExceptionTranslator(new DefaultClientExceptionTranslator(), new SoapFaultExceptionTranslator()))
            .with(Keys.HOST, new Host("api.nameapi.org", 80))
    ;

    /**
     * You can take this and extend for your setup if you need more.
     *
     * <p>Example: .with(StdoutLoggingExtension.enabled())</p>
     *
     * <p>If the minimal default is not exactly what you need, for example because you were given a different
     * host name, then create your own from scratch.</p>
     */
    @NotNull
    public static Mode minimal(Context context) {
        return minimalMode.with(NameApiKeys.CONTEXT, Conversions.convert(context));
    }
}
