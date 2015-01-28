package org.nameapi.client.lib;

import com.optimaize.command4j.Mode;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.CombinedExceptionTranslator;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.ExceptionTranslationExtension;
import com.optimaize.soapworks.client.Keys;
import com.optimaize.soapworks.client.PortUrlFactory;
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

    private static final Host DEFAULT_HOST = new Host("api.nameapi.org", 80);
    private static final NameApiPortUrlFactory DEFAULT_PORT_FACTORY = NameApiPortUrlFactory.versionLatestStable();


    /**
     * You can take this and extend for your setup if you need more.
     *
     * <p>Example: .with(StdoutLoggingExtension.enabled())</p>
     *
     * @param context for example {@code new ContextBuilder().apiKey("your-api-key).priority(Priority.REALTIME).build()}
     * @param host for example {@code new Host("api.nameapi.org", 80)}
     * @param portUrlFactory for example {@code NameApiPortUrlFactory.versionLatestStable()}
     */
    @NotNull
    public static Mode minimal(@NotNull Context context, @NotNull Host host, @NotNull PortUrlFactory portUrlFactory) {
        return Mode.create()
                .with(Keys.PORT_URL_FACTORY, portUrlFactory)
                .with(ExceptionTranslationExtension.TRANSLATOR, new CombinedExceptionTranslator(new DefaultClientExceptionTranslator(), new SoapFaultExceptionTranslator()))
                .with(Keys.HOST, host)
                .with(NameApiKeys.CONTEXT, Conversions.convert(context));
    }

    /**
     * Overloaded method that uses
     * for host: {@code new Host("api.nameapi.org", 80)}
     * for port url: {@code NameApiPortUrlFactory.versionLatestStable()}
     */
    @NotNull
    public static Mode minimal(@NotNull Context context) {
        return minimal(context, DEFAULT_HOST, DEFAULT_PORT_FACTORY);
    }
}
