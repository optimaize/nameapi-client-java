package org.nameapi.client.lib;

import com.optimaize.anythingworks.client.common.Keys;
import com.optimaize.anythingworks.client.rest.RestKeys;
import com.optimaize.anythingworks.client.rest.RestPortUrlFactory;
import com.optimaize.anythingworks.common.host.Host;
import com.optimaize.anythingworks.common.host.Protocol;
import com.optimaize.command4j.Mode;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.context.Context;

/**
 * Provides Mode instances that contain the minimum.
 *
 * @author Fabian Kessler
 */
public class NameApiModeFactory {

    private static final Host DEFAULT_HOST = new Host("api.nameapi.org", Protocol.HTTPS);
    private static final NameApiPortUrlFactory DEFAULT_PORT_FACTORY = NameApiPortUrlFactory.versionLatestStable();


    /**
     * You can take this and extend for your setup if you need more.
     *
     * <p>Example: .with(StdoutLoggingExtension.enabled())</p>
     *
     * @param apiKey Your personal api key from registering with us.
     * @param host for example {@code new Host("api.nameapi.org", Protocol.HTTPS)}
     * @param portUrlFactory for example {@code NameApiPortUrlFactory.versionLatestStable()}
     */
    @NotNull
    public static Mode minimal(@NotNull String apiKey, @NotNull Host host, @NotNull RestPortUrlFactory portUrlFactory) {
        return Mode.create()
                .with(RestKeys.REST_PORT_URL_FACTORY, portUrlFactory)
//                .with(ExceptionTranslationExtension.TRANSLATOR, new CombinedExceptionTranslator(new DefaultClientExceptionTranslator(), new SoapFaultExceptionTranslator()))
                .with(Keys.HOST, host)
                .with(NameApiKeys.API_KEY, apiKey);
    }

    /**
     * Overloaded method that uses
     * for host: {@code new Host("api.nameapi.org", Protocol.HTTPS)}
     * for port url: {@code NameApiPortUrlFactory.versionLatestStable()}
     */
    @NotNull
    public static Mode minimal(@NotNull String apiKey) {
        return minimal(apiKey, DEFAULT_HOST, DEFAULT_PORT_FACTORY);
    }


    /**
     * You can take this and extend for your setup if you need more.
     *
     * <p>Example: .with(StdoutLoggingExtension.enabled())</p>
     *
     * @param apiKey Your personal api key from registering with us.
     * @param context for example {@code new ContextBuilder().priority(Priority.REALTIME).build()}
     * @param host for example {@code new Host("api.nameapi.org", Protocol.HTTPS)}
     * @param portUrlFactory for example {@code NameApiPortUrlFactory.versionLatestStable()}
     */
    @NotNull
    public static Mode withContext(@NotNull String apiKey, @NotNull Context context, @NotNull Host host, @NotNull RestPortUrlFactory portUrlFactory) {
        return minimal(apiKey, host, portUrlFactory)
                .with(NameApiKeys.CONTEXT, context);
    }

    /**
     * Overloaded method that uses:
     * for host: {@code new Host("api.nameapi.org", Protocol.HTTPS)}
     * for port url: {@code NameApiPortUrlFactory.versionLatestStable()}
     */
    @NotNull
    public static Mode withContext(@NotNull String apiKey, @NotNull Context context) {
        return withContext(apiKey, context, DEFAULT_HOST, DEFAULT_PORT_FACTORY);
    }

}
