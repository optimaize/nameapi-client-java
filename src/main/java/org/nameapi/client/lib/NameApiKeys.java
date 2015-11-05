package org.nameapi.client.lib;

import com.optimaize.command4j.lang.Key;
import org.nameapi.ontology5.input.context.Context;

/**
 * A place of keys used by this NameAPI library.
 */
public interface NameApiKeys {

    /**
     * The api key is required for any call to NameAPI services.
     * You must supply a valid context with the {@code mode} argument.
     */
    Key<String> API_KEY = Key.stringKey("apiKey");

    /**
     * The context is used as an optional argument by many of the NameApi services.
     * You can supply a context with the {@code mode} argument.
     */
    Key<Context> CONTEXT = Key.create("Context", Context.class);

}
